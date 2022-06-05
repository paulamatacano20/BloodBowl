package com.paulamata.bloodbowlteams.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "equipos")
public class Equipos {
private static final long serialVersionUID = 1L;
	@Id
	private Long id;
	private String usuario;
	private String nombre;
	private String raza;
	private int jugador1;
	private int jugador2;
	private int jugador3;
	private int jugador4;
	private int jugador5;
	private int jugador6;
	private int jugador7;
	private int jugador8;
	private int jugador9;
	private int jugador10;
	private int jugador11;
	private int incentivo1;
	private int incentivo2;
	private int incentivo3;
	private int incentivo4;
	private int incentivo5;
	private int incentivo6;
	private int incentivo7;
	private int incentivo8;
	private int incentivo9;
	private int incentivo10;
	private int incentivo11;
	private int incentivo12;
	private int incentivo13;
	@Column(name = "monedas_disponibles")
	private int monedasDisponibles;
	
	public int getMonedasDisponibles() {
		return monedasDisponibles;
	}
	public void setMonedasDisponibles(int monedasDisponibles) {
		this.monedasDisponibles = monedasDisponibles;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public int getJugador1() {
		return jugador1;
	}
	public void setJugador1(int jugador1) {
		this.jugador1 = jugador1;
	}
	public int getJugador2() {
		return jugador2;
	}
	public void setJugador2(int jugador2) {
		this.jugador2 = jugador2;
	}
	public int getJugador3() {
		return jugador3;
	}
	public void setJugador3(int jugador3) {
		this.jugador3 = jugador3;
	}
	public int getJugador4() {
		return jugador4;
	}
	public void setJugador4(int jugador4) {
		this.jugador4 = jugador4;
	}
	public int getJugador5() {
		return jugador5;
	}
	public void setJugador5(int jugador5) {
		this.jugador5 = jugador5;
	}
	public int getJugador6() {
		return jugador6;
	}
	public void setJugador6(int jugador6) {
		this.jugador6 = jugador6;
	}
	public int getJugador7() {
		return jugador7;
	}
	public void setJugador7(int jugador7) {
		this.jugador7 = jugador7;
	}
	public int getJugador8() {
		return jugador8;
	}
	public void setJugador8(int jugador8) {
		this.jugador8 = jugador8;
	}
	public int getJugador9() {
		return jugador9;
	}
	public void setJugador9(int jugador9) {
		this.jugador9 = jugador9;
	}
	public int getJugador10() {
		return jugador10;
	}
	public void setJugador10(int jugador10) {
		this.jugador10 = jugador10;
	}
	public int getJugador11() {
		return jugador11;
	}
	public void setJugador11(int jugador11) {
		this.jugador11 = jugador11;
	}
	public int getIncentivo1() {
		return incentivo1;
	}
	public void setIncentivo1(int incentivo1) {
		this.incentivo1 = incentivo1;
	}
	public int getIncentivo2() {
		return incentivo2;
	}
	public void setIncentivo2(int incentivo2) {
		this.incentivo2 = incentivo2;
	}
	public int getIncentivo3() {
		return incentivo3;
	}
	public void setIncentivo3(int incentivo3) {
		this.incentivo3 = incentivo3;
	}
	public int getIncentivo4() {
		return incentivo4;
	}
	public void setIncentivo4(int incentivo4) {
		this.incentivo4 = incentivo4;
	}
	public int getIncentivo5() {
		return incentivo5;
	}
	public void setIncentivo5(int incentivo5) {
		this.incentivo5 = incentivo5;
	}
	public int getIncentivo6() {
		return incentivo6;
	}
	public void setIncentivo6(int incentivo6) {
		this.incentivo6 = incentivo6;
	}
	public int getIncentivo7() {
		return incentivo7;
	}
	public void setIncentivo7(int incentivo7) {
		this.incentivo7 = incentivo7;
	}
	public int getIncentivo8() {
		return incentivo8;
	}
	public void setIncentivo8(int incentivo8) {
		this.incentivo8 = incentivo8;
	}
	public int getIncentivo9() {
		return incentivo9;
	}
	public void setIncentivo9(int incentivo9) {
		this.incentivo9 = incentivo9;
	}
	public int getIncentivo10() {
		return incentivo10;
	}
	public void setIncentivo10(int incentivo10) {
		this.incentivo10 = incentivo10;
	}
	public int getIncentivo11() {
		return incentivo11;
	}
	public void setIncentivo11(int incentivo11) {
		this.incentivo11 = incentivo11;
	}
	public int getIncentivo12() {
		return incentivo12;
	}
	public void setIncentivo12(int incentivo12) {
		this.incentivo12 = incentivo12;
	}
	public int getIncentivo13() {
		return incentivo13;
	}
	public void setIncentivo13(int incentivo13) {
		this.incentivo13 = incentivo13;
	}

	
	

}
