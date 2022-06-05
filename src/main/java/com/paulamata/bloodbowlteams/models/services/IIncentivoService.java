package com.paulamata.bloodbowlteams.models.services;

import java.util.List;

import com.paulamata.bloodbowlteams.entity.Incentivos;


public interface IIncentivoService {
	public List<Incentivos> findAll();
	
	public Incentivos findById(Long id);
}
