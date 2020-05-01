package com.km.km_middleware.util;


import com.km.km_middleware.redis.Impl.RedisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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
public class mailUtil {


    @Autowired
    JavaMailSenderImpl mailSender;

    @Autowired
    RedisServiceImpl myRedis;

    @Autowired
    commonUtil cu;

    //获取邮箱验证
    public myResult getVCByEmail(String email){

        //先生成验证码
        String  Verificationcode =new myrandom().generatecode();
        //存入redis
        myRedis.set(email,Verificationcode);
        //System.out.println("取出的职位"+myRedis.get("895373488"));
        //通过消息队列，异步发送邮件通知
        try {
            sendmail(email,"您的验证码为：",Verificationcode);
            return new myResult(1,"验证码邮件已发送，请注意查收",null);
        }catch (Exception e){
            e.printStackTrace();
            return new myResult(0,"对不起，邮件发送失败，请刷新后重试",null);
        }

    }
}
