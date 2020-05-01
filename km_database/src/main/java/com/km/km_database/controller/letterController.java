package com.km.km_database.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.km.km_database.controller.feigninterface.letterCI;
import com.km.km_database.dao.entity.letter;
import com.km.km_database.service.letterService;
import com.km.km_database.util.myResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 陈景
 * @QQ:895373488
 * @create 2019/11/16 0016
 * @since 1.0.0
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/letter")
@CrossOrigin
public class letterController implements letterCI {

    @Autowired
    letterService myletterService;

    //表的增删查改

    //统一定义返回值
    String result="";

    @RequestMapping("/add")
    public String add(@RequestParam(value="letter") letter Oletter){


        //根据前台传过来的letter添加
        try {

            //如果操作成功
            if(myletterService.save(Oletter)){
                // 修改返回值
                result="ok";
            }
            else {
                result="sorry,写入失败";
            }
        }catch (Exception e){
            e.printStackTrace();
            result=e.getMessage();
        }
        return result;
    }

    @RequestMapping("/delete")
    public String delete_id(@RequestParam(value="id")int id){
        //根据前台传过来的id删除对应letter
        try {
            if(myletterService.remove(new QueryWrapper<letter>().eq("letterid",id))){
                // 修改返回值
                result="ok";
            }else {
                // 修改返回值
                result="sorry,删除失败";
            }

        }catch (Exception e){
            // 修改返回值
            result=e.getMessage();
        }

        return result;
    }

    @RequestMapping(value = "/update")
    public String update_id(@RequestParam(value="letter")letter Oletter){
        try {
            //如果修改成功
            if(myletterService.update(new UpdateWrapper<letter>(Oletter)
                    .eq("letterid",Oletter.getLetterid()))){
                // 修改返回值
                result="ok";
            }
            else {
                result="sorry,修改失败";
            }
        }catch (Exception e){
            result=e.getMessage();
        }
        return result;
    }

    myResult MR=new myResult();
    @RequestMapping("/select/id")
    //value值对应前台的字段
    public myResult select_id(@RequestParam(value="id",defaultValue="0")int id){

        //通过id查询得到返回对象
        try {
            letter myletter=myletterService.getOne(new QueryWrapper<letter>().eq("letterid",id));
            //输出验证
            //System.out.println(letter.toString());
            if (myletter!=null){
                MR.setStatecode(1);
                MR.setMessage("ok");
                MR.setContent(myletter);
            } else {
                MR.setStatecode(0);
                MR.setMessage("sorry,查询失败");
                MR.setContent(null);
            }
        }catch (Exception e){
            MR.setStatecode(0);
            MR.setMessage(e.getMessage());
            MR.setContent(null);
        }

        return MR;
    }

    @RequestMapping("/select/list")
    public myResult select_list(){
        try {
            List<letter> letterlist=myletterService.list();
            //输出验证
            //System.out.println(letter.toString());
            if (letterlist!=null){
                MR.setStatecode(1);
                MR.setMessage("ok");
                MR.setContent(letterlist);
            } else {
                MR.setStatecode(0);
                MR.setMessage("sorry,查询失败");
                MR.setContent(null);
            }
        }catch (Exception e){
            MR.setStatecode(0);
            MR.setMessage(e.getMessage());
            MR.setContent(null);
        }

        return MR;
    }

    @RequestMapping("/select/list/page")
    public myResult select_page(@RequestParam(value="page",defaultValue="1")int page,
                                 @RequestParam(value="size",defaultValue="10")int size){
        List<letter> letterlist=myletterService.list();
        try {
            IPage<letter> commentPage=new Page<letter>(page,size);
            IPage<letter> resultpage = myletterService.page(commentPage,new QueryWrapper<letter>().isNotNull("letterid"));

            resultpage.setSize(size);
            resultpage.setCurrent(page);
            //将分页数据转化为list
            letterlist=resultpage.getRecords();
            System.out.println(letterlist);
            //输出验证
            //System.out.println(letter.toString());
            if (letterlist!=null){
                MR.setStatecode(1);
                MR.setMessage("ok");
                MR.setContent(letterlist);
            } else {
                MR.setStatecode(0);
                MR.setMessage("sorry,查询失败");
                MR.setContent(null);
            }
        }catch (Exception e){
            MR.setStatecode(0);
            MR.setMessage(e.getMessage());
            MR.setContent(null);
        }

        return MR;
    }

}
