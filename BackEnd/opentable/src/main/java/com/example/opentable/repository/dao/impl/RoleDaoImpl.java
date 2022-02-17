package com.example.opentable.repository.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.opentable.repository.dao.AbstractParentDao;
import com.example.opentable.repository.dao.RoleDao;
import com.example.opentable.repository.entity.Role;
import com.example.opentable.transport.dto.RoleDto;

@Repository
public class RoleDaoImpl extends AbstractParentDao<Role> implements RoleDao {
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public List<RoleDto> getRoles() throws Exception {
		List<Role> roles = null;
		try {
	        Query query = getEntityManager().createQuery("select r from Role r");
			roles = (List<Role>) query.getResultList();
			//System.out.println(roles);
			return convertRoleEntityIntoDtos(roles);
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	private List<RoleDto> convertRoleEntityIntoDtos(List<Role> roles) throws Exception {
		List<RoleDto> roleDtos = new ArrayList<>();
		try {
			if(roles!=null && roles.isEmpty()==false) {
				for (Role roleObj : roles) {
					RoleDto roleDto = new RoleDto();
					roleDto.setRoleId(roleObj.getRoleId());
					roleDto.setRoleName(roleObj.getRoleName());
					roleDto.setRolePriority(roleObj.getRolePriority());
					
					roleDtos.add(roleDto);
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return roleDtos;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int createRole(RoleDto roleDto) throws Exception {
		int id;
		try {
			Role role = new Role();
			role.setRoleName(roleDto.getRoleName());
			role.setRolePriority(roleDto.getRolePriority());
			getEntityManager().persist(role);
			id = role.getRoleId();
			//System.out.println(10/0);
			return id;
		} 
		catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public List<RoleDto> findById(int roleId) throws Exception {
		List<Role> role = null;
		try {
	        Query query = getEntityManager().createQuery("select r from Role r where r.roleId = :id").setParameter("id",roleId);
			role = (List<Role>) query.getResultList();
			//System.out.println(roles);
			return convertRoleEntityIntoDtos(role);
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	private RoleDto convertRoleEntityIntoDto(Role role) throws Exception {
		RoleDto roleDto = new RoleDto();
		try {
			if(role!=null) {
				roleDto.setRoleId(role.getRoleId());
				roleDto.setRoleName(role.getRoleName());
				roleDto.setRolePriority(role.getRolePriority());
			}
			else {
				roleDto = null;
			}
		} catch (Exception e) {
			throw e;
		}
		return roleDto;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int deleteRole(int roleId) throws Exception {
		int numberOfEntityDeleted = 0;
		try {
	        Query query = getEntityManager().createQuery("delete from Role r where r.roleId = :id").setParameter("id",roleId);
	        numberOfEntityDeleted = query.executeUpdate();
			return numberOfEntityDeleted;
		}
		catch (Exception e) {
			throw e;
		}
		
	}

}
	
