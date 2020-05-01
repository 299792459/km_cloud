package com.km.km_interaction.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.km.km_interaction.dao.entity.user;
import com.km.km_interaction.feigninterface.userCI;
import com.km.km_interaction.util.myResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 陈景
 * @QQ:895373488
 * @create 2020/4/25 0025
 * @since 1.0.0
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/test")
public class testfeign {
    @Autowired
    userCI ucf;

    @RequestMapping("/geta")
    public myResult delete_id(@RequestParam(value="id")int id){
        //根据前台传过来的id删除对应user
        return ucf.select_id(id);
    }
}
