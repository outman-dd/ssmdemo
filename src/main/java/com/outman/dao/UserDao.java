package com.outman.dao;

import com.outman.po.User;

/**
 * Created by zhangxiaoliang on 2017/7/12.
 */
public interface UserDao {
    User findUserById(int id) throws Exception;
}
