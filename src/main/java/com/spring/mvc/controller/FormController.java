package com.spring.mvc.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.mvc.integrate.User;

/**
 * 控制器: 表单的验证--使用Hibernate-validate
 * 
 * @author 	Lian
 * @date	2016年5月18日
 * @since	1.0
 */
@Controller
@RequestMapping("/form")
public class FormController {

	@RequestMapping("/view")
	public String hello() {
		return "addUser";
	}

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(@Valid User user, BindingResult br) {
		if(br.getErrorCount() > 0) {
			return "addUser";
		}
		return "showUser";
	}

	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add(Map<String, Object> map) {
		map.put("user", new User());
		return "addUser";
	}
}
