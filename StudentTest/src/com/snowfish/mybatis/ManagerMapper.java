package com.snowfish.mybatis;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.snowfish.domain.Manager;

public interface ManagerMapper {

	@Insert("insert into m_manager ("
			+ "m_username , m_password)" 
			+ " values (#{username} , #{password})" )
	public void add(Manager manager);


	@Select("select * from m_manager where "
			+ "m_username= #{m_username} and m_password=#{m_password}")  
	public Manager find(Manager manager);
}
