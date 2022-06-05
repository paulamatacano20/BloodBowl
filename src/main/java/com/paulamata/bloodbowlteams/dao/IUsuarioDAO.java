package com.paulamata.bloodbowlteams.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.paulamata.bloodbowlteams.entity.Usuarios;



@Repository
public interface IUsuarioDAO extends CrudRepository<Usuarios, Long> {
	@Query("select u from Usuarios u where nombre = ?1  and contrasenya = ?2")
	public Usuarios login(String nombre, String contrasenya);

	

	
}
