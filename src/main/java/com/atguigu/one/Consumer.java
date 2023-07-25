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
public class Consumer {
    public static void main(String[] args) throws IOException, TimeoutException {
        //创建工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置主机ip
        factory.setHost(Rabbitmq.RABBIT_IP.getContent());
        //设置用户名
        factory.setUsername(Rabbitmq.RABBIT_USER_NAME.getContent());
        //设置密码
        factory.setPassword(Rabbitmq.RABBIT_PASSWORD.getContent());
        //创建MQ连接
        Connection connection = factory.newConnection();
        //创建信道
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare(Rabbitmq.QUEUE_NAME.getContent(), false, false, false, null);
        //消费消息
        channel.basicConsume(Rabbitmq.QUEUE_NAME.getContent(), true,
                (consumerTag, message) -> {
                    System.out.println("接收成功");
                    System.out.println(new String(message.getBody()));
                },
                consumerTag -> System.out.println("消费被中断"));
    }
}
