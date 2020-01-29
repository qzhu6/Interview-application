package com.bfs.backend.responseDomain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Getter
@Setter
public class userInformation implements java.io.Serializable, UserDetails {
    public userInformation(){
    }
    public userInformation(String username,String password,Integer userID){
        this.username=username;
        this.password=password;
        this.userID=userID;
    }

    public userInformation(String username,String password){
        this.username=username;
        this.password=password;
    }

    private String username;
    private String password;
    private Integer userID;
    private List<String> roles = new ArrayList();

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return (Collection)this.roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }
    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }


}
