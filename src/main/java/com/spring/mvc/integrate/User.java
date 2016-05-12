package com.spring.mvc.integrate;

import java.util.Date;

import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author 	Lian
 * @date	2016年1月13日 下午12:03:08
 * @desc	User实体类
 */
public class User {
	private int id;
	@NotEmpty
	private String name;
	@Past
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birth;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birth=" + birth + "]";
	}
}
