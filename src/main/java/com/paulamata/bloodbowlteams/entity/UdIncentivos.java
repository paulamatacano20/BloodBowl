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
@Table(name = "udincentivos")
public class UdIncentivos {
	private static final long serialVersionUID = 1L;
	@Id
	private int id;

	private int idincentivo;

	private int unidades;
	

	private int costeincentivo;
	

	private int costetotal;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdincentivo() {
		return idincentivo;
	}
	public void setIdincentivo(int idincentivo) {
		this.idincentivo = idincentivo;
	}
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	public int getCosteincentivo() {
		return costeincentivo;
	}
	public void setCosteincentivo(int costeincentivo) {
		this.costeincentivo = costeincentivo;
	}
	public int getCostetotal() {
		return costetotal;
	}
	public void setCostetotal(int costetotal) {
		this.costetotal = costetotal;
	}

	
	
}
