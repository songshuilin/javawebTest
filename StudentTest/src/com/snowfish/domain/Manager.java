package com.snowfish.domain;

public class Manager {
 String useranme;
 String password;
 
public Manager() {
	super();
	// TODO Auto-generated constructor stub
}
public Manager(String useranme, String password) {
	super();
	this.useranme = useranme;
	this.password = password;
}
public String getUseranme() {
	return useranme;
}
public void setUseranme(String useranme) {
	this.useranme = useranme;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "Manager [useranme=" + useranme + ", password=" + password + "]";
}
 
}
