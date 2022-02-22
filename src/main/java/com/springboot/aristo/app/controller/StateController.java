package com.springboot.aristo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.aristo.app.dto.State;
import com.springboot.aristo.app.service.StateService;

@RestController
@CrossOrigin
@RequestMapping("/api/state")
public class StateController {

	@Autowired
	private StateService stateServices;
	
	@GetMapping
	public ResponseEntity<List<State>> getAllState()
	{
		return new ResponseEntity<List<State>>(stateServices.getAllState(),HttpStatus.OK);
	}
	

	
	
	
}
