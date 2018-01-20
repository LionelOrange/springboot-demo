package com.cc.controller;

import com.cc.model.User;
import com.cc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chencheng
 * @date 2018-01-20
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/getUser.do")
    public String getUser(Model model){
        User user = userService.getUser(1);
        model.addAttribute("user",user);
        return "user";
    }
    @RequestMapping("/getUserByPage.json")
    @ResponseBody
    public Map<String,Object> getUserByPage(){
        List<User> userByPage = userService.getUserByPage(1, 10);
        Map<String,Object> map=new HashMap<>();
        map.put("userList",userByPage);
        return map;
    }
}
