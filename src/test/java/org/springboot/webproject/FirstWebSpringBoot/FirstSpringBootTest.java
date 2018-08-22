package org.springboot.webproject.FirstWebSpringBoot;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springboot.webproject.FirstWebSpringBoot.model.User;
import org.springboot.webproject.FirstWebSpringBoot.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import junit.framework.Assert;

public class FirstSpringBootTest {
	
	
	public String URL_TEST= "http://localhost:8080/api/user";
	
	@Test
	public void listAllUsersTest(){
        System.out.println("Testing listAllUsers API-----------");
        TestRestTemplate testRestTemplate = new TestRestTemplate();
        ResponseEntity<List> response = testRestTemplate.
        		  getForEntity(URL_TEST + "/", List.class);
        response.getBody().forEach(System.out::println);
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }
	
	@Test
	public void findByIdTest(){
        System.out.println("Find By Id-----------");
        int id = 2;
        TestRestTemplate testRestTemplate = new TestRestTemplate();
        ResponseEntity<User> response = testRestTemplate.
        		  getForEntity(URL_TEST + "/"+id, User.class);
        System.out.println(response.getBody());
        Assert.assertEquals(id, response.getBody().getId());
    }
	
	@Test
	public void updateUserTest(){
        System.out.println("Find By Id-----------");
        User newUser = new User(2, "Santo", 4, 80000);
        TestRestTemplate testRestTemplate = new TestRestTemplate();
        testRestTemplate.put(URL_TEST + "/"+newUser.getId(), newUser);
        ResponseEntity<User> response = testRestTemplate.
      		  getForEntity(URL_TEST + "/"+newUser.getId(), User.class);
        System.out.println(response.getBody());
        Assert.assertEquals(newUser, response.getBody());
    }
	
	@Test
	public void deleteUserTest(){
        System.out.println("Testing Delete User API-----------");
        TestRestTemplate testRestTemplate = new TestRestTemplate();
        int id = 1;
        testRestTemplate.delete(URL_TEST + "/"+id);
        ResponseEntity<User> response = testRestTemplate.
      		  getForEntity(URL_TEST + "/"+id, User.class);
      	Assert.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
	

}
