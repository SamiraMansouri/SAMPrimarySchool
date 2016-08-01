package edu.neu.samPrimarySchool.service;

import org.springframework.stereotype.Service;

import edu.neu.samPrimarySchool.dao.UserDaoImplementation;
import edu.neu.samPrimarySchool.exception.AdException;
import edu.neu.samPrimarySchool.model.User;


@Service
public class UserServiceImpl {

	 
	public User findUser(String username,String password) 
	{
		 UserDaoImplementation userDaoImpl=new UserDaoImplementation();
			User user=new User();
			try {
				user = userDaoImpl.findUser(username,password);
			} catch (AdException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return user;
			
		}

	}
