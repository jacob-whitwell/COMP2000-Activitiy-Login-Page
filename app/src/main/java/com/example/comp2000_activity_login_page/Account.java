package com.example.comp2000_activity_login_page;

public class Account {

    private String username;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public Account(String username, String password)
    {
        this.username = username;
        this.password = password;
    }


}
