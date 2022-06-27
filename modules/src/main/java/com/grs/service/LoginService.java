package com.grs.service;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grs.dao.UserDAOImpl;
import com.grs.entity.User;
import com.grs.util.MD5;

@Service
public class LoginService {

	@Autowired
	UserDAOImpl daoImpl;

	private static final Logger LOGGER = LogManager.getLogger();

	public User validateUser(String userNameOrEmail, String password) {
		LOGGER.info("LoginService - validateUser method invoked");
		if ((Objects.nonNull(userNameOrEmail) && !userNameOrEmail.isEmpty()) && Objects.nonNull(password) && !password.isEmpty()) {
			String encryptedPassword = MD5.getMd5(password);
			User user = daoImpl.getUserByEmailAndUserName(userNameOrEmail);
			if (user == null) {
				return null;
			}
			if ((user.getUserName().equals(userNameOrEmail)||user.getEmail().equals(userNameOrEmail)) && user.getPassword().equals(encryptedPassword)) {
				return user;
			}
		}
		return null;
	}

}
