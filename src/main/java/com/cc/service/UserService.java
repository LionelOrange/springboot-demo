package com.cc.service;

import com.cc.model.User;

import java.util.List;

/**
 * @author chencheng
 * @date 2018-01-20
 */
public interface UserService {
    User getUser(int i);

    List<User> getUserByPage(int pageNum,int pagesize);
}
