package com.paulamata.bloodbowlteams.models.services;

import java.util.List;

import com.paulamata.bloodbowlteams.dto.UsuarioDTO;
import com.paulamata.bloodbowlteams.entity.Usuarios;

public interface IUsuarioService {
	
	public Usuarios login(String nombre, String contrasenya);
	public boolean register(UsuarioDTO usuarioDto);
	public List<Usuarios> findAll();

}
