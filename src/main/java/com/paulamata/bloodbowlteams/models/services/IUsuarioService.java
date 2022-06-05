package com.paulamata.bloodbowlteams.models.services;

import com.paulamata.bloodbowlteams.dto.UsuarioDTO;
import com.paulamata.bloodbowlteams.entity.Usuarios;

public interface IUsuarioService {
	
	public Usuarios login(String nombre, String contrasenya);
	public boolean register(UsuarioDTO usuarioDto);

}
