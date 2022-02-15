package com.example.opentable.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.opentable.repository.dao.RoleDs;
import com.example.opentable.service.RoleService;
import com.example.opentable.transport.RoleDetailsRequestResponse;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleDs roleDs;
	
	@Override
	public RoleDetailsRequestResponse getRoles() throws Exception {
		
		return roleDs.getRoles();
	}

}
