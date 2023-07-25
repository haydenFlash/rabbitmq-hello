package com.atguigu;

/**
 * @author lichenghu
 * @date 2023/5/29
 */
public enum Rabbitmq {

    QUEUE_NAME( "hello"),
    RABBIT_IP( "192.168.56.10"),
    RABBIT_USER_NAME( "admin"),
    RABBIT_PASSWORD( "123");

    private String content;

    Rabbitmq(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
