package com.grs.service;

import java.time.LocalDate;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grs.dao.UserDAOImpl;
import com.grs.dto.UserDTO;
import com.grs.entity.User;
import com.grs.util.MD5;
import com.grs.util.MailSenderUtil;

@Service
public class RegisterService {

	private static final Logger LOGGER = LogManager.getLogger();

	@Autowired
	private UserDAOImpl impl;

	@Autowired
	private MailSenderUtil util;

	public boolean validateAndSaveUser(UserDTO dto) {
		LOGGER.info("validateAndSaveUser method invoked");

		boolean saveStatus = false;
		if (validateUser(dto.getUserName()) && validatePassword(dto.getPassword(), dto.getConfirmPassword())) {
			util.sendMail(dto.getEmail(),
					"Hi " + dto.getFirstName() + " " + dto.getLastName() + " Thanks for signing up",
					"Welcome!  We are happy to have you on board. \n Username: " + dto.getUserName() + "\n Password: "
							+ dto.getPassword());
			User entity = new User();
	        entity.setDob(LocalDate.parse(dto.getDob()));
	        entity.setDose1(LocalDate.parse(dto.getDose1()));
	        entity.setDose2(LocalDate.parse(dto.getDose2()));
			BeanUtils.copyProperties(dto, entity);
			String encryptedPassword = MD5.getMd5(dto.getPassword());
			entity.setPassword(encryptedPassword);
			saveStatus = impl.saveUser(entity);
			return saveStatus;
		}
		return saveStatus;
	}

	public boolean validateUser(String userid) {
		LOGGER.info("RegisterService - validateUser method invoked");
		if (Objects.nonNull(userid) && !userid.isEmpty())
			return true;

		return false;
	}

	public boolean validatePassword(String password, String cnfPassword) {
		LOGGER.info("validatePassword method invoked");
		if (Objects.nonNull(password) && Objects.nonNull(cnfPassword) && !password.isEmpty()
				&& !cnfPassword.isEmpty()) {
			if (password.equals(cnfPassword)) {
				return true;
			}
		}
		return false;
	}

}
