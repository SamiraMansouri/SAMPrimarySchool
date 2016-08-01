package edu.neu.samPrimarySchool.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import edu.neu.samPrimarySchool.exception.AdException;
import edu.neu.samPrimarySchool.model.User;



public class UserDaoImplementation extends DAO {
	
	 public User findUser(String username,String password)
	            throws AdException {
	        try {
	            begin();
	            Query q = getSession().createQuery("from User where UserName = :username and Password =:password");
	            q.setParameter("username", username);
	            q.setParameter("password", password);
	            User user = (User) q.uniqueResult();
	            commit();
	            return user;
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Could not get user " + username, e);
	        }
	    }
	 
	 public UserDaoImplementation() {
		// TODO Auto-generated constructor stub
	}

}
