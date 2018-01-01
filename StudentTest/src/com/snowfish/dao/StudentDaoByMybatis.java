package com.snowfish.dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.snowfish.domain.PageBean;
import com.snowfish.domain.Student;
import com.snowfish.mybatis.StudentMapper;


public class StudentDaoByMybatis {
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
	
	public List<Student> findAll() {
		System.out.println("findAll begin...");
		SqlSession session=sqlSessionFactory.openSession(true); 
		StudentMapper mapper=session.getMapper(StudentMapper.class);
		List<Student> list=mapper.findAll();
		System.out.println(list);
		return list;
	}


	public Student find(String number) {
		System.out.println("find begin...");
		SqlSession session=sqlSessionFactory.openSession(true); 
		StudentMapper mapper=session.getMapper(StudentMapper.class);
		Student student=mapper.find(number);
		System.out.println(student);
		return student;
	}

	public void delete(String number) {
		System.out.println("delete begin...");
		SqlSession session=sqlSessionFactory.openSession(true); 
		StudentMapper mapper=session.getMapper(StudentMapper.class);
		mapper.delete(number);
		
	}

	public void update(Student student) {
		System.out.println("update begin...");
		SqlSession session=sqlSessionFactory.openSession(true); 
		StudentMapper mapper=session.getMapper(StudentMapper.class);
		mapper.update(student);
	}
	
	
	/**
	 * 获取总记录数
	 * @return
	 */
	public int getTotleRecoder() {
		System.out.println("getTotleRecoder begin...");
		SqlSession session=sqlSessionFactory.openSession(true); 
		StudentMapper mapper=session.getMapper(StudentMapper.class);
		return mapper.getTotleRecoder();
	}

	public List<Student> findAllByLimit(int currentPage, int recoderForPage){
		System.out.println("findAllByLimit begin...");
		SqlSession session=sqlSessionFactory.openSession(true); 
		StudentMapper mapper=session.getMapper(StudentMapper.class);
		System.out.println(currentPage+"==="+recoderForPage);
		List<Student> list=mapper.findAllByLimit(currentPage,recoderForPage);
		System.out.println(list);
		return list;
	}
	
	
	
	public PageBean<Student> findAll(int currentPage, int recoderForPage) {
		System.out.println("findAll begin...");
		int totleRecoder=getTotleRecoder();
		PageBean<Student> bean=new PageBean<>();
		bean.setRecoderForPage(recoderForPage);
		bean.setCurrentPage(currentPage);
		bean.setTotleRecoder(totleRecoder);
		List<Student> list=findAllByLimit((currentPage-1)*recoderForPage,recoderForPage);
		bean.setList(list);
		System.out.println("......................"+list);
		System.out.println("PageBean<Student>"+bean);
		return bean;
	}

	
}
