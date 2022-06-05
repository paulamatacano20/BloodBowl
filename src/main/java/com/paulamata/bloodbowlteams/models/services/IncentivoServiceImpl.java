package com.paulamata.bloodbowlteams.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paulamata.bloodbowlteams.dao.IIncentivosDAO;
import com.paulamata.bloodbowlteams.entity.Incentivos;


@Service
public class IncentivoServiceImpl implements IIncentivoService{

	@Autowired
	private IIncentivosDAO incentivoDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<Incentivos> findAll() {
		return (List<Incentivos>) incentivoDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Incentivos findById(Long id) {
		return incentivoDAO.findById(id).orElse(null);
	}

}
