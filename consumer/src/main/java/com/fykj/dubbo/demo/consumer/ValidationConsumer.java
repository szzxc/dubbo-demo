package com.fykj.dubbo.demo.consumer;

import com.alibaba.dubbo.container.page.pages.SystemPageHandler;
import com.alibaba.dubbo.rpc.RpcException;
import com.fykj.dubbo.demo.api.ValidationService;
import com.fykj.dubbo.demo.vo.ValidationParameter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

public class ValidationConsumer {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:consumer.xml");
        context.start();
        ValidationService validationService = (ValidationService)context.getBean("validationService");
        // Error
        try {
            ValidationParameter parameter = new ValidationParameter();
            parameter.setName("zxc");
            parameter.setAge(100);
            parameter.setEmail("1@1.com");
            //validationService.save(parameter);
            //validationService.update(parameter);
            validationService.delete(1);
            System.out.println("Validation Pass");

        } catch (RpcException e) { // 抛出的是RpcException
            ConstraintViolationException ve = (ConstraintViolationException) e.getCause(); // 里面嵌了一个ConstraintViolationException
            Set<ConstraintViolation<?>> violations = ve.getConstraintViolations(); // 可以拿到一个验证错误详细信息的集合
            System.out.println(violations);
        }
        System.in.read();
    }

}

