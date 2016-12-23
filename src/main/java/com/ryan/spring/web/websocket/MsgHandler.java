package com.ryan.spring.web.websocket;

import com.alibaba.fastjson.JSON;
import com.ryan.spring.web.vo.MsgVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Random;
import java.util.Set;

/**
 * @Author Rayn
 * @Vendor liuwei412552703@163.com
 * Created by Rayn on 2016/12/23 16:08.
 */
public class MsgHandler  extends TextWebSocketHandler {

    private static final Logger LOG = LoggerFactory.getLogger(MsgHandler.class);


    private Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            Set<Integer> uids = SocketSessions.sessionMap.keySet();

            while (true) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                for (Integer uid : uids) {
                    WebSocketSession webSocketSession = SocketSessions.sessionMap.get(uid);
                    try {
                        MsgVo msgVo = new MsgVo(System.currentTimeMillis(), "测试发送消息");
                        webSocketSession.sendMessage(new TextMessage(JSON.toJSONString(msgVo)));

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    });

    /**
     * @param session
     * @param message
     * @throws Exception
     */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        super.handleTextMessage(session, message);

        LOG.info("接受到消息: {}", message.getPayload().toString());

        checkUserOnline(session);

    }

    /**
     * 建立连接后
     *
     * @param session
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);

        checkUserOnline(session);

    }

    /**
     * @param session
     * @param message
     * @throws Exception
     */
    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        super.handleMessage(session, message);

        LOG.info("接受到消息: {}", message.getPayload().toString());


    }


    /**
     * @param session
     * @param status
     * @throws Exception
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);


        LOG.info("Code : {}, Reason : {}", status.getCode(), status.getReason());

        Object userId = session.getAttributes().get("userId");

        if (null != userId) {
            SocketSessions.sessionMap.remove(userId);
        }
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        super.handleTransportError(session, exception);

        LOG.info("发送传输时异常: {}", exception.getCause());

    }


    /**
     * 用户在线检查，并启动线程发送消息
     *
     * @param session
     */
    public void checkUserOnline(WebSocketSession session) {
        if (null == session.getAttributes().get("userId")) {
            int uid = new Random(20).nextInt();
            SocketSessions.sessionMap.put(uid, session);
            session.getAttributes().put("userId", uid);

            thread.start();
        }

    }
}
