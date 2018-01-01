package com.snowfish.domain;

public class Manager {
	String m_username;
	String m_password;

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(String m_username, String m_password) {
		super();
		this.m_username = m_username;
		this.m_password = m_password;
	}

	public String getM_username() {
		return m_username;
	}

	public void setM_username(String m_username) {
		this.m_username = m_username;
	}

	public String getM_password() {
		return m_password;
	}

	public void setM_password(String m_password) {
		this.m_password = m_password;
	}


}
