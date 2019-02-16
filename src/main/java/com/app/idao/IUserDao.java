package com.app.idao;

import java.util.List;

import com.app.model.User;

public interface IUserDao {

	
	public Integer saveUser(User uobj);
	
	
	public void updateuser(User uobj);
	
	
	public void deleteUser(Integer uid);
	
	
	public User getUserById(Integer uid);
	
	
	public List<User> getAllUsers();
	
}
