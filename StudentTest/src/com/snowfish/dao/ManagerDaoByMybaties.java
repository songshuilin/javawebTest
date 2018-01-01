package com.snowfish.dao;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.snowfish.domain.Manager;
import com.snowfish.mybatis.ManagerMapper;

public class ManagerDaoByMybaties {
	private static SqlSessionFactory sqlSessionFactory;

	static {
		try {
			sqlSessionFactory
			=new SqlSessionFactoryBuilder().
			build(Resources.getResourceAsReader("configuration.xml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void add(Manager manager) {
		System.out.println("insert begin!!!");
		SqlSession session=sqlSessionFactory.openSession(true);
		ManagerMapper manpper=session.getMapper(ManagerMapper.class);
		manpper.add(manager);
		session.close();  
		System.out.println("insert success!!!");
	}

	public boolean find(Manager manager) {
		System.out.println("find begin!!!");
		System.out.println(manager);
		SqlSession session=sqlSessionFactory.openSession(true);
		ManagerMapper manpper=session.getMapper(ManagerMapper.class);
		Manager b= manpper.find(manager);
		session.close();  
		System.out.println("find success!!!"+b);
		return b==null?false : true;
	}
}
