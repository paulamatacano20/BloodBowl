package com.paulamata.bloodbowlteams.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.paulamata.bloodbowlteams.entity.Jugadores;

public interface IJugadoresDAO extends CrudRepository<Jugadores, Long>{

}