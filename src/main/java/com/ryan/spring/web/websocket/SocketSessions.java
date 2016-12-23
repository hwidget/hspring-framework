package com.ryan.spring.web.websocket;

import org.springframework.web.socket.WebSocketSession;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author Rayn
 * @Vendor liuwei412552703@163.com
 * Created by Rayn on 2016/12/23 9:15.
 */
public class SocketSessions {

    public static Map<Integer, WebSocketSession> sessionMap = new ConcurrentHashMap<Integer, WebSocketSession>();

}
