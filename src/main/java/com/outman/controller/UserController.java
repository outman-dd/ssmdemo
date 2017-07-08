package com.outman.controller;

import com.outman.po.User;
import com.outman.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: outman
 * Date: 2017/7/7
 * Time: 下午9:21
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/userQuery")
    public ModelAndView userQuery() throws Exception {

        //查询id为1的用户
        User user = userService.findUserById(1);

        ModelAndView modelAndView = new ModelAndView();

        if(user!=null){
            modelAndView.addObject("username", user.getUsername());
        }

        modelAndView.setViewName("test");

        return modelAndView;

    }
}
