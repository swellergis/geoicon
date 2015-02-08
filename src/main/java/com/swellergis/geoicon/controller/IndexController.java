package com.swellergis.geoicon.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author Shaun
 *
 */
@Controller
public class IndexController {
	private static final String VIEW_INDEX = "index";
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(IndexController.class);

	/**
	 * 
	 * @param model
	 * @return
	 */
 	@RequestMapping(value = "/index.htm")
	public String getIndexDefault(ModelMap model) {
		logger.debug("[getIndexDefault]");
 		//model.addAttribute("message", "Index");
 		model.addAttribute("message", "");
		return VIEW_INDEX;
	}

 	/**
 	 * 
 	 * @param name
 	 * @param model
 	 * @return
 	 */
	@RequestMapping(value = "/{name}")
	public String getIndex(@PathVariable String name, ModelMap model) {
		logger.debug("[getIndex] name : {}", name);				
 		model.addAttribute("message", "Index: " + name);
		return VIEW_INDEX;
	}

}
