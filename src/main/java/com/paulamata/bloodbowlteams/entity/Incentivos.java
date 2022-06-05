package com.paulamata.bloodbowlteams.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Incentivos {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	private String incentivo;
	@Column(name = "coste_k")
	private int costeK;
	private int minimo;
	private int maximo;
	
	
	
	public Incentivos() {
		super();
		
	}
	public Incentivos(String incentivo, int costeK, int minimo, int maximo) {
		super();
		this.incentivo = incentivo;
		this.costeK = costeK;
		this.minimo = minimo;
		this.maximo = maximo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIncentivo() {
		return incentivo;
	}
	public void setIncentivo(String incentivo) {
		this.incentivo = incentivo;
	}
	public int getCosteK() {
		return costeK;
	}
	public void setCosteK(int costeK) {
		this.costeK = costeK;
	}
	public int getMinimo() {
		return minimo;
	}
	public void setMinimo(int minimo) {
		this.minimo = minimo;
	}
	public int getMaximo() {
		return maximo;
	}
	public void setMaximo(int maximo) {
		this.maximo = maximo;
	}
	
	

}
