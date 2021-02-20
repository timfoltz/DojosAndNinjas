package com.tim.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tim.dojosandninjas.models.Dojo;
import com.tim.dojosandninjas.repos.DojoRepo;

@Service
public class DojoService {
	@Autowired
	private DojoRepo dojoRepo;
//	******Create******
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}

	
//	******Read ONE******
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		return optionalDojo !=null ? optionalDojo.get() : null;
	}
//	******Read ALL******
	public List<Dojo> allDojos()	{
		return dojoRepo.findAll();
	}
//	******Update******
	public void updateDojo(Dojo dojo) {
		dojoRepo.save(dojo);
	}
//	******Destroy/Delete******
	public void deleteDojo(Long id) {
		dojoRepo.deleteById(id);
	}
}
