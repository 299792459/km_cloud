package com.km.km_middleware.mail.Impl;


import com.km.km_middleware.util.commonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
@FeignClient(value = "mycloudprovider",fallback = AuthFeignServiceFallbackImpl.class)
public class javaMailImpl {
    @Autowired
    JavaMailSenderImpl mailSender;

    @Autowired
    commonUtil cu;

    //发送邮件
    public String sendmail(String reciver, String subject, String text) {
        try {
            //通过线程发送邮件，保证返回的及时性
            Thread kmsendmailthread=new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
                            simpleMailMessage.setFrom("895373488@qq.com");
                            simpleMailMessage.setTo(reciver);
                            simpleMailMessage.setSubject(subject);
                            simpleMailMessage.setText(text);
                            mailSender.send(simpleMailMessage);
                        }
                    }
            );
            kmsendmailthread.start();

        } catch (Exception e) {
            System.out.println("发送失败");
            e.printStackTrace();

            return "发送失败";
        }

        System.out.println("发送成功");
        return "发送成功";
    }

}
