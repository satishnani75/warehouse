package com.app.service;

import java.util.List;

import com.app.model.User;

public interface IUserService {

	
public Integer saveUser(User uobj);
	
	
	public void updateUser(User uobj);
	
	
	public void deleteUser(Integer uid);
	
	
	public User getUserById(Integer uid);
	
	
	public List<User> getAllUsers();


	
}
