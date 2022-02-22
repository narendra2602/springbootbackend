package com.springboot.aristo.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.aristo.app.dao.StateDao;
import com.springboot.aristo.app.dto.State;
import com.springboot.aristo.app.service.StateService;

@Service
public class StateServiceImpl implements StateService {

	@Autowired
	private StateDao stateDao;
	
	@Override
	public List<State> getAllState() {
		return stateDao.findByOrderByLabelAsc();
	}

}
