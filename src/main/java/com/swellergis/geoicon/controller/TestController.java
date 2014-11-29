package com.swellergis.geoicon.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author Shaun
 *
 */
@Controller
@RequestMapping("/test")
public class TestController {
	private static final String VIEW_TEST = "test";
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestController.class);

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getTestDefault(ModelMap model) {
		logger.debug("[getTestDefault]");				
		model.addAttribute("test", "this is default test");
		return VIEW_TEST;
	}

	/**
	 * 
	 * @param name
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String getTest(@PathVariable String name, ModelMap model) {
		logger.debug("[getTest] name : {}", name);				
		model.addAttribute("test", name);
		return VIEW_TEST;
	}

}
