package org.hibernate;

import java.util.Date;

import org.ashish.dto.UserDetails;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

	public static void main(String[] args) {

		UserDetails ud = new UserDetails();
		ud.setUserId(1);
		ud.setUname("Bandana Sharma");
		ud.setAddress("Seattle");
		ud.setJoiningDate(new Date());
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(ud);
		session.getTransaction().commit();
		session.close();
	
		session =sessionFactory.openSession();
		session.beginTransaction();
		ud = session.get(UserDetails.class, 1);
		System.out.println(ud.getUname());

	}

}
