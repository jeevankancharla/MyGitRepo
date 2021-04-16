package com.te.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MvcController {
	
	
	@RequestMapping(path = "/kumar", method = RequestMethod.GET)

	public ModelAndView getnamePage() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/WEB-INF/views/kumar.jsp");
		return modelAndView;

	}

}
