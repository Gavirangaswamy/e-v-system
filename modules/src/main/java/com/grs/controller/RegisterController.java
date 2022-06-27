package com.grs.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.grs.dto.UserDTO;
import com.grs.service.LoginService;
import com.grs.service.RegisterService;
import com.grs.service.ResetPasswordService;

@Controller
public class RegisterController {

	@Autowired
	RegisterService registerService;
	@Autowired
	LoginService loginService;
	@Autowired
	ResetPasswordService resetPasswordService;
	
	private static final Logger LOGGER = LogManager.getLogger();

	@PostMapping("/save.do")
	public ModelAndView saveUserInfo(UserDTO dto) {
		
		LOGGER.info("saveUserInfo method invoked");

		ModelAndView modelAndView = new ModelAndView();
		if (registerService.validateAndSaveUser(dto)) {
			modelAndView.setViewName("registrationsuccess");
			modelAndView.addObject("lastname", dto.getFirstName());
			modelAndView.addObject("firstname", dto.getLastName());
		} else {
			modelAndView.setViewName("register");
		}
		return modelAndView;
	}

	
	
	

}
