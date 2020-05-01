package com.km.km_middleware.messagequeue.Impl;


import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 陈景
 * @QQ:895373488
 * @create 2020/4/9 0009
 * @since 1.0.0
 */

public class rabbitMqReceiverImpl {

    @RabbitListener(queues="kmqueue")    //监听器监听指定的Queue
    public void processC(String s) {
        System.out.println("\nReceive:" + s);
        //收到新发来的匹配请求，则将其加入匹配队列
    }
}
