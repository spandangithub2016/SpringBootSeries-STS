package com.spandan.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	// one way to controller
	@RequestMapping("home")
	public String home(HttpServletRequest request)
	{
		String name = request.getParameter("name");
		System.out.println("Hi "+ name);
		
		HttpSession session = request.getSession();
		session.setAttribute("name", name); // sending data to view
		
		// return view name
		return "home";
	}
	
	/**
	 * In case, we have different parameter name (myName) in controller methods
	 * compare to url(localhost:8080/home?name=Spandy) param name (name), then we
	 * will use @RequestParam to link them to the specific menthod parameter from
	 * url parameter.
	 */
	// another way to controller
	@RequestMapping("home1")
	public String home1(@RequestParam("name") String myName, HttpSession session)
	{
		
		//String name = request.getParameter("name");
		System.out.println("Hi "+ myName);
		
		//HttpSession session = request.getSession();
		session.setAttribute("name", myName); // sending data to view
		
		// return view name
		return "home";  
	}
	
	/**
	 * Model and View example to return the view name to dispatcher servlet through ModelAndView
	 */
	// another way to controller
	@RequestMapping("home2")
	public ModelAndView home2(@RequestParam("name") String myName)
	{
		// Creating object
		ModelAndView modelView = new ModelAndView();
		
		// Setting vlaues to modelview object
		modelView.addObject("name", myName);
		
		// Setting view name 
		modelView.setViewName("home");
		
		// return modelAndView obejct with value to the particular view(home.jsp)
		return modelView;
		
		
	}

}
