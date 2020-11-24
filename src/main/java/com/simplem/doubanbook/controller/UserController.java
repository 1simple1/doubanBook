package com.simplem.doubanbook.controller;

import com.alibaba.fastjson.JSON;
import com.simplem.doubanbook.model.User;
import com.simplem.doubanbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName: UserController
 * Package: com.simplem.doubanbook.controller
 * Description：
 * Author: simpleM
 * Date: 2020/11/23 11:38
 */
@CrossOrigin
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(User login){
        User user = userService.login(login);
        if(login != null){
            return null;
        }else {
            user.setPassword(null);
            return JSON.toJSONString(user);
        }
    }
}
