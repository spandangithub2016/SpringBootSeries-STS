package com.spandan.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("home")
	public String home(HttpServletRequest request)
	{
		String name = request.getParameter("name");
		System.out.println("Hi "+ name);
		
		HttpSession session = request.getSession();
		session.setAttribute("name", name); // sending data to view
		
		return "home";
	}

}
