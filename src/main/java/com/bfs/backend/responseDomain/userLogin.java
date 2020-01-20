package com.bfs.backend.responseDomain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class userLogin implements java.io.Serializable{
    public userLogin(){
    }
    private String LoginStatus;
    private String UserName;

    @Override
    public String toString() {
        return "userLogin{" +
                "LoginStatus='" + LoginStatus + '\'' +
                ", UserName='" + UserName + '\'' +
                '}';
    }
}
