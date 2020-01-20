package com.bfs.backend.controller;

import com.bfs.backend.responseDomain.userInformation;

import com.bfs.backend.responseDomain.userLogin;
import com.bfs.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;


@RestController
public class LoginController {
    private UserService userService;
    @Autowired
    private ServletContext servletContext;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public userLogin login(@RequestBody userInformation ui){
        userLogin ul=new userLogin();
        userInformation ui2=userService.getUserByName(ui.getUsername());
        if (ui2==null){
            ul.setLoginStatus("No user name matching");
            ul.setUserName("a");
        }
        else{
            if(ui.getPassword().equals(ui2.getPassword())){
                ul.setLoginStatus("Success");
                ul.setUserName(ui.getUsername());
                servletContext.setAttribute("userID",ui2.getUserID());
            }
            else{
                ul.setLoginStatus("wrong password");
                ul.setUserName("a");
            }
        }
        return ul;

    }

}
