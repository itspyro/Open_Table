package com.example.opentable.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.opentable.repository.dao.UserDao;
import com.example.opentable.service.UserService;
import com.example.opentable.transport.dto.LoginDto;
import com.example.opentable.transport.dto.RegisterUserDto;
import com.example.opentable.transport.dto.UpdateUserDto;
import com.example.opentable.transport.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public int createUser(RegisterUserDto registerUserDto) throws Exception {
		
		return userDao.createUser(registerUserDto);
	}

	@Override
	public List<UserDto> findById(int userId) throws Exception {
		
		return userDao.findById(userId);
	}

	@Override
	public int login(LoginDto loginDto) throws Exception {
		
		return userDao.login(loginDto);
	}

	@Override
	public int updateUser(UpdateUserDto userDto) throws Exception {
		
		return userDao.updateUser(userDto);
	}

}
