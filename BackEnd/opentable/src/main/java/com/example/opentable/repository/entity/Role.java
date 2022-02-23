package com.example.opentable.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "roles")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column
	private int roleId;
	
	@Column
	private String roleName;
	
	@Column
	private int rolePriority;
	
	public Role() {
	}

	public Role(String roleName, int rolePriority) {
		this.roleName = roleName;
		this.rolePriority = rolePriority;
	}

	
	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public int getRolePriority() {
		return rolePriority;
	}

	public void setRolePriority(int rolePriority) {
		this.rolePriority = rolePriority;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", rolePriority=" + rolePriority + "]";
	}
	
}
