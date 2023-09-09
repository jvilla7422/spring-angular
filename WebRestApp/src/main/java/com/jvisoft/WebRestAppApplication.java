package com.jvisoft;

import java.io.Console;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jvisoft.Model.UserX;
import com.jvisoft.service.UserService;

@SpringBootApplication
public class WebRestAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebRestAppApplication.class, args);
	}
	
	 @Bean
	    CommandLineRunner init(UserService userService) {
		    System.out.println("Procesando");
	        return args -> {
	            Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
	                UserX user = new UserX();
	                user.setName(name);
	                user.setEmail(name.toLowerCase() + "@domain.com");
	                userService.saveUser(user);
	            });
	            userService.fetchUserList().forEach(System.out::println);
	        };
	    }

}