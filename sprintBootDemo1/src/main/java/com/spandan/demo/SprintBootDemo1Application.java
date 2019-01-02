package com.spandan.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SprintBootDemo1Application {

	public static void main(String[] args) {
		
		// creating a spring container and create a object of all @Components
		ConfigurableApplicationContext context =  SpringApplication.run(SprintBootDemo1Application.class, args);
		
		// getting spring bean from the container of some type
		Alien a = context.getBean(Alien.class); 
		a.show();
		
//		Alien a1 = context.getBean(Alien.class); 
//		a1.show(); 
		
		// here object will be created once when run method class will execute not twice 
		// because, by default, spring framework is using singleton scope.
		
		// so if we mention @Scope(value = "prototype") for any component or bean then it will create object
		// while we will use getBean() instead of creating object at the time of executing run method
		
		
		/*
		 * now, Alien class is dependent to Laptop class, so tell to Alient class that
		 * Laptop class object is available to use in spring container, for that we need to use @Autowired
		 * while creating dependent (Laptop) class object inside Alien class
		 */
		
	}

}

