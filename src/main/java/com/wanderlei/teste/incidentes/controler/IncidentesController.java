package com.wanderlei.teste.incidentes.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wanderlei.teste.incidentes.entities.Incidentes;
import com.wanderlei.teste.incidentes.repositories.IncidentesRepository;
import com.wanderlei.teste.incidentes.services.IncidenteService;

@RestController
@RequestMapping(value = "/incidentes")

public class IncidentesController {
	
	@Autowired
	private IncidenteService incidenteService;
	
	@Autowired
	private IncidentesRepository incidenteRepository;
	
	@GetMapping
	public List<Incidentes> findAll() {
		
		List<Incidentes> result = incidenteService.findAll();
		return result;
		
	}
	
	@GetMapping("/{id}")
	public Optional<Incidentes> findById(Long id) {
	
		Optional<Incidentes> result = incidenteService.findById(id);
		return result;
		
	}
	
	
    @PostMapping
    public Incidentes save( @RequestBody Incidentes incidente ){
        return incidenteRepository.save(incidente);
    }
    
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Long id){
        incidenteService.delete(id);
    }
    
    @PutMapping(value="/{id}")
    public Incidentes update(@RequestBody Incidentes obj, @PathVariable Long id) {

    	return this.incidenteService.update(id, obj);	

    }
}
