package com.bfs.backend.controller;

import com.bfs.backend.dao.UserDAO;
import com.bfs.backend.responseDomain.userInformation;

import com.bfs.backend.responseDomain.userLogin;
import com.bfs.backend.security.JwtTokenProvider;
import com.bfs.backend.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import java.util.HashMap;
import java.util.Map;


@RestController
public class LoginController {
    private UserServiceImpl userServiceImpl;

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    private UserDAO userDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Autowired
    public void setUserDetailsService(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }
    @PostMapping("/auth/signin")
    public ResponseEntity signin(@RequestBody userInformation ui) {
        try {
            String username = ui.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, ui.getPassword()));
            String token = jwtTokenProvider.createToken(username);
            Map<Object, Object> model = new HashMap<>();
            model.put("username", username);
            model.put("token", token);
            userInformation ui2=this.userServiceImpl.getUserByUsername(ui.getUsername());
            servletContext.setAttribute("userID",ui2.getUserID());
            return ResponseEntity.ok(model);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }
    @PostMapping("/login")
    public userLogin login(@RequestBody userInformation ui){
        userLogin ul=new userLogin();
        userInformation ui2=this.userServiceImpl.getUserByUsername(ui.getUsername());
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
