package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 	Lian
 * @date	2016年1月13日 上午11:37:36
 * @desc	控制器: 使用@RequestParam注解指定参数的name
 */
@Controller
@RequestMapping("/test")
public class MvcController1 {

	@RequestMapping("/param")
	public String testRequestParam(@RequestParam(value="id") Integer id, @RequestParam(value="name") String name) {
		System.out.println(id + " " + name);
		return "/hello";
	}
}
