package com.km.km_middleware.messagequeue;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 陈景
 * @QQ:895373488
 * @create 2020/4/10 0010
 * @since 1.0.0
 */
@Component
@EnableAutoConfiguration
public interface rabbitMqSender {
    public void send(String s);
}
