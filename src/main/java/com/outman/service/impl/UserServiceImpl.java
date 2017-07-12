package com.outman.service.impl;

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
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: outman
 * Date: 2017/7/7
 * Time: 下午9:20
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User findUserById(int id) throws Exception {

        return userDao.findUserById(id);
    }
}
