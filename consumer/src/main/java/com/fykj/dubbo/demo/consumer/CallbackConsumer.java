package com.fykj.dubbo.demo.consumer;

import com.fykj.dubbo.demo.api.CallbackListener;
import com.fykj.dubbo.demo.api.CallbackService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2016/1/7.
 */
public class CallbackConsumer {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:consumer.xml");
        context.start();

        CallbackService callbackService = (CallbackService) context.getBean("callbackService");

        callbackService.addListener("test", new CallbackListener() {
            public void changed(String msg) {
                System.out.println("callback1:--》" + msg);
            }
        });

    }
}
