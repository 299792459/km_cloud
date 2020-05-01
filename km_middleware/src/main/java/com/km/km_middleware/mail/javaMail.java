package com.km.km_middleware.mail;


import com.km.km_middleware.hystrix.javaMailHystrix;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 〈一句话功能简述〉<br>
 * 〈邮件工具类〉
 *
 * @author 陈景
 * @QQ:895373488
 * @create 2020/4/6 0006
 * @since 1.0.0
 */
@Component
@EnableAutoConfiguration
@Service
@FeignClient(value = "mycloudprovider",fallback = javaMailHystrix.class)
public interface javaMail {
    //发送邮件
    @RequestMapping("/sendmail")
    public String sendmail(String reciver, String subject, String text);
}
