package com.paulamata.bloodbowlteams.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.paulamata.bloodbowlteams.dao.IJugadoresDAO;

import com.paulamata.bloodbowlteams.entity.Jugadores;

@Service
public class JugadorServiceImpl implements IJugadorService{

	@Autowired
	private IJugadoresDAO jugadorDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<Jugadores> findAll() {
		return (List<Jugadores>) jugadorDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Jugadores findById(Long id) {
		return jugadorDAO.findById(id).orElse(null);
	}

}
