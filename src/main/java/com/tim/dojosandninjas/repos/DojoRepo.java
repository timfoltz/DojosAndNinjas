package com.tim.dojosandninjas.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tim.dojosandninjas.models.Dojo;

public interface DojoRepo extends CrudRepository<Dojo, Long> {
	List<Dojo> findAll();
}
