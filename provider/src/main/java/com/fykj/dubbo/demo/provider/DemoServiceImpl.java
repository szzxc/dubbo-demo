package com.fykj.dubbo.demo.provider;

import com.fykj.dubbo.demo.api.DemoService;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/1/4.
 */
@Service(value = "demoService")
public class DemoServiceImpl implements DemoService {
    public String sayHello(String name) {
        System.out.println(name);
        return "Hello " + name;
    }
}
