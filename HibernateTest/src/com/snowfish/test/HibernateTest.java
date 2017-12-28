package com.snowfish.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.snowfish.cn.Student;

public class HibernateTest {

	public static void main(String[] args) {
		//add();
		update();
	}
	
	//增
	public static void add() {
		Configuration configuration=new Configuration();
		Configuration config=configuration.configure();
		SessionFactory sessionFactory=config.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=  session.beginTransaction();
		Student student=new Student(1l,"zhangsan",23,"计算机");
		session.save(student);
		transaction.commit();
		session.close();
		sessionFactory.close();  
	}
	//改
	public static void update(){
		Configuration conf=new Configuration();
		SessionFactory factory=conf.buildSessionFactory();
		Session session=factory.openSession();
		Transaction trans=session.beginTransaction();
		Student student=session.get(Student.class,1l);
		student.setS_age(22);
		student.setS_name("songshuilin");
		student.setS_major("通信工程");
		trans.commit();
		session.close();
	}
}
