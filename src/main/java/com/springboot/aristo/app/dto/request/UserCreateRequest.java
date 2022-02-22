package com.springboot.aristo.app.dto.request;
import lombok.Data;

@Data
public class UserCreateRequest {
    private String username;
    private String password;
    private String role;
    private String email;
    private long phone;
    private String city;
    private int state;
}