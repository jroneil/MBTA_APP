package com.oneil;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

	@Controller
	public class PageController {
	@RequestMapping("/getStops")
		    public String getStops() {
		       
		        return "stops";
		    }
	}

