package com.jvisoft.service;

import java.util.List;

import com.jvisoft.Model.UserX;

public interface UserService {
	 // save operation
    UserX saveUser(UserX user);
 
    // read operation
    List<UserX> fetchUserList();
 
    // update operation
    UserX updateUser(UserX user, Long userId);
 
    // delete operation
    void deleteUserById(Long userId);
}
