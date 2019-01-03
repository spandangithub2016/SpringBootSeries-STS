package com.spandan.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.spandan.demo.model.Alien;

public interface AlienRepo extends CrudRepository<Alien, Integer> {

}
