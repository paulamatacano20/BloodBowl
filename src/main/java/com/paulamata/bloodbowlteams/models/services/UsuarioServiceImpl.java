package com.paulamata.bloodbowlteams.models.services;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.paulamata.bloodbowlteams.dao.IUsuarioDAO;
import com.paulamata.bloodbowlteams.dto.UsuarioDTO;
import com.paulamata.bloodbowlteams.entity.UdIncentivos;
import com.paulamata.bloodbowlteams.entity.Usuarios;
import com.paulamata.bloodbowlteams.utils.SecurityUtils;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	
	
	
	@Autowired
	public IUsuarioDAO usuarioDao;

	@Autowired
	public SecurityUtils securityUtils;
	
	@Override
	@Transactional(readOnly=true)
	public Usuarios login(String nombre, String contrasenya){
		try {
			return this.usuarioDao.login(nombre, securityUtils.encodePassword(contrasenya));
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}
	
	@Override
	@Transactional
	public boolean register(UsuarioDTO usuarioDto){
		
		
		try {
			
			Usuarios user = new Usuarios();
			user.setNombre(usuarioDto.getNombre());
			user.setContrasenya(securityUtils.encodePassword(usuarioDto.getContrasenya()));
			
			
				this.usuarioDao.save(user);
			return true;
		} catch (Exception e) {
			return false;
		}
		
		
		
	}

	@Override
	public List<Usuarios> findAll() {
		return (List<Usuarios>) usuarioDao.findAll();
	}

	
	
	
	

	
	
}
