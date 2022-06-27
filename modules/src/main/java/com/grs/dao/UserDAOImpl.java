package com.grs.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grs.entity.User;

@Component
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private static final Logger LOGGER = LogManager.getLogger();
	
	@Override
	public boolean saveUser(User user) {
		LOGGER.info("saveUser method invoked");
		boolean status =false;
		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			session.getTransaction().begin();
			session.save(user);
			session.getTransaction().commit();
			status =true;
		} catch (HibernateException e) {
			LOGGER.error("failed to save user data "+e);
		}finally {
			session.close();
		}
		System.out.println("User saved");
		return status;
	}

	@Override
	public User getUserByEmailAndUserName(String userNameOrEmail) {
		LOGGER.info("getUserByUserID method invoked");
		Session session = null;
		User user = null;
		try {
			session = this.sessionFactory.openSession();
			Query<?> query = session.createQuery("FROM User WHERE email=:email OR userName=:userName");
			query.setParameter("userName", userNameOrEmail);
			query.setParameter("email", userNameOrEmail);
			user=(User) query.uniqueResult();
			LOGGER.info("user data fetched successfully");
			return user;
		} catch (HibernateException e) {
			LOGGER.error("failed to fetch user");
		}finally {
			session.close();
		}
		return user;
	}

	@Override
	public boolean updatePassword(String password,String email) {
		LOGGER.info("updatePassword method invoked");
		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			session.getTransaction().begin();
			Query<?> query = session.createQuery("UPDATE User user SET user.password =:password WHERE user.email=:email");
			query.setParameter("password", password);
			query.setParameter("email", email);
			query.executeUpdate();
			session.getTransaction().commit();
			LOGGER.info("password updated successfully");
			return true;
		} catch (HibernateException e) {
			LOGGER.error("failed to update password");
		}finally {
			session.close();
		}
		return false;
	}

}
