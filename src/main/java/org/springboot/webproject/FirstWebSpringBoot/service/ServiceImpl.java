package org.springboot.webproject.FirstWebSpringBoot.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springboot.webproject.FirstWebSpringBoot.model.User;
import org.springframework.stereotype.Service;

@Service("IService")
public class ServiceImpl implements IService {

	private static final AtomicLong counter = new AtomicLong();
	private static List<User> users;
	
	static{
		users= populateDummyUsers();
	}
	
	@Override
	public User findById(int id) {
		List result =  users.stream().filter(x -> x.getId() == id).collect(Collectors.toList());
		 if(result.size() > 0)
			 return (User) result.get(0);
		 else 
			 return null;
	}

	@Override
	public User findByName(String name) {
		 List result =  users.stream().filter(x -> x.getName().equals(name)).collect(Collectors.toList());
		 if(result.size() > 0)
			 return (User) result.get(0);
		 else 
			 return null;
	}

	@Override
	public List<User> saveUser(User user) {
		users.add(user);
		return users;
		
	}

	@Override
	public void updateUser(User user) {
		int index = users.indexOf(user);
		users.set(index, user);
	}

	@Override
	public void deleteUserById(int id) {
		List result =  users.stream().filter(x -> x.getId() != id).collect(Collectors.toList());
		if(result.size() > 0)
			users = (List<User>) result;
		else 
			users.clear();
	}

	@Override
	public void deleteAllUser() {
		users.clear();
	}

	@Override
	public List<User> readAllUser() {
		return users;
	}

	@Override
	public boolean isUserExist(User user) {
		return (findByName(user.getName()) != null);
	}
	
	private static List<User> populateDummyUsers(){
		List<User> users = new ArrayList<User>();
		users.add(new User(Integer.valueOf( counter.incrementAndGet()+""),"Sam",30, 70000));
		users.add(new User(Integer.valueOf( counter.incrementAndGet()+""),"Tom",40, 50000));
		users.add(new User(Integer.valueOf( counter.incrementAndGet()+""),"Jerome",45, 30000));
		users.add(new User(Integer.valueOf( counter.incrementAndGet()+""),"Silvia",50, 40000));
		return users;
	}

}
