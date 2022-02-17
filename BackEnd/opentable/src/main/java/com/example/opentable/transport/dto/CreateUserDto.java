package com.example.opentable.transport.dto;

public class CreateUserDto extends UserDto {
	
	private Integer roleId;

	public CreateUserDto() {
		super();
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
}
