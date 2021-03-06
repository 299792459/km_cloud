package com.km.km_database.controller.feigninterface;


import com.km.km_database.dao.entity.order;
import com.km.km_database.hystrix.orderHystrix;
import com.km.km_database.util.myResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "orderCI",fallback = orderHystrix.class)
public interface orderCI {
    @RequestMapping("/add")
    public String add(@RequestParam(value = "order") order Oorder);

    @RequestMapping("/delete")
    public String delete_id(@RequestParam(value = "id") int id);

    @RequestMapping(value = "/update")
    public String update_id(@RequestParam(value = "order") order Oorder);


    @RequestMapping("/select/id")
    //value值对应前台的字段
    public myResult select_id(@RequestParam(value = "id", defaultValue = "0") int id);

    @RequestMapping("/select/list")
    public myResult select_list();

    @RequestMapping("/select/list/page")
    public myResult select_page(@RequestParam(value = "page", defaultValue = "1") int page,
                                @RequestParam(value = "size", defaultValue = "10") int size);


}
