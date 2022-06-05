package com.paulamata.bloodbowlteams.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Jugadores {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	private String raza;
	
	@Column(name = "jugador_estrella")
	private boolean jugadorEstrella;
	
	private String nombre;
	private int movimiento;
	private int fuerza;
	private int agilidad;
	
	@Column(name = "habilidad_pase")
	private int habilidadPase;
	
	private int armadura;
	private String habilidades;
	
	@Column(name = "coste_k")
	private int costeK;
	
	private int maximo;

	
	
	
	public Jugadores() {
		super();
		
	}

	public Jugadores(int id, String raza, boolean jugadorEstrella, String nombre, int movimiento, int fuerza,
			int agilidad, int habilidadPase, int armadura, String habilidades, int costeK, int maximo) {
		super();
		this.id = id;
		this.raza = raza;
		this.jugadorEstrella = jugadorEstrella;
		this.nombre = nombre;
		this.movimiento = movimiento;
		this.fuerza = fuerza;
		this.agilidad = agilidad;
		this.habilidadPase = habilidadPase;
		this.armadura = armadura;
		this.habilidades = habilidades;
		this.costeK = costeK;
		this.maximo = maximo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public boolean isJugadorEstrella() {
		return jugadorEstrella;
	}

	public void setJugadorEstrella(boolean jugadorEstrella) {
		this.jugadorEstrella = jugadorEstrella;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(int movimiento) {
		this.movimiento = movimiento;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public int getAgilidad() {
		return agilidad;
	}

	public void setAgilidad(int agilidad) {
		this.agilidad = agilidad;
	}

	public int getHabilidadPase() {
		return habilidadPase;
	}

	public void setHabilidadPase(int habilidadPase) {
		this.habilidadPase = habilidadPase;
	}

	public int getArmadura() {
		return armadura;
	}

	public void setArmadura(int armadura) {
		this.armadura = armadura;
	}

	public String getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(String habilidades) {
		this.habilidades = habilidades;
	}

	public int getCosteK() {
		return costeK;
	}

	public void setCosteK(int costeK) {
		this.costeK = costeK;
	}

	public int getMaximo() {
		return maximo;
	}

	public void setMaximo(int maximo) {
		this.maximo = maximo;
	}
	
	

	
	

}
