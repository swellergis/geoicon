package com.swellergis.geoicon.controller;

import main.java.hello.Greeter;

import org.joda.time.LocalTime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
 
// Use @Controller annotation so Spring will recognize this bean as being a Controller bean 
// for processing requests when it scans the package.
@Controller
public class WelcomeController {
	// Use @RequestMapping annotation to tell Spring that this Controller should process all
	// requests beginning with /howdy in the URL path. That includes /howdy/* and /howdy.html
    @RequestMapping("/howdy")
    public ModelAndView howdyWorld() {
        LocalTime currentTime = new LocalTime();
        Greeter greeter = new Greeter();
        String message = greeter.sayHello() + "\nThe current local time is: " + currentTime;
        return new ModelAndView("howdy", "message", message);
    }
}