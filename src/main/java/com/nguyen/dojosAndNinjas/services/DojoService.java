package com.nguyen.dojosAndNinjas.services;

import java.util.List;
import java.util.Optional;

import com.nguyen.dojosAndNinjas.models.Dojo;
import com.nguyen.dojosAndNinjas.repositories.DojoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DojoService {
	
	@Autowired
    DojoRepository dojoRepository;
	
	// getting all dojos
	public List<Dojo> fetchAllDojos() {
		return dojoRepository.findAll();
	}
	
	// creating and updating an dojo
	public Dojo saveDojo(Dojo dojo) {
		return dojoRepository.save(dojo);
	}
	
	// getting one dojo
	public Dojo fetchOneDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		if (optionalDojo.isEmpty()) return null;
		return optionalDojo.get();
	}
	
	// deleting an dojo
	public void deleteDojo(Dojo dojo) {
		dojoRepository.delete(dojo);
	}

}
