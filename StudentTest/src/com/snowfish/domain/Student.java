package com.snowfish.domain;

public class Student {
	String number;
	String name;
	String sex;
	String major;
	String phone;
	String hobby;
	String desc;
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "Student [ number=" + number + ", name=" + name + ", sex=" + sex + ", major=" + major
				+ ", phone=" + phone + ", hobby=" + hobby + ", desc=" + desc + "]";
	}


}
