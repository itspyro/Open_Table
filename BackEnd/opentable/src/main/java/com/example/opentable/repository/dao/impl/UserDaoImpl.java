package com.example.opentable.repository.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.opentable.repository.dao.AbstractParentDao;
import com.example.opentable.repository.dao.UserDao;
import com.example.opentable.repository.entity.Role;
import com.example.opentable.repository.entity.User;
import com.example.opentable.transport.dto.CreateUserDto;
import com.example.opentable.transport.dto.UserDto;

@Repository
public class UserDaoImpl extends AbstractParentDao<User> implements UserDao {
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int createUser(CreateUserDto createUserDto) throws Exception {
		int id;
		try {
			User user = new User();
			user.setUserName(createUserDto.getUserName());
			user.setUserFirstName(createUserDto.getUserFirstName());
			user.setUserLastName(createUserDto.getUserLastName());
			user.setUserEmail(createUserDto.getUserEmail());
			user.setPassword(createUserDto.getPassword());
			user.setUserPhoneNumber(createUserDto.getUserPhoneNumber());
			user.setUserAddress(createUserDto.getUserAddress());
			
			Role role = getEntityManager().getReference(Role.class, createUserDto.getRoleId());
			user.setRole(role);
			
			getEntityManager().persist(user);
			id = user.getUserId();
			
			return id;
		} 
		catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<UserDto> findById(int userId) throws Exception {
		List<User> user = null;
		try {
	        Query query = getEntityManager().createQuery("select u from User u where u.userId = :id").setParameter("id",userId);
			user = (List<User>) query.getResultList();
			//System.out.println((List<User>) query.getResultList());
			return convertUserEntityIntoDtos(user);
		}
		catch (Exception e) {
			throw e;
		}
	}

	private List<UserDto> convertUserEntityIntoDtos(List<User> users) throws Exception {
		List<UserDto> userDtos = new ArrayList<>();
		try {
			if(users!=null && users.isEmpty()==false) {
				for (User userObj : users) {
					UserDto userDto = new UserDto();
					userDto.setUserId(userObj.getUserId());
					userDto.setUserName(userObj.getUserName());
					userDto.setUserFirstName(userObj.getUserFirstName());
					userDto.setUserLastName(userObj.getUserLastName());
					userDto.setUserEmail(userObj.getUserEmail());
					userDto.setPassword(userObj.getPassword());
					userDto.setUserPhoneNumber(userObj.getUserPhoneNumber());
					userDto.setUserAddress(userObj.getUserAddress());
					
					userDtos.add(userDto);
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return userDtos;
	}

}
