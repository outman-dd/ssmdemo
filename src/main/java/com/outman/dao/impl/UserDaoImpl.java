package com.outman.dao.impl;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Joiner;
import com.outman.dao.UserDao;
import com.outman.mapper.UserMapper;
import com.outman.po.User;
import com.outman.service.UserService;
import com.outman.utils.FastjsonUtils;
import com.outman.utils.JedisUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: outman
 * Date: 2017/7/12
 * Time: 下午3:41
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private UserMapper userMapper;

    public User findUserById(int id) throws Exception{
        User user = null;
        //生成key，格式可以根据业务自行修改，但是必须得唯一
        String key = Joiner.on("_").join(Arrays.asList(id,id));

        try {
            //根据key获取从缓存中获取到value
            String value = JedisUtils.getInstance().get(key);
            //判断是否为空
            if (!StringUtils.isBlank(value)) {
                return JSON.parseObject(value, User.class);
            }
            user = userMapper.findUserById(id);
            //为空到情况下先从mysql查询数据，然后在set到redis中
            JedisUtils.getInstance().set(key, FastjsonUtils.toJSONString(user));
            //设置key的时效，时间以s为单位
            //JedisUtils.getInstance().expire(key, 10);

        } catch (Exception e) {
            throw e;
        }
        return user;
    }
}
