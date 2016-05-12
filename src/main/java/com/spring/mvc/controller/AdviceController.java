package com.spring.mvc.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 	Lian
 * @date	2016年1月13日 上午11:37:36
 * @desc	控制器: 处理全局异常(所有Controller)
 */
@ControllerAdvice
public class AdviceController {
	@ExceptionHandler
	public ModelAndView exceptionHandler(Exception ex) {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("exception", ex);
		System.out.println("in AdviceController");
		return mv;
	}
}
