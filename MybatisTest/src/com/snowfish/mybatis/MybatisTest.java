package com.snowfish.mybatis;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.jupiter.api.Test;

public class MybatisTest {


	@Test
	public void selectById() {

		SqlSessionFactory sessionFactory = null;  
		String resource = "com/snowfish/mybatis/configuration.xml";  
		try {  
			sessionFactory = new SqlSessionFactoryBuilder().build(Resources  
					.getResourceAsReader(resource));  
			SqlSession sqlSession = sessionFactory.openSession();  
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);  
			Student studnet = studentMapper.findById(3);  
			System.out.println(studnet);  
		} catch (IOException e) {  
			// TODO Auto-generated catch block  
			e.printStackTrace();  
		}  
	}  

	@Test
	public void findByAge() {
		SqlSessionFactory sessionFactory = null;  
		String resource = "com/snowfish/mybatis/configuration.xml";  
		try {
			sessionFactory=new SqlSessionFactoryBuilder()
					.build(Resources.getResourceAsReader(resource));
			SqlSession session=sessionFactory.openSession();
			StudentMapper studentMapper = session.getMapper(StudentMapper.class);  
			Student studnet = studentMapper.fingByAge(26);  
			System.out.println(studnet);  
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deleteById() {
		SqlSessionFactory sessionFactory = null;  
		String resource = "com/snowfish/mybatis/configuration.xml";  
		try {
			sessionFactory=new SqlSessionFactoryBuilder()
					.build(Resources.getResourceAsReader(resource));
			SqlSession session=sessionFactory.openSession();
			StudentMapper studentMapper = session.getMapper(StudentMapper.class);  
			Boolean  studnet = studentMapper.deleteById(4L);  
			session.commit();//经测试必须提交  不然数据库查出来还是有点
			session.close();
			System.out.println(studnet);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}
