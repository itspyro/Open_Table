package com.example.opentable.repository.ds.impl;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.opentable.repository.ds.AbstractParentDs;
import com.example.opentable.repository.ds.RoleDs;
import com.example.opentable.repository.entity.Role;
import com.example.opentable.transport.RoleDetailsRequestResponse;

@Repository
public class RoleDsImpl extends AbstractParentDs implements RoleDs{

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public RoleDetailsRequestResponse getRoles() throws Exception {
		List<Role> roles = null;
		try
		{
			roles = findAll();
			//System.out.println(roles);
			return convertRoleEntityIntoTo(roles, null);
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	private RoleDetailsRequestResponse convertRoleEntityIntoTo(List<Role> roles, Role role) throws Exception
	{
		RoleDetailsRequestResponse roleDetailsRequestResponse = null;
		try {
			if((roles!=null && roles.isEmpty()==false) || (role!=null))
			{
				roleDetailsRequestResponse=new RoleDetailsRequestResponse();
				if(roles!=null && roles.isEmpty()==false)
				{
					List<RoleDetailsRequestResponse> rolesToList = new ArrayList<>();
					RoleDetailsRequestResponse roleTo = null;
					for (Role roleObj: roles) {
						roleTo = new RoleDetailsRequestResponse();
						roleTo.setRoleId(roleObj.getRoleId());
						roleTo.setRoleName(roleObj.getRoleName());
						roleTo.setRolePriority(roleObj.getRolePriority());
						rolesToList.add(roleTo);
					}
					roleDetailsRequestResponse.setRoles(rolesToList);
				}
				else {
					roleDetailsRequestResponse.setRoleName(role.getRoleName());
					roleDetailsRequestResponse.setRoleId(role.getRoleId());
					roleDetailsRequestResponse.setRolePriority(role.getRolePriority());
					
				}
			}
				
		} catch (Exception e) {
			throw e;
		}
		return roleDetailsRequestResponse;
	}

}
