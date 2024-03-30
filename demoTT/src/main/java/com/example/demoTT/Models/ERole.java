package com.example.demoTT.Models;

public enum ERole {
    ADMIN, MODERATOR, USER;


    public String getAuthority() {
        return this.name();
    }
}
