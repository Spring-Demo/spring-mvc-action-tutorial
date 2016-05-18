package com.spring.mvc.integrate;

import org.springframework.stereotype.Component;

/**
 * User Service
 * 
 * @author 	Lian
 * @date	2016年5月18日
 * @since	1.0
 */
@Component
public class UserService {

	public UserService() {
		System.out.println("UserService Constructor...");
	}

	public void save() {
		System.out.println("save");
	}
}
