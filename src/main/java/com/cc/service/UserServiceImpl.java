package com.cc.service;

import com.cc.mapper.UserMapper;
import com.cc.model.User;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chencheng
 * @date 2018-01-20
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUser(int i) {
        return userMapper.selectByPrimaryKey(i);
    }

    @Override
    public List<User> getUserByPage(int pageNum, int pagesize) {
        PageHelper.startPage(pageNum,pagesize);
        return userMapper.queryAll();
    }
}
