package com.jvisoft.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jvisoft.Model.UserX;
import com.jvisoft.Repository.UserRepository;

@Service
public class UserServiceImpl  implements UserService {

	 @Autowired
	 private UserRepository userRepository;
	 
	@Override
	public UserX saveUser(UserX user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public List<UserX> fetchUserList() {
		// TODO Auto-generated method stub
		return (List<UserX>)userRepository.findAll();
	}

	@Override
	public UserX updateUser(UserX user, Long userId) {
		// TODO Auto-generated method stub
		UserX userDB = userRepository.findById(userId).get();
		
		 if (Objects.nonNull(user.getName()) && !"".equalsIgnoreCase(user.getName())) {
			 userDB.setName(user.getName());
	        }
	 
	        if (Objects.nonNull(user.getEmail()) && !"".equalsIgnoreCase(user.getEmail())) {
	        	userDB.setEmail(user.getEmail());
	        }
	 
			
		 return userRepository.save(userDB);
	}

	@Override
	public void deleteUserById(Long userId) {
		// TODO Auto-generated method stub
		userRepository.deleteById(userId);
	}

}
