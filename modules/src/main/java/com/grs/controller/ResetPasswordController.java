package com.grs.controller;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.grs.dto.ResetPasswordDTO;
import com.grs.service.ResetPasswordService;

@Controller
public class ResetPasswordController {
	
	private static final Logger LOGGER = LogManager.getLogger();
	
	@Autowired
	ResetPasswordService resetPasswordService;
	
	@PostMapping("/sendotp.do")
	public ModelAndView sendOTP(String email, String username, HttpSession session) {
		LOGGER.info("sendOTP method invoked");
		ModelAndView modelAndView = new ModelAndView();
		String otp = resetPasswordService.validateAndSendOTP(email);
		if (otp != null) {
			session.setAttribute(email, otp);
			modelAndView.addObject("email", email);
			modelAndView.setViewName("ResetPassword");
			return modelAndView;
		} else {
			modelAndView.setViewName("forgot-password");
			return modelAndView;
		}
	}
	
	@PostMapping("/reset.do")
	public ModelAndView resetPassword(ResetPasswordDTO dto, HttpSession session) {
		LOGGER.info("resetPassword method invoked");
		String sessionOtp = (String)session.getAttribute(dto.getEmail());
		ModelAndView modelAndView = new ModelAndView();
		if (resetPasswordService.validateOTP(dto, sessionOtp)) {
			modelAndView.setViewName("PasswordResetSuccess");
			LOGGER.info("resetPassword method invoked ");
			return modelAndView;
		} else {
			modelAndView.setViewName("forgot-password");
			return modelAndView;
		}
	}

}
