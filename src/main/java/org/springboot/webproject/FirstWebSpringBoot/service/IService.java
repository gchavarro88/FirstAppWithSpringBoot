 package org.springboot.webproject.FirstWebSpringBoot.service;

import java.util.List;

import org.springboot.webproject.FirstWebSpringBoot.model.User;

public interface IService {

	public User findById(int id);
	
	public User findByName(String name);
	
	public List<User> saveUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUserById(int id);
	
	public void deleteAllUser();
	
	public List<User> readAllUser();
	
	public boolean isUserExist(User user);
		
}
