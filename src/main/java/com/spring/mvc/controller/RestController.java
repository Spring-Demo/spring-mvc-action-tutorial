package com.spring.mvc.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.mvc.model.Rest;

/**
 * 控制器: RESTFul风格的SpringMVC
 * @attention	响应应该是json格式
 * @attention	@RestController名字相同
 * 
 * @author 	Lian
 * @date	2016年5月17日
 * @since	1.0
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {

	/**
	 * http://localhost:8080/spring-mvc-action-tutorial/mvc/page/rest
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/user/{id}", method=RequestMethod.GET)
	public Rest get(@PathVariable("id") Integer id) {
		Rest rest = new Rest("GET", id);
		return rest;
	}

	@RequestMapping(value="/user/{id}", method=RequestMethod.POST)
	public Rest post(@PathVariable("id") Integer id) {
		Rest rest = new Rest("GET", id);
		return rest;
	}

	@RequestMapping(value="/user/{id}", method=RequestMethod.PUT)
	public Rest put(@PathVariable("id") Integer id) {
		Rest rest = new Rest("GET", id);
		return rest;
	}

	@RequestMapping(value="/user/{id}", method=RequestMethod.DELETE)
	public Rest delete(@PathVariable("id") Integer id) {
		Rest rest = new Rest("GET", id);
		return rest;
	}
}
