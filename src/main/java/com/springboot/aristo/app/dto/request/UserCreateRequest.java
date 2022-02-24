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
	private String name;
	private String ho_code;
	private String cf_code;
	private String fs_code;
	private String stk_code;
	

}