package com.localizar.locapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String index(){
		System.out.println("Testando");
		
		return "index";
		
	}
}
