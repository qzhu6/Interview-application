//package com.bfs.backend.controller;
//
//import com.bfs.backend.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletResponse;
//
//@RestController
//public class testController {
//    private UserService userService;
//
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping("/Test")
//    public String test(){
//        System.out.println("testcanidate success");
//        userService.testCandidate();
//        return "Test";
//    }
//
//}
