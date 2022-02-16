package com.example.opentable.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.opentable.repository.dao.RoleDao;
import com.example.opentable.service.RoleService;
import com.example.opentable.transport.dto.RoleDto;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleDao roleDao;
	
	@Override
	public List<RoleDto> getRoles() throws Exception {
		
		return roleDao.getRoles();
	}

	@Override
	public int createRole(RoleDto roleDto) throws Exception {
		
		return roleDao.createRole(roleDto);
	}

	@Override
	public List<RoleDto> findById(int roleId) throws Exception {
		
		return roleDao.findById(roleId);
	}

	@Override
	public int deleteRole(int roleId) throws Exception {
		return roleDao.deleteRole(roleId);
	}
	
}