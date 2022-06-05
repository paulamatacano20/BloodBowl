package com.paulamata.bloodbowlteams.models.services;

import java.util.List;

import com.paulamata.bloodbowlteams.entity.UdIncentivos;

public interface IUdIncentivosService {
	public List<UdIncentivos> findAll();
	
	public UdIncentivos save(UdIncentivos cliente);
	
	public UdIncentivos findById(Long id);
	
	public void delete(UdIncentivos cliente);
	
	public void deleteById(Long id);
}
