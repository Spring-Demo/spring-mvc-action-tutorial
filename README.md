# 史上最全最强SpringMVC详细示例实战教程

# http://www.cnblogs.com/sunniest/p/4555801.html#commentform

## 配置解析

1. DispatcherServlet
	DispatcherServlet是前置控制器, 配置在web.xml文件中. 拦截匹配的请求, Servlet拦截匹配规则要自己定义, 把拦截下来的请求, 依据相应的规则分发到目标Controller来处理, 是配置SpringMVC的第一步.

2. InternalResourceViewResolver
	视图名称解析器

3. 以上出现的注解
	@Controller: 负责注册一个bean到spring上下文中
	@RequestMapping: 注解为控制器指定可以处理哪些URL请求



## SpringMVC常用注解

- @Controller
	负责注册一个bean到spring上下文中

- @RequestMapping
	注解为控制器指定可以处理哪些URL请求

- @RequestBody
	该注解用于读取Request请求的body部分数据, 使用系统默认配置的HttpMessageConverter进行解析, 然后把相应的数据绑定到要返回的对象上, 再把HttpMessageConverter返回的对象数据绑定到controller中方法的参数上	

- @ResponseBody
	该注解用于将Controller中方法返回的对象, 通过适当的HttpMessageConverter转换为指定格式后, 写入到Response对象的body数据区

- @ModelAttribute
	在方法定义上使用@ModelAttribute 注解: SpringMVC在调用目标处理方法前, 会先逐个调用在方法级上标注了@ModelAttribute的方法
	在方法的入参前使用 @ModelAttribute 注解：可以从隐含对象中获取隐含的模型数据中获取对象，再将请求参数 –绑定到对象中，再传入入参将方法入参对象添加到模型中 

- @RequestParam
	在处理方法入参处使用@RequestParam 可以把请求参数传递给请求方法

- @PathVariable
	绑定URL占位符到入参

- @ExceptionHandler
	注解到方法上, 出现异常时会执行该方法

- @ControllerAdvice
	使一个Controller成为全局的异常处理类, 类中用ExceptinHandler方法注解的方法可以处理所有Controller发生的异常


## SpringMVC常用注解
1. 客户端请求提交到DispatcherServlet
2. 由DispatcherServlet控制器查询一个或多个HandlerMapping, 找到处理请求的Controller
3. DispatcherServlet将请求提交到Controller
4. Controller调用业务逻辑处理后，返回ModelAndView
5. DispatcherServlet查询一个或多个ViewResoler视图解析器，找到ModelAndView指定的视图
6. 视图负责将结果显示到客户端

## 关于jar包的问题
* 本项目使用maven管理jar包，因此没有libjar包之类的
* maven的基本使用并不难，希望大家可以抽出30分钟研究一下
