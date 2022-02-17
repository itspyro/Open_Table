package com.example.opentable.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.opentable.repository.dao.UserDao;
import com.example.opentable.service.UserService;
import com.example.opentable.transport.dto.CreateUserDto;
import com.example.opentable.transport.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public int createUser(CreateUserDto createUserDto) throws Exception {
		
		return userDao.createUser(createUserDto);
	}

	@Override
	public List<UserDto> findById(int userId) throws Exception {
		
		return userDao.findById(userId);
	}

}
