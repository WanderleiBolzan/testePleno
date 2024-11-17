package com.wanderlei.teste.incidentes.entities;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_incidente")
public class Incidentes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idIncident;
	
	private String name;
	
	@Column(columnDefinition = "TEXT")	
	private String description;
	
	private Date createdAt;
	private Date updatedAt;
	private Date closedAt;
	
	public Incidentes() {		
	}

	public Incidentes(Long idIncident, String name, String description, Date createdAt, Date updatedAt, Date closedAt) {
		this.idIncident = idIncident;
		this.name = name;
		this.description = description;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.closedAt = closedAt;
	}

	public Long getIdIncident() {
		return idIncident;
	}

	public void setIdIncident(Long idIncident) {
		this.idIncident = idIncident;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Date getClosedAt() {
		return closedAt;
	}

	public void setClosedAt(Date closedAt) {
		this.closedAt = closedAt;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idIncident);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Incidentes other = (Incidentes) obj;
		return Objects.equals(idIncident, other.idIncident);
	}
		
}