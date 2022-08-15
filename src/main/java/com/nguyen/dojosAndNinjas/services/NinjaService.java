package com.nguyen.dojosAndNinjas.services;

import java.util.List;
import java.util.Optional;

import com.nguyen.dojosAndNinjas.repositories.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyen.dojosAndNinjas.models.Ninja;

@Service
public class NinjaService {
	
	@Autowired
    NinjaRepository ninjaRepository;
	
	public List<Ninja> fetchAllNinjas() {
		return ninjaRepository.findAll();
	}
	
	public Ninja saveNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}
	
	public Ninja fetchOneNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
		if (optionalNinja.isEmpty()) return null;
		return optionalNinja.get();
	}
	
	public void deleteNinja(Ninja ninja) {
		ninjaRepository.delete(ninja);
	}

}
