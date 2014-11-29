package com.swellergis.geoicon.controller;

import org.slf4j.LoggerFactory;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * HomeController is the default controller for the geoicon application.
 * 
 * @author Shaun
 *
 */
@Controller
@RequestMapping("/home")
public class HomeController {
	private static int counter = 0;
	private static final ReloadableResourceBundleMessageSource labels = new ReloadableResourceBundleMessageSource();
	private static final String VIEW_HOME = "home";
	private static String VERSION;
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	public HomeController() {
		// Set message source to /WEB-INF/classes/labels.properties
		labels.setBasename("labels");
		VERSION = labels.getMessage("version", null, null);
	}

	/**
	 * 
	 * @param model
	 * @return
	 */
 	@RequestMapping(value = "/")
	public String getWelcomeDefault(ModelMap model) {
		model.addAttribute("version", VERSION);
		model.addAttribute("counter", ++counter);
		logger.debug("[getWelcomeDefault] counter : {}", counter);

		// Spring uses InternalResourceViewResolver and returns index.jsp
		return VIEW_HOME;
	}

 	/**
 	 * 
 	 * @param name
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/{name}")
	public String getWelcome(@PathVariable String name, ModelMap model) {
 		model.addAttribute("message", "Welcome " + name);
		model.addAttribute("version", VERSION);
		model.addAttribute("counter", ++counter);
		logger.debug("[getWelcome] counter : {}", counter);				
		return VIEW_HOME;
	}

}
