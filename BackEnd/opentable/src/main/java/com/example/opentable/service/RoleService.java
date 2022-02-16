package com.example.opentable.service;

import java.util.List;

import com.example.opentable.transport.dto.RoleDto;

public interface RoleService {

	public List<RoleDto> getRoles() throws Exception;

	int deleteRole(int roleId) throws Exception;

	List<RoleDto> findById(int roleId) throws Exception;

	int createRole(RoleDto roleDto) throws Exception;
}
