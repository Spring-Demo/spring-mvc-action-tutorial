package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 	Lian
 * @date	2016年1月13日 上午11:37:36
 * @desc	控制器: 处理全局异常(所有Controller)
 */
@Controller
@RequestMapping("/exception")
public class ExceptionController {
	@ExceptionHandler
	public ModelAndView exceptionHandler(Exception ex) {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("exception", ex);
		System.out.println("in testExceptionHandler");
		return mv;
	}

	@RequestMapping("/error")
	public String error() {
		int i = 5 / 0;
		// just for clear warning of unused
		i = i + 1;
		return "hello";
	}
}
