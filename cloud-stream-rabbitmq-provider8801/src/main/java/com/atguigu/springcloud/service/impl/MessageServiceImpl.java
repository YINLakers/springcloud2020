package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.IMessageService;
import com.sun.javafx.scene.control.skin.DatePickerSkin;
import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.ObjectUtils;

import java.util.UUID;

/**
 * Created by chenpeng on 2020/11/6 17:16
 */
@EnableBinding(Source.class)
public class MessageServiceImpl implements IMessageService {

    @Autowired
    private MessageChannel output;  //消息发送通道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("***********serial:" + serial);
        return serial;
    }
}
