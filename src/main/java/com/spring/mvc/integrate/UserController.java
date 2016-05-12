package com.spring.mvc.integrate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 	Lian
 * @date	2016年1月13日 下午3:57:47
 * @desc	
 */
@Controller
@RequestMapping("/integrate")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/user")
	public String saveUser(@RequestBody @ModelAttribute User user) {
		System.out.println(user);
		userService.save();
		return "hello";
	}
}
