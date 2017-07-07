package com.outman.service.impl;

import com.outman.mapper.UserMapper;
import com.outman.po.User;
import com.outman.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: outman
 * Date: 2017/7/7
 * Time: 下午9:20
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    public User findUserById(int id) {

        return userMapper.findUserById(id);
    }
}
