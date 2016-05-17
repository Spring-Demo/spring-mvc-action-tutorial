package com.spring.mvc.model;

/**
 * Rest Model
 * 
 * @author 	Lian
 * @date	2016年5月17日
 * @since	1.0	
 */
public class Rest {

	private String method;
	private Integer id;

	public Rest(String method, Integer id) {
		super();
		this.method = method;
		this.id = id;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
