package com.springboot.aristo.app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
@Table(name="usermapping")

public class UserMapping {
	
	@Id
	@Column(name="user_id")
	private Long id;
	private String role;
	private String name;
	@Column(name="ho_code")
	private String hocode;
	
	@Column(name="cf_code")
	private String cfcode;
	
	@Column(name="fs_code")
	private String fscode;
	
	@Column(name="stk_code")
	private String stkcode;
	
	private Boolean status;
	
    @OneToOne
    @MapsId
    @JoinColumn(name="user_id")
    @JsonBackReference
	private ApiUser user;
    
	
}
