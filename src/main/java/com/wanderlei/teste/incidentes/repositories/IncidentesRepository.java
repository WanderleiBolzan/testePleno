package com.wanderlei.teste.incidentes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wanderlei.teste.incidentes.entities.Incidentes;

public interface IncidentesRepository extends JpaRepository<Incidentes, Long> {
}
