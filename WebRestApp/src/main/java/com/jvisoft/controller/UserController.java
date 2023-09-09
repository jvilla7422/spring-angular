package com.jvisoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jvisoft.Model.UserX;
import com.jvisoft.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired(required = true) 
	private UserService userService;

	    @GetMapping("/users")
	    public List<UserX> getUsers() {
	        return userService.fetchUserList();
	    }

	    @PostMapping("/users")
	    public UserX addUser(@RequestBody UserX user) {
	    	return userService.saveUser(user);
	    }
	    
	 // Update operation
	    @PutMapping("/user/{id}")
	    public UserX
	    updateUser(@RequestBody UserX department,
	                     @PathVariable("id") Long userId)
	    {
	 
	        return userService.updateUser(
	            department, userId);
	    }
	 
	    // Delete operation
	    @DeleteMapping("/user/{id}")
	    public String deleteDepartmentById(@PathVariable("id")
	                                       Long userId)
	    {
	 
	    	userService.deleteUserById(
	    			userId);
	        return "Deleted Successfully";
	    }
}
