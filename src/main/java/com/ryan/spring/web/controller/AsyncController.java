package com.ryan.spring.web.controller;

import com.ryan.spring.web.callback.LongTermTaskCallback;
import com.ryan.spring.web.callback.LongTimeAsyncCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.WebAsyncTask;
import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.Callable;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/22 11:21.
 */
@Controller
@RequestMapping("/async")
public class AsyncController extends BaseController {

    @Autowired
    private LongTimeAsyncCallService longTimeAsyncCallService;


    @RequestMapping(value = "/asynctask", method = RequestMethod.GET)
    public DeferredResult<ModelAndView> asyncTask() {
        final DeferredResult<ModelAndView> deferredResult = new DeferredResult<ModelAndView>();
        System.out.println("/asynctask 调用！thread id is : " + Thread.currentThread().getId());


        longTimeAsyncCallService.makeRemoteCallAndUnknownWhenFinish(new LongTermTaskCallback() {
            @Override
            public void callback(Object result) {
                System.out.println("异步调用执行完成, thread id is : " + Thread.currentThread().getId());
                ModelAndView mav = new ModelAndView("remotecalltask");
                mav.addObject("result", result);
                deferredResult.setResult(mav);
            }
        });

        /**
         * 超时后处理
         */
        deferredResult.onTimeout(new Runnable() {
            @Override
            public void run() {
                System.out.println("异步调用执行超时！thread id is : " + Thread.currentThread().getId());
                ModelAndView mav = new ModelAndView("remotecalltask");
                mav.addObject("result", "异步调用执行超时");
                deferredResult.setResult(mav);
            }
        });

        return deferredResult;
    }

    /**
     * 异步执行任务，省去了手动调用callback 的步骤
     *
     * @return
     */
    @RequestMapping(value = "/longtimetask", method = RequestMethod.GET)
    public WebAsyncTask longTimeTask() {
        System.out.println("/longtimetask被调用 thread id is : " + Thread.currentThread().getId());
        Callable<ModelAndView> callable = new Callable<ModelAndView>() {
            public ModelAndView call() throws Exception {
                Thread.sleep(3000); //假设是一些长时间任务
                ModelAndView mav = new ModelAndView("longtimetask");
                mav.addObject("result", "执行成功");
                System.out.println("执行成功 thread id is : " + Thread.currentThread().getId());
                return mav;
            }
        };

        /**
         * 等待 2 s 发生超时
         */
        WebAsyncTask asyncTask = new WebAsyncTask(2000, callable);
        asyncTask.onTimeout(new Callable<ModelAndView>() {
            public ModelAndView call() throws Exception {
                ModelAndView mav = new ModelAndView("longtimetask");
                mav.addObject("result", "执行超时");
                System.out.println("执行超时 thread id is ：" + Thread.currentThread().getId());
                return mav;
            }
        });
        return new WebAsyncTask(3000, callable);
    }

}
