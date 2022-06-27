package com.grs.service;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grs.dao.UserDAOImpl;
import com.grs.dto.ResetPasswordDTO;
import com.grs.entity.User;
import com.grs.util.MD5;
import com.grs.util.MailSenderUtil;
import com.grs.util.OTPGenerator;

@Service
public class ResetPasswordService {

	@Autowired
	private UserDAOImpl impl;
	@Autowired
	private MailSenderUtil util;
	private static final Logger LOGGER = LogManager.getLogger();

	public String validateAndSendOTP(String email) {
		LOGGER.info("validateAndSendOTP method invoked");
		if (Objects.nonNull(email) && !email.isEmpty()) {
			User user = impl.getUserByEmailAndUserName(email);
			if (user.getEmail().equals(email)) {
				String otp = OTPGenerator.GetOTP();
				util.sendMail(email, "OTP", otp);
				return otp;
			}
		}
		return null;
	}

	public boolean validateOTP(ResetPasswordDTO dto, String otpFromSession) {
		LOGGER.info("validatePassword method invoked");
		if (dto.getOtp().equals(otpFromSession)) {
			if (Objects.nonNull(dto.getPassword()) && Objects.nonNull(dto.getCnfpassword())
					&& !dto.getPassword().isEmpty() && !dto.getCnfpassword().isEmpty()) {
				String encryptedPassword = MD5.getMd5(dto.getPassword());
				impl.updatePassword(encryptedPassword, dto.getEmail());
				return true;
			}
		}
		return false;
	}
	
}
