package com.outman.po;

/**
 * Created with IntelliJ IDEA.
 * User: outman
 * Date: 2017/7/7
 * Time: 下午9:17
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class User {

    private Integer id;//用户id

    private String username;//用户名称

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
}
