package com.paulamata.bloodbowlteams.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paulamata.bloodbowlteams.dao.IEquiposDAO;
import com.paulamata.bloodbowlteams.entity.Equipos;
@Service
public class EquiposServiceIml implements IEquiposService{

	@Autowired
	private IEquiposDAO equiposDAO;
	
	@Override
	public List<Equipos> findAll() {
		return (List<Equipos>) equiposDAO.findAll();
	}

	@Override
	public Equipos save(Equipos equipos) {
		return equiposDAO.save(equipos);
	}

	@Override
	public Equipos findById(Long id) {
		return equiposDAO.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		equiposDAO.deleteById(id);
		
	}

	@Override
	public void delete(Equipos equipo) {
		equiposDAO.delete(equipo);
		
	}

}
