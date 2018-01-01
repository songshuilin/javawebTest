package com.snowfish.service;

import java.util.List;

import com.snowfish.dao.StudentDao;
import com.snowfish.dao.StudentDaoByMybatis;
import com.snowfish.domain.PageBean;
import com.snowfish.domain.Student;

public class StudentService {
	//StudentDao studentDao=new StudentDao();
	StudentDaoByMybatis studentDao=new StudentDaoByMybatis();

	public List<Student> findAll(){
		List<Student> list_student=studentDao.findAll();

		return list_student;
	}

	public PageBean<Student> findAll(int currentPage,int recoderForPage){
		PageBean<Student> bean=studentDao.findAll(currentPage, recoderForPage);
		return bean;
	}

	public Student find(String number) {

		return studentDao.find(number);

	}
	public void edit(Student student) {
		studentDao.update(student);

	}
	public void delete(String number) {
		studentDao.delete(number);

	}
}
