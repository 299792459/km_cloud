package com.km.km_middleware.hystrix;

import com.km.km_middleware.redis.redisService;

import java.util.List;
import java.util.Set;

/**
 * 〈一句话功能简述〉<br>
 * 〈服务熔断〉
 *
 * @author 陈景
 * @QQ:895373488
 * @create 2020/4/24 0024
 * @since 1.0.0
 */
public class redisHystrix implements redisService {
    @Override
    public boolean set(String var1, Object var2) {
        return false;
    }

    @Override
    public boolean set(String var1, Object var2, Long var3) {
        return false;
    }

    @Override
    public void remove(String... var1) {

    }

    @Override
    public void removePattern(String var1) {

    }

    @Override
    public void remove(String var1) {

    }

    @Override
    public boolean exists(String var1) {
        return false;
    }

    @Override
    public Object get(String var1) {
        return null;
    }

    @Override
    public void hmSet(String var1, Object var2, Object var3) {

    }

    @Override
    public Object hmGet(String var1, Object var2) {
        return null;
    }

    @Override
    public void lPush(String var1, Object var2) {

    }

    @Override
    public List<Object> lRange(String var1, long var2, long var4) {
        return null;
    }

    @Override
    public void add(String var1, Object var2) {

    }

    @Override
    public Set<Object> setMembers(String var1) {
        return null;
    }

    @Override
    public void zAdd(String var1, Object var2, double var3) {

    }

    @Override
    public Set<Object> rangeByScore(String var1, double var2, double var4) {
        return null;
    }
}
