package com.spring.mvc.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.mvc.model.Person;

/**
 * @author 	Lian
 * @date	2016年1月13日 上午11:37:36
 * @desc	控制器
 */
@Controller
@RequestMapping("/mvc")
public class MvcController {

	/**
	 * url: http://localhost:8080/spring-test/mvc/hello
	 *
	 * @return
	 */
	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}

	/**
	 * 自动匹配参数: match automatically
	 * url: http://localhost:8080/spring-test/mvc/person?name=lian&age=2.4
	 * 
	 * @param name
	 * @param age
	 * @return
	 */
	@RequestMapping("/person")
	public String toPerson(String name, double age) {
		System.out.println(name + " " + age);
		return "hello";
	}

	/**
	 * 自动装箱: boxing automatically
	 * url: url: http://localhost:8080/spring-test/mvc/person1?name=lian&age=2
	 * attention: 当参数类型不匹配时, 不会自动装箱
	 * 
	 * @param p
	 * @return
	 */
	@RequestMapping("/person1")
	public String toPerson(Person p) {
		System.out.println(p.getName() + " " + p.getAge());
		return "hello";
	}

	/**
	 * 使用InitBinder来处理Date类型的参数
	 * the parameter was coverted in initBinder
	 * @param date
	 * @return
	 */
	@RequestMapping("/date")
	public String date(Date date) {
		System.out.println(date);
		return "hello";
	}

	/**
	 * At the time of initialization, convert the type "String" to type "date"
	 * @param binder
	 */
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	/**
	 * 向前台传递参数: pass the parameters to front-end
	 * 前台可在Request域中取到"p"
	 * @param map
	 * @return
	 */
	@RequestMapping("/show")
	public String showPerson(Map<String, Object> map) {
		Person p = new Person();
		map.put("p", p);
		p.setAge(20);
		p.setName("lian");
		return "show";
	}

	/**
	 * 使用Ajax调用: pass the parameters to front-en using ajax
	 * @param name
	 * @param pw
	 */
	@RequestMapping("/getPerson")
	public void getPerson(String name, PrintWriter pw) {
		pw.write("hello, " + name);
	}

	@RequestMapping("/name")
	public String sayHello() {
		return "name";
	}

	/**
	 * 在Controller中使用redirect方式处理请求
	 * @return
	 */
	@RequestMapping("/redirect")
	public String redirect() {
		return "redirect:hello";
	}

	/**
	 * 文件上传
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String upload(HttpServletRequest request) throws IOException {
		MultipartHttpServletRequest mreq = (MultipartHttpServletRequest) request;
		MultipartFile file = mreq.getFile("file");
		String fileName = file.getOriginalFilename();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		FileOutputStream fos = new FileOutputStream(request.getSession().getServletContext().getRealPath("/") +
				"upload/" + sdf.format(new Date()) + fileName.substring(fileName.lastIndexOf(".")));
		fos.write(file.getBytes());
		fos.flush();
		fos.close();

		return "hello";
	}
}
