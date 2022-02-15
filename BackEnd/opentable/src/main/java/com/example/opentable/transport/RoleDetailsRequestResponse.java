package com.example.opentable.transport;

import java.io.Serializable;
import java.util.List;

public class RoleDetailsRequestResponse extends ResponseMessage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2592567727353089011L;
	private Integer roleId;
	private String roleName;
	private Integer rolePriority;
	
	private List<RoleDetailsRequestResponse> roles;
	
	public List<RoleDetailsRequestResponse> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleDetailsRequestResponse> roles) {
		this.roles = roles;
	}

	public RoleDetailsRequestResponse() {
		
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getRolePriority() {
		return rolePriority;
	}

	public void setRolePriority(Integer rolePriority) {
		this.rolePriority = rolePriority;
	}
}
