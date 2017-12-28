package com.snowfish.cn;

public class Student {
	
	private long s_id;
	private String s_name;
	private int s_age;
	private String s_major;
	
	
	public Student(long s_id, String s_name, int s_age, String s_major) {
		super();
		this.s_id = s_id;
		this.s_name = s_name;
		this.s_age = s_age;
		this.s_major = s_major;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getS_id() {
		return s_id;
	}
	public void setS_id(long s_id) {
		this.s_id = s_id;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public int getS_age() {
		return s_age;
	}
	public void setS_age(int s_age) {
		this.s_age = s_age;
	}
	public String getS_major() {
		return s_major;
	}
	public void setS_major(String s_major) {
		this.s_major = s_major;
	}
	@Override
	public String toString() {
		return "Student [s_id=" + s_id + ", s_name=" + s_name + ", s_age=" + s_age + ", s_major=" + s_major + "]";
	}

}