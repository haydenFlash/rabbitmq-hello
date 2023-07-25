package com.atguigu.one;

import com.atguigu.Rabbitmq;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


/**
 * @author lichenghu
 * @date 2023/5/29
 */
public class Producer {
    public static void main(String[] args) throws IOException, TimeoutException {
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
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare(Rabbitmq.QUEUE_NAME.getContent(), false, false, false, null);
        //生产消息
        channel.basicPublish("", Rabbitmq.QUEUE_NAME.getContent(), null, "hello world!".getBytes());
        System.out.println("消息发送完毕");
    }
}
