package com.bfs.backend.domain;

public class UserInternalPersonnel {
    private String FirstName;
    private String UserName;
    private String RoleName;
    private String Description;

    public UserInternalPersonnel(){

    }

    public UserInternalPersonnel(String FirstName, String UserName, String RoleName, String Description){
        this.setFirstName(FirstName);
        this.setUserName(UserName);
        this.setRoleName(RoleName);
        this.setDescription(Description);
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String roleName) {
        RoleName = roleName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
