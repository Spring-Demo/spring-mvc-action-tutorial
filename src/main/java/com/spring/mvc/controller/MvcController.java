package com.spring.mvc.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.mvc.model.Person;

/**
 * Mvc Controller
 * 
 * @author 	Lian
 * @date	2016年5月17日
 * @since	1.0
 */
@Controller
@RequestMapping("/mvc")
public class MvcController {

	/**
	 * @url: http://localhost:8080/spring-mvc-action-tutorial/mvc/hello
	 *
	 * @return
	 */
	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}

	/**
	 * 自动匹配参数: match automatically
	 * @url: http://localhost:8080/spring-mvc-action-tutorial/mvc/person?name=lian&age=2.4
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
	 * @url: http://localhost:8080/spring-mvc-action-tutorial/mvc/person1?name=lian&age=2
	 * 		http://localhost:8080/spring-mvc-action-tutorial/mvc/person1?name=lian&age=2.0
	 * @attention: 当参数类型不匹配时, 不会自动装箱
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
	 * @url:	http://localhost:8080/spring-mvc-action-tutorial/mvc/date?date=2016-05-17
	 * 		http://localhost:8080/spring-mvc-action-tutorial/mvc/date?date=2016-05
	 * 		http://localhost:8080/spring-mvc-action-tutorial/mvc/date?date=2016-05-17 15:00:00
	 * 
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
	 * 
	 * @param binder
	 */
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		System.out.println("InitBinder of date : convert the type of String to type date.");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	/**
	 * 向前台传递参数: pass the parameters to front-end
	 * 前台可在Request域中取到"p", 另外, 使用HttpServletRequest.setAttribute()方法也可以实现向前台传递参数
	 * @url:	http://localhost:8080/spring-mvc-action-tutorial/mvc/show
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/show")
	public String showPerson(Model model) {
		Person p = new Person();
		p.setAge(20);
		p.setName("lian");
		model.addAttribute("p", p);
		return "show";
	}

	/**
	 * 使用Ajax调用: pass the parameters to front-en using ajax
	 * url:	http://localhost:8080/spring-mvc-action-tutorial/mvc/page/ajax
	 * 
	 * @param name
	 * @param pw
	 */
	@RequestMapping(value = "/getPerson", method = RequestMethod.POST)
	public void getPerson(String name, PrintWriter pw) {
		// 也可以使用HttpServletResponse.getWriter()来获取PrintWriter
		pw.write("hello, " + name);
	}

	/**
	 * 在Controller中使用redirect方式处理请求
	 * @url:	http://localhost:8080/spring-mvc-action-tutorial/mvc/redirect
	 * 
	 * @return
	 */
	@RequestMapping("/redirect")
	public String redirect() {
		return "redirect:hello";
	}

	/**
	 * 文件上传
	 * @url	http://localhost:8080/spring-mvc-action-tutorial/mvc/page/upload
	 * TODO	webapp下的upload文件夹没有部署, fuck. 后来再弄
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(HttpServletRequest request) throws IOException {
		MultipartHttpServletRequest mreq = (MultipartHttpServletRequest) request;
		MultipartFile file = mreq.getFile("file");
		String fileName = file.getOriginalFilename();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		FileOutputStream fos = new FileOutputStream(request.getSession().getServletContext().getRealPath("/") + "upload/" + sdf.format(new Date())
				+ fileName.substring(fileName.lastIndexOf(".")));
		fos.write(file.getBytes());
		fos.flush();
		fos.close();

		return "hello";
	}

	/**
	 * 页面跳转接口
	 * url:	http://localhost:8080/spring-mvc-action-tutorial/mvc/page/{page}
	 *
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/page/{page}", method = RequestMethod.GET)
	public String page(@PathVariable("page") String page) {
		return page;
	}
}
