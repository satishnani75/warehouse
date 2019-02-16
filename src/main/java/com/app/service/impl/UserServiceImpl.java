package com.app.service.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.idao.IUserDao;
import com.app.model.User;
import com.app.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao dao;
	
	@Override
	@Transactional
	public Integer saveUser(User uobj) {
		
		return dao.saveUser(uobj);
	}

	@Transactional
	@Override
	public void updateUser(User uobj) {
		
		dao.updateuser(uobj);
	}
	
	

	@Transactional
	@Override
	public void deleteUser(Integer uid) {
		
		dao.deleteUser(uid);

	}

	@Transactional(readOnly=true)
	@Override
	public User getUserById(Integer uid) {
		
		return dao.getUserById(uid);
	}

	@Transactional(readOnly=true)
	@Override
	public List<User> getAllUsers() {
		
		return dao.getAllUsers();
	}

}
