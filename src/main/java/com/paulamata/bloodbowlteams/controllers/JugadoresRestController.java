package com.paulamata.bloodbowlteams.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paulamata.bloodbowlteams.entity.Jugadores;
import com.paulamata.bloodbowlteams.models.services.IJugadorService;

@CrossOrigin
@RestController
@RequestMapping("/api")

public class JugadoresRestController {
	
	@Autowired
	private IJugadorService JugadorService;
	@GetMapping("/jugadores")
	public List<Jugadores> index() {
		return JugadorService.findAll();
	}
	
	@GetMapping("/jugadores/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		Jugadores Jugadores = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			Jugadores = JugadorService.findById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(Jugadores == null) {
			response.put("mensaje", "El Jugador ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Jugadores>(Jugadores, HttpStatus.OK);
	}
}
