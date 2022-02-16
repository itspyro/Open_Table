package com.example.opentable.transport;

import java.io.Serializable;
import java.util.List;

import com.example.opentable.transport.dto.RoleDto;

public class RoleDetailsRequestResponse extends ResponseMessage  implements Serializable {

	private static final long serialVersionUID = 5235980102009340977L;
	
	private List<RoleDto> roles;

	public RoleDetailsRequestResponse() {
		
	}

	public List<RoleDto> getRoles() {
		return roles;
	}
	
	public void setRoles(List<RoleDto> roles) {
		this.roles = roles;
	}

}