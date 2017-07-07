package com.outman.service;

import com.outman.po.User;

/**
 * Created with IntelliJ IDEA.
 * User: outman
 * Date: 2017/7/7
 * Time: 下午9:20
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public interface UserService {
    public User findUserById(int id);
}
