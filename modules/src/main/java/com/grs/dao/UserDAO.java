package com.grs.dao;

import com.grs.entity.User;

public interface UserDAO {

	public boolean saveUser(User user);
	

	boolean updatePassword(String password, String email);


	User getUserByEmailAndUserName(String userNameOrEmail);
	

}
