package com.grs.controller;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignOutController {
	
	private static final Logger LOGGER = LogManager.getLogger();

	@GetMapping("/signout.do")
	public ModelAndView logout(HttpSession session) {
		LOGGER.info("logout method invoked");
		LOGGER.info("SessionID :"+session.getId());
		session.getAttribute("user");
		session.invalidate();
		LOGGER.info("SessionID :"+session.getId()); 
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("logout");
		return modelAndView;
	}
}
