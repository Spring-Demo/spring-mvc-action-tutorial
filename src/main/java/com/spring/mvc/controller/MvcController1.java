package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 控制器: 使用@RequestParam注解指定参数的name
 * 
 * @author 	Lian
 * @date	2016年5月17日
 * @since	1.0
 */
@Controller
@RequestMapping("/test")
public class MvcController1 {

	/**
	 * @url:	http://localhost:8080/spring-mvc-action-tutorial/test/param?id=1&name=lian
	 *
	 * @param id
	 * @param name
	 * @return
	 */
	@RequestMapping("/param")
	public String testRequestParam(@RequestParam(value="id") Integer id, @RequestParam(value="name") String name) {
		System.out.println(id + " " + name);
		return "/hello";
	}
}
