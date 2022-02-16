package com.example.opentable.transport.dto;

public class RoleDto {

	private Integer roleId;
	
	private String roleName;
	
	private Integer rolePriority;
	
	public RoleDto() {
	}

	public RoleDto(Integer roleId, String roleName, Integer rolePriority) {
		this.roleId = roleId;
		this.roleName = roleName;
		this.rolePriority = rolePriority;
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
