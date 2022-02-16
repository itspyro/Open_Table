package com.example.opentable.repository.dao;

import java.util.List;

import com.example.opentable.transport.dto.RoleDto;

public interface RoleDao {
	public List<RoleDto> getRoles() throws Exception;

	public int createRole(RoleDto roleDto) throws Exception;

	public List<RoleDto> findById(int roleId) throws Exception;

	public int deleteRole(int roleId) throws Exception;
}
