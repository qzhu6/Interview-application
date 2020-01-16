//package com.bfs.backend.controller;
//
//import com.bfs.backend.domain.User1;
//import com.bfs.backend.security.CookieUtil;
//import com.bfs.backend.security.JwtUtil;
//import com.bfs.backend.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.http.HttpServletResponse;
//
//@Controller
//public class LoginController {
//    private UserService userService;
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
//
//    private static final String jwtTokenCookieName = "JWT-TOKEN";
//    private static final String signingKey = "signingKey";
//
//    @RequestMapping("/login")
//    public String login(){
//        return "login";
//    }
//
//    @PostMapping("/login")
//    public String login(HttpServletResponse httpServletResponse, String username, String password, String redirect, Model model){
//
//        System.out.println("login");
//        if (password == null || password.length() == 0) {
//            model.addAttribute("LogIninformation", "Invalid username or password!");
//            return "login";
//        }
//
//
//        if (username == null || username.length() == 0) {
//            model.addAttribute("LogIninformation", "Invalid username or password!");
//            return "login";
//        }
//
//        User1 user = null;
//        System.out.println(username +" "+ password);
//        if (username.indexOf('@') == -1) {
//            user = userService.getUserByNameOrEmail(username, "username");
//            System.out.println(username +" "+ password);
//
//        }else {
//            user = userService.getUserByNameOrEmail(username, "email");
//        }
//        System.out.println(username +" "+ password);
//
//        if (user == null) {
//            model.addAttribute("LogIninformation", "Invalid username or password!");
//            return "login";
//        }else {
//            if (!user.getPassword().equals(password)) {
//                model.addAttribute("LogIninformation", "Invalid username or password!");
//                return "login";
//            } else if (!user.getStatus().equals("Active")) {
//                model.addAttribute("LogIninformation", "cannot login");
//                return "login";
//            }
//        }
//        String token = JwtUtil.generateToken(signingKey, username);
//        CookieUtil.create(httpServletResponse, jwtTokenCookieName, token, false, -1, "localhost");
//        System.out.println("edirect1");
//        return "redirect:" + redirect;
//    }
//
//}
