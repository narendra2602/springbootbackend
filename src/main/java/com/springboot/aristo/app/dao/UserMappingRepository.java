package com.springboot.aristo.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.aristo.app.dto.UserMapping;

public interface UserMappingRepository extends JpaRepository<UserMapping, Long> {
	
	boolean existsByCfcodeOrFscodeOrStkcode(String cf_code,String fs_code,String stk_code);
	

}
