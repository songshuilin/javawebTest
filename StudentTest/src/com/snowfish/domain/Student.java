package com.snowfish.domain;

public class Student {
	String t_number;
	String t_name;
	String t_sex;
	String t_major;
	String t_phone;
	String t_hobby;
	String t_desc;
	public String getT_number() {
		return t_number;
	}
	public void setT_number(String t_number) {
		this.t_number = t_number;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public String getT_sex() {
		return t_sex;
	}
	public void setT_sex(String t_sex) {
		this.t_sex = t_sex;
	}
	public String getT_major() {
		return t_major;
	}
	public void setT_major(String t_major) {
		this.t_major = t_major;
	}
	public String getT_phone() {
		return t_phone;
	}
	public void setT_phone(String t_phone) {
		this.t_phone = t_phone;
	}
	public String getT_hobby() {
		return t_hobby;
	}
	public void setT_hobby(String t_hobby) {
		this.t_hobby = t_hobby;
	}
	public String getT_desc() {
		return t_desc;
	}
	public void setT_desc(String t_desc) {
		this.t_desc = t_desc;
	}
	public Student(String t_number, String t_name, String t_sex, String t_major, String t_phone, String t_hobby,
			String t_desc) {
		super();
		this.t_number = t_number;
		this.t_name = t_name;
		this.t_sex = t_sex;
		this.t_major = t_major;
		this.t_phone = t_phone;
		this.t_hobby = t_hobby;
		this.t_desc = t_desc;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [t_number=" + t_number + ", t_name=" + t_name + ", t_sex=" + t_sex + ", t_major=" + t_major
				+ ", t_phone=" + t_phone + ", t_hobby=" + t_hobby + ", t_desc=" + t_desc + "]";
	}
	
	


}
