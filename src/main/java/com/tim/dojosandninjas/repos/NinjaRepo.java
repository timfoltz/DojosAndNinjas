package com.tim.dojosandninjas.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tim.dojosandninjas.models.Ninja;

public interface NinjaRepo extends CrudRepository<Ninja, Long>{
	List<Ninja> findAll();

}
