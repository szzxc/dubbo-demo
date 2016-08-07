package com.fykj.dubbo.demo.consumer;

import com.alibaba.dubbo.rpc.service.EchoService;
import com.fykj.dubbo.demo.api.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2016/1/4.
 */
public class Consumer {
    public static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:consumer.xml"});
    public static DemoService demoService = (DemoService)context.getBean("demoService"); // 获取远程服务代理
    public static int count;
    public static void main(String[] args) throws Exception {
        context.start();
        for(int i = 0;i< 250;i++) {
            Thread t = new Thread(new Runnable() {

                public void run() {
                    String hello = demoService.sayHello("world" + ++count ); // 执行远程方法

                    System.out.println( hello ); // 显示调用结果
                }
            });
            t.start();
        }



        // 回声测试
//        EchoService echoService = (EchoService) demoService; // 强制转型为EchoService
//        String status = echoService.$echo("OK").toString(); // 回声测试可用性
//        System.out.println( status );
//        assert(status.equals("Ok"));
//

        System.in.read(); // 按任意键退出
    }


}
