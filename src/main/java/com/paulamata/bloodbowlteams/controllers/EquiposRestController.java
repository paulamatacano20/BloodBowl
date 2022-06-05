package com.paulamata.bloodbowlteams.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
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

import com.paulamata.bloodbowlteams.entity.Equipos;
import com.paulamata.bloodbowlteams.models.services.IEquiposService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class EquiposRestController {
	@Autowired(required=true)
	private IEquiposService equipoService;
	@GetMapping("/equipos")
	public List<Equipos> index() {

		return equipoService.findAll();
	}
	
	@GetMapping("/equipos/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		Equipos Equipos = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			Equipos = equipoService.findById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(Equipos == null) {
			response.put("mensaje", "El Incentivo ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Equipos>(Equipos, HttpStatus.OK);
	}
	
	@PostMapping("/equipos/insert")
	public ResponseEntity<Void> create(@RequestBody Equipos Equipos) throws NoSuchAlgorithmException{
		
		Equipos EquiposNew = null;
		try {
			EquiposNew = equipoService.save(Equipos);
		} catch(DataAccessException e) {
			
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}
	
	@PostMapping("/equipos/update")
	public ResponseEntity<Void> update(@RequestBody Equipos Equipos) {

		Equipos EquiposActual = equipoService.findById(Equipos.getId());

		Equipos EquiposUpdated = null;
		try {
			EquiposActual.setId(Equipos.getId());
			EquiposActual.setNombre(Equipos.getNombre());
			EquiposActual.setRaza(Equipos.getRaza());
			EquiposActual.setUsuario(Equipos.getUsuario());
			EquiposActual.setMonedasDisponibles(Equipos.getMonedasDisponibles());
			EquiposActual.setJugador1(Equipos.getJugador1());
			EquiposActual.setJugador2(Equipos.getJugador2());
			EquiposActual.setJugador3(Equipos.getJugador3());
			EquiposActual.setJugador4(Equipos.getJugador4());
			EquiposActual.setJugador5(Equipos.getJugador5());
			EquiposActual.setJugador6(Equipos.getJugador6());
			EquiposActual.setJugador7(Equipos.getJugador7());
			EquiposActual.setJugador8(Equipos.getJugador8());
			EquiposActual.setJugador9(Equipos.getJugador9());
			EquiposActual.setJugador10(Equipos.getJugador10());
			EquiposActual.setJugador11(Equipos.getJugador11());
			EquiposActual.setIncentivo1(Equipos.getIncentivo1());
			EquiposActual.setIncentivo2(Equipos.getIncentivo2());
			EquiposActual.setIncentivo3(Equipos.getIncentivo3());
			EquiposActual.setIncentivo4(Equipos.getIncentivo4());
			EquiposActual.setIncentivo5(Equipos.getIncentivo5());
			EquiposActual.setIncentivo6(Equipos.getIncentivo6());
			EquiposActual.setIncentivo7(Equipos.getIncentivo7());
			EquiposActual.setIncentivo8(Equipos.getIncentivo8());
			EquiposActual.setIncentivo9(Equipos.getIncentivo9());
			EquiposActual.setIncentivo10(Equipos.getIncentivo10());
			EquiposActual.setIncentivo11(Equipos.getIncentivo11());
			EquiposActual.setIncentivo12(Equipos.getIncentivo12());
			EquiposActual.setIncentivo13(Equipos.getIncentivo13());
		
			EquiposUpdated = equipoService.save(EquiposActual);

		} catch (DataAccessException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}
	@DeleteMapping("/equipos/delete/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		
		try {
		    equipoService.deleteById(id);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
			
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(null);

	}
	
	
}
