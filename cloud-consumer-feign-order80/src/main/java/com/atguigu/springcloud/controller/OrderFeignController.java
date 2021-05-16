package com.atguigu.springcloud.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by chenpeng on 2020/11/4 11:45
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        log.info("消费者调用查询方法");
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/timeout")
    public String paymentFeignTimeout() {
        log.info("调用超时方法");
        return paymentFeignService.paymentFeignTimeout();
    }

    @PostMapping("/consumer/payment/test")
    public JSONObject test(@RequestBody JSONObject parameter) {

        System.out.println("参数：" + parameter);
        JSONObject object = new JSONObject();
        object.put("name", "xiaomi");
        object.put("age", "10");

        log.info("消费者调用查询方法");

        return object;

    }

}
