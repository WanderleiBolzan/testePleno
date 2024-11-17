package com.wanderlei.teste.incidentes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wanderlei.teste.incidentes.entities.Incidentes;
import com.wanderlei.teste.incidentes.repositories.IncidentesRepository;

@Service
public class IncidenteService {

	@Autowired
	private IncidentesRepository incidenteRepository;
	
	
	@Transactional(readOnly = true)
	public List<Incidentes> findAll(){
		
		List<Incidentes> result = incidenteRepository.findAll();
		return result;
	
	}
	
	@Transactional(readOnly = true)
	public Optional<Incidentes> findById(Long id){
		
		Optional<Incidentes> result = incidenteRepository.findById(id);
		return result;
	
	}
	
	
	
    @Transactional
    public void delete(Long id) {
        incidenteRepository.deleteById(id);
    }
    
    @Transactional
    public Incidentes update(Long id, Incidentes obj) {

    	Optional<Incidentes> i = incidenteRepository.findById(id);

    	Incidentes update = null;

    	if(i.isPresent()) {
    		update = i.get();
    		update.setName(obj.getName());
    		update.setDescription(obj.getDescription());
    		update.setCreatedAt(obj.getCreatedAt());
    		update.setUpdatedAt(obj.getUpdatedAt());
    		update.setClosedAt(obj.getClosedAt());

    		update = this.incidenteRepository.save(update);

    	}

    	return update;

    }
}

