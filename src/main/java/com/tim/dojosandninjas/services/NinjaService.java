package com.tim.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tim.dojosandninjas.models.Ninja;
import com.tim.dojosandninjas.repos.NinjaRepo;

@Service
public class NinjaService {
	@Autowired
	private NinjaRepo ninjaRepo;
//	******Create******
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}

	
//	******Read ONE******
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
		return optionalNinja !=null ? optionalNinja.get() : null;
	}
	
//	******Read ALL******
	public List<Ninja> allNinjas()	{
		return ninjaRepo.findAll();
	}
	
//	******Update******
	public void updateNinja(Ninja ninja) {
		ninjaRepo.save(ninja);
	}
//	******Destroy/Delete******
	public void deleteNinja(Long id) {
		ninjaRepo.deleteById(id);
	}
}
