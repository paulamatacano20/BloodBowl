package com.paulamata.bloodbowlteams.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paulamata.bloodbowlteams.dao.IUdIncentivosDAO;
import com.paulamata.bloodbowlteams.entity.UdIncentivos;




@Service
public class UdIncentivosServiceImpl implements IUdIncentivosService{

	@Autowired
	private IUdIncentivosDAO udIncentivosDAO;
	
	@Override
	public List<UdIncentivos> findAll() {
		return (List<UdIncentivos>) udIncentivosDAO.findAll();
	}

	@Override
	public UdIncentivos save(UdIncentivos udIncentivos) {
		return udIncentivosDAO.save(udIncentivos);
	}

	@Override
	public UdIncentivos findById(Long id) {
		return udIncentivosDAO.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		udIncentivosDAO.deleteById(id);
		
	}

	@Override
	public void delete(UdIncentivos udIncentivos) {
		udIncentivosDAO.delete(udIncentivos);
	}
		
	

}

