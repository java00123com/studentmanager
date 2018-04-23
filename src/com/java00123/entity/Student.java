package com.java00123.entity;

import java.util.Date;

/**
* @author 作者 www.java00123.com
* @version 创建时间：2018年4月21日 上午9:04:54
* 类说明
*/
public class Student {

	private Integer id;
	private String schoolNum;
	private String name;
	private Integer age;
	private Integer sex;
	private String summary;
	private String status;
	private Date createTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSchoolNum() {
		return schoolNum;
	}
	public void setSchoolNum(String schoolNum) {
		this.schoolNum = schoolNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", schoolNum=" + schoolNum + ", name=" + name + ", age=" + age + ", sex=" + sex
				+ ", summary=" + summary + ", status=" + status + ", createTime=" + createTime + "]";
	}
	public Student(Integer id, String schoolNum, String name, Integer age, Integer sex, String summary, String status,
			Date createTime) {
		super();
		this.id = id;
		this.schoolNum = schoolNum;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.summary = summary;
		this.status = status;
		this.createTime = createTime;
	}
	public Student() {
		super();
	}
	
	
	
	
}
