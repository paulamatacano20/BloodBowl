package com.paulamata.bloodbowlteams.dto;

import java.io.Serializable;

import javax.persistence.Id;



public class UsuarioDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private String nombre;
	private String contrasenya;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContrasenya() {
		return contrasenya;
	}
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}


}