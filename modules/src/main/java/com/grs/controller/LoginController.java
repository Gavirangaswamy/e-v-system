package com.grs.controller;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.grs.entity.User;
import com.grs.service.LoginService;

@Controller
public class LoginController {

	private static final Logger LOGGER = LogManager.getLogger();

	@Autowired
	LoginService loginService;

	@PostMapping("/login.do")
	public ModelAndView validateUserlogin(String password, String userName, HttpSession session) {
		LOGGER.info("validateUserlogin method invoked");
		LOGGER.info("JSESSIONID: " + session.getId());
		ModelAndView modelAndView = new ModelAndView();
		if (password != null && userName != null) {
			User validUser = loginService.validateUser(userName, password);
			session.setAttribute("user", validUser);
			if (validUser != null) {
				modelAndView.setViewName("home");
				return modelAndView;
			} else {
				modelAndView.setViewName("login-error");
				return modelAndView;
			}
		} else {
			modelAndView.setViewName("login");
			return modelAndView;
		}
	}

}
