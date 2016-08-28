package com.ryde.fm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StaticController {

	@RequestMapping({"/","/home"})
public String getIndexPage(){
	
	return "static/index.html";
}
}
