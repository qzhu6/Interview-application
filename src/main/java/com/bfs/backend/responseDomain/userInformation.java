package com.bfs.backend.responseDomain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class userInformation implements java.io.Serializable{
    public userInformation(){
    }
    private String username;
    private String password;
    private Integer userID;


}
