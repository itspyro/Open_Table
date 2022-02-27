package com.example.opentable.repository.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.opentable.repository.dao.AbstractParentDao;
import com.example.opentable.repository.dao.UserDao;
import com.example.opentable.repository.dao.Utilities;
import com.example.opentable.repository.entity.Photo;
import com.example.opentable.repository.entity.Restaurant;
import com.example.opentable.repository.entity.Role;
import com.example.opentable.repository.entity.User;
import com.example.opentable.transport.dto.CreatePhotoDto;
import com.example.opentable.transport.dto.LoginDto;
import com.example.opentable.transport.dto.RegisterUserDto;
import com.example.opentable.transport.dto.UpdateUserDto;
import com.example.opentable.transport.dto.UserDto;
import com.example.opentable.transport.dto.UserPhotoDto;

@Repository
public class UserDaoImpl extends AbstractParentDao<User> implements UserDao {
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int createUser(RegisterUserDto registerUserDto) throws Exception {
		int id;
		try {
			User user = Utilities.convertDtoIntoUser(registerUserDto);
			
			Query query = getEntityManager().createQuery("select u.userId from User u where u.userEmail = :email").setParameter("email",registerUserDto.getUserEmail());
			List<Integer> result = query.getResultList();
			
			if(result == null || result.isEmpty()) {
				Query query2 = getEntityManager().createQuery("select r from Role r where r.roleName = :name").setParameter("name",registerUserDto.getRoleName());
				Role role = (Role) query2.getSingleResult();
				
				user.setRole(role);
				getEntityManager().persist(user);
				id = user.getUserId();
			}
			else {
				id = -1;
			}
		} 
		catch (NoResultException e) {
			id = -2;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return id;
	}

	@Override
	public List<UserDto> findById(int userId) throws Exception {
		List<User> user = null;
		try {
	        Query query = getEntityManager().createQuery("select u from User u where u.userId = :id").setParameter("id",userId);
			user = (List<User>) query.getResultList();
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
					UserDto userDto = Utilities.convertUserIntoDto(userObj);
					userDtos.add(userDto);
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return userDtos;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int login(LoginDto loginDto) throws Exception {
		int userId;
		String password;
		try {
			Query query = getEntityManager().createQuery("select u.userId,u.password from User u where u.userEmail = :email").setParameter("email",loginDto.getUserEmail());
			Object[] result = (Object[]) query.getSingleResult();
			
			password = (String) result[1];
			
			if(password.equals(loginDto.getPassword())) {
				userId = (int) result[0];
			}
			else {
				userId = -1;
			}
		}
		catch (NoResultException e) {
			userId = -2;
		}
		catch (Exception e) {
			throw e;
		}
		return userId;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int updateUser(UpdateUserDto userDto) throws Exception {
		int updateId;
		try {
			User user = getEntityManager().getReference(User.class, userDto.getUserId());
			
			if(userDto.getUserName()!=null) {
				user.setUserName(userDto.getUserName());
			}
			if(userDto.getUserPhoneNumber()!=null) {
				user.setUserPhoneNumber(userDto.getUserPhoneNumber());
			}
			if(userDto.getRoleName()!=null) {
				Query query2 = getEntityManager().createQuery("select r from Role r where r.roleName = :name").setParameter("name",userDto.getRoleName());
				Role role = (Role) query2.getSingleResult();
				user.setRole(role);
			}
			
			getEntityManager().merge(user);
			
			updateId = user.getUserId();
			
		}
		catch (NoResultException e) {
			updateId = -1;
		}
		catch (EntityNotFoundException e) {
			updateId = -2;
		}
		catch (Exception e) {
			throw e;
		}
		return updateId;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void updatePhoto(UserPhotoDto photoDto) throws Exception {
		try {
			User user = getEntityManager().getReference(User.class, photoDto.getUserId());
			user.setProfilePhoto(photoDto.getPhotoUrl());
			getEntityManager().merge(user);
		} catch (Exception e) {
			throw e;
		}
	}
}
