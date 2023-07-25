package com.atguigu.utils;

import com.atguigu.Rabbitmq;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author lichenghu
 * @date 2023/5/30
 */
public class RabbitMqUtil {

    /**
     * 获取连接工厂创建的信道
     */
    public static Channel getChannel() throws IOException, TimeoutException {
        //创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置主机ip
        factory.setHost(Rabbitmq.RABBIT_IP.getContent());
        //设置用户名
        factory.setUsername(Rabbitmq.RABBIT_USER_NAME.getContent());
        //设置密码
        factory.setPassword(Rabbitmq.RABBIT_PASSWORD.getContent());
        //创建连接
        Connection connection = factory.newConnection();
        //获取信道
        return connection.createChannel();
    }
}
