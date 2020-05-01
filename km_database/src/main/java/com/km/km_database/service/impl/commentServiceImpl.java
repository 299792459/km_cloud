package com.km.km_database.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.km.km_database.dao.entity.comment;
import com.km.km_database.dao.mapper.commentMapper;
import com.km.km_database.service.commentService;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 陈景
 * @QQ:895373488
 * @create 2020/4/4 0004
 * @since 1.0.0
 */
@Service
public class commentServiceImpl extends ServiceImpl<commentMapper, comment> implements commentService {
}
