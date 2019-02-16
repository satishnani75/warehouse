package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.idao.IUserDao;
import com.app.model.User;

@Repository
public class UserDaoImpl implements IUserDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveUser(User uobj) {
	
		
		
		return (Integer)ht.save(uobj);
	}

	@Override
	public void updateuser(User uobj) {
		
		ht.update(uobj);
		
	}

	@Override
	public void deleteUser(Integer uid) {
	
		
		ht.delete(new User(uid));
		
	}

	@Override
	public User getUserById(Integer uid) {
		
	
		
		return  ht.get(User.class, uid);
	}

	@Override
	public List<User> getAllUsers() {
		
		return ht.loadAll(User.class);
	}

}
