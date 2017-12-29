package com.snowfish.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.snowfish.cn.Student;

public class HibernateTest {

	public static void main(String[] args) {
		//add();
		//update();
		//delete() ;
		select();
	}
	
	//增
	public static void add() {
		Configuration configuration=new Configuration();
		Configuration config=configuration.configure();
		SessionFactory sessionFactory=config.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=  session.beginTransaction();
		Student student=new Student(3l,"wangwu",23,"Yinyu");
		session.save(student);
		transaction.commit();
		session.close();
		sessionFactory.close();  
	}
	//改
	public static void update(){
		Configuration configuration=new Configuration();
		Configuration config=configuration.configure();
		SessionFactory factory=config.buildSessionFactory();
		Session session=factory.openSession();
		Transaction trans=session.beginTransaction();
		Student student=session.get(Student.class,1l);
		student.setS_age(22);
		student.setS_name("songshuilin");
		student.setS_major("通信工程");
		session.save(student);
		trans.commit();
		session.close();
		factory.close();
	}
	
	public static void delete() {
		Configuration configuration=new Configuration();
		Configuration config=configuration.configure();
		SessionFactory factory=config.buildSessionFactory();
		Session session=factory.openSession();
		Transaction trans=session.beginTransaction();
		//Student student=session.load(Student.class,1l);
		Student student=new Student(3l,"wangwu",24,"Yinyu");
		session.delete(student);  
		trans.commit();
		session.close();
		factory.close();
	}
	//查 
	public static  void select() {
		Configuration configuration=new Configuration();
		Configuration config=configuration.configure();
		SessionFactory sessionFactory=config.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Student student=session.load(Student.class,2l);
		System.out.println(student);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
}
