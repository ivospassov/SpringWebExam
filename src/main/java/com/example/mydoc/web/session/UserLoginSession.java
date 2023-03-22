package com.example.mydoc.web.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Component
public class UserLoginSession {

    private Long id;
    private String username;

    public UserLoginSession() {}
    public void loginUser(Long id, String username) {
        this.id = id;
        this.username = username;
    }
    public void logoutUser() {
        this.id = null;
        this.username = null;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
}
