package com.spring.mvc.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.mvc.integrate.User;

/**
 * 控制器: 返回json格式的字符串
 * 
 * @author 	Lian
 * @date	2016年5月17日
 * @since	1.0
 */
@Controller
@RequestMapping("/json")
public class JsonController {

	@ResponseBody
	@RequestMapping("/user")
	public User get() {
		User user = new User();
		user.setId(1);
		user.setName("jayjay");
		user.setBirth(new Date());
		return user;
	}
}
