package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 控制器: 处理局部异常(Controller内)
 * 
 * @author 	Lian
 * @date	2016年5月17日
 * @since	1.0
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
