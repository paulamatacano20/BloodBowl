package com.paulamata.bloodbowlteams.models.services;

import java.util.List;

import com.paulamata.bloodbowlteams.entity.Equipos;


public interface IEquiposService {
	public List<Equipos> findAll();
	
	public Equipos save(Equipos equipo);
	
	public Equipos findById(Long id);
	
	
	public void deleteById(Long id);
	
	public void delete(Equipos equipo);
}
