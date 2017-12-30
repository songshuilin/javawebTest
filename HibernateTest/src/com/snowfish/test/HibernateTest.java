package com.snowfish.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.junit.jupiter.api.Test;

import com.snowfish.cn.Student;

public class HibernateTest {

	public static void main(String[] args) {
		//add();
		//update();
		//delete() ;
		//select();
	}
	
	//增
	public static void add() {
		Configuration configuration=new Configuration();
		Configuration config=configuration.configure();
		SessionFactory sessionFactory=config.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=  session.beginTransaction();
		for (int i= 3; i < 20; i++) {
			Student student=new Student(i,"wangwu"+i,20+i,"计算机"+i);
			session.save(student);
		}
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
//		Student student=session.load(Student.class,2l);
//		System.out.println(student);
		String sql="from Student where s_id= ? ";
		Query query=session.createQuery(sql);
		query.setParameter(0, 6l);
		List<Student> list=query.list();
		for (Student student : list) {
			System.out.println(student);
		}
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	//查 
	@Test
	public   void selectCriteria() {
		Configuration configuration=new Configuration();
		Configuration config=configuration.configure();
		SessionFactory sessionFactory=config.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		//Property age = Property.forName("s_id");
		Criteria criteria=session.createCriteria(Student.class);
		criteria.add(Restrictions.eq("s_id", 10l));
		Student student=(Student) criteria.uniqueResult();
		System.out.println(student);
		//List<Student> list=criteria.list();
//		for (Student student : list) {
//			System.out.println(student);
//		}
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
}
