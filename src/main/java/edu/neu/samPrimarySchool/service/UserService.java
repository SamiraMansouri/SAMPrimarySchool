package edu.neu.samPrimarySchool.service;

import edu.neu.samPrimarySchool.model.User;

public interface UserService {

	public User findUser(String username,String password);
}
