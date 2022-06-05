package com.paulamata.bloodbowlteams.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paulamata.bloodbowlteams.entity.UdIncentivos;
import com.paulamata.bloodbowlteams.entity.UdIncentivos;
import com.paulamata.bloodbowlteams.models.services.IUdIncentivosService;



@CrossOrigin
@RestController
@RequestMapping("/api")
public class UdIncentivosRestController {
	@Autowired
	private IUdIncentivosService udIncentivosService;
	
	@GetMapping("/udincentivos")
	public List<UdIncentivos> index() {
		return udIncentivosService.findAll();
	}
	
	@GetMapping("/udincentivos/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		UdIncentivos UdIncentivos = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			UdIncentivos = udIncentivosService.findById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(UdIncentivos == null) {
			response.put("mensaje", "El Incentivo ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<UdIncentivos>(UdIncentivos, HttpStatus.OK);
	}
	
	@PostMapping("/udincentivos/insertlist")
	public ResponseEntity<Void> create2(@RequestBody List<UdIncentivos> udIncentivos){

		try {
			for (int j = 0; j < udIncentivos.size(); j++) {
				udIncentivosService.save(udIncentivos.get(j));
				
			}
			
		} catch(DataAccessException e) {
			
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}
	
	@PutMapping("/udincentivos/{id}")
	public ResponseEntity<?> update( @RequestBody UdIncentivos UdIncentivos, @PathVariable Long id) {

		UdIncentivos UdIncentivosActual = udIncentivosService.findById(id);

		UdIncentivos UdIncentivosUpdated = null;

		try {

			UdIncentivosActual.setId(UdIncentivos.getId());
			UdIncentivosActual.setIdincentivo(UdIncentivos.getIdincentivo());
			UdIncentivosActual.setUnidades(UdIncentivos.getUnidades());
			UdIncentivosActual.setCosteincentivo(UdIncentivos.getCosteincentivo());
			UdIncentivosActual.setCostetotal(UdIncentivos.getCostetotal());
		
			UdIncentivosUpdated = udIncentivosService.save(UdIncentivosActual);

		} catch (DataAccessException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}

		

		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}
	@DeleteMapping("/udincentivos/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
		    udIncentivosService.deleteById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el People de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El People eliminado con éxito!");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
