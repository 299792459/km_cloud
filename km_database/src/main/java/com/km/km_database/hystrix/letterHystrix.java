package com.km.km_database.hystrix;

import com.km.km_database.controller.feigninterface.letterCI;
import com.km.km_database.dao.entity.letter;
import com.km.km_database.util.myResult;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 陈景
 * @create 2019/11/5 0005
 * @since 1.0.0
 */
@Component
public class letterHystrix implements letterCI {

    @Override
    public String add(letter Oletter) {
        return "服务被熔断，请排查错误";
    }

    @Override
    public String delete_id(int id) {
        return "服务被熔断，请排查错误";
    }

    @Override
    public String update_id(letter Oletter) {
        return "服务被熔断，请排查错误";
    }

    @Override
    public myResult select_id(int id) {
        return new myResult(0,"服务被熔断，请排查错误",null);
    }

    @Override
    public myResult select_list() {
        return new myResult(0,"服务被熔断，请排查错误",null);
    }

    @Override
    public myResult select_page(int page, int size) {
        return new myResult(0,"服务被熔断，请排查错误",null);
    }
}
