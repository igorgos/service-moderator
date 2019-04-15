package com.endava.moderator.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);  

    @GetMapping("/")
    public String showHomePage() {
    	logger.info("index");
        return "index";
    }

    @GetMapping("/pp")
    public String showPpPage() {
    	logger.info("pp");
        return "pp";
    }

    @GetMapping("/qq")
    public String showQqPage() {
    	logger.info("qq");
        return "qq";
    }
}
