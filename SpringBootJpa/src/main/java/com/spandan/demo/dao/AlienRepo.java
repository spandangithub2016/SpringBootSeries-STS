package com.spandan.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.spandan.demo.model.Alien;

public interface AlienRepo extends CrudRepository<Alien, Integer> {

	/** 
	 * Spring JPA provides a special feature:
	 * we can search by any property of an entity without creating any method for that
	 * so, spring jpa provides the syntax of 
	 * prefix: findBy
	 * suffix: propertyName
	 * Example: findByTech(String param)
	 * Note: Here tech is the property of Alien class
	 * and there is no findByTech() method is written to get the details.
	 */
	List<Alien> findByTech(String tech);
	
	/** 
	 * Spring JPA provides a special feature:
	 * we can search by any property of an entity without creating any method for that
	 * so, spring jpa provides the syntax of 
	 * prefix: findBy
	 * suffix: propertyName and 
	 * then which operation we want to perform Ex: GreaterThan, LessThan
	 * Example: findByTech(String param)
	 * Note: Here tech is the property of Alien class
	 * and there is no findByTech() method is written to get the details.
	 */
	List<Alien> findByAidGreaterThan(int aid);
	
	/** 
	 * Here, We want to write our own query and execute it.
	 * Since, findByTechSorted(String param) is not a valid method name as per the JPA protocol.
	 * So, JPA provides @Query to mention dynamic query - JPQL
	 * 
	 */
	@Query("From Alien where tech = ?1 Order By aname")
	List<Alien> findByTechSorted(String tech);
}
