package com.spring.mvc.integrate;

import org.springframework.stereotype.Component;

/**
 * @author 	Lian
 * @date	2016年1月13日 下午3:56:35
 * @desc	
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
