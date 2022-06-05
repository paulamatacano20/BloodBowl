package com.paulamata.bloodbowlteams.models.services;

import java.util.List;

import com.paulamata.bloodbowlteams.entity.Jugadores;


public interface IJugadorService {
	public List<Jugadores> findAll();
	
	public Jugadores findById(Long id);

}
