package com.paulamata.bloodbowlteams.controllers;


import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paulamata.bloodbowlteams.dto.RespuestaLoginDTO;
import com.paulamata.bloodbowlteams.dto.UsuarioDTO;
import com.paulamata.bloodbowlteams.entity.Usuarios;
import com.paulamata.bloodbowlteams.models.services.IUsuarioService;
import com.paulamata.bloodbowlteams.security.SecurityConstants;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/auth")
public class AuthController {
	public static SessionFactory sessionFactory;
	public static Session session;
	@Autowired
	private IUsuarioService usuarioService;
	
	@PostMapping("/login")
	public ResponseEntity<RespuestaLoginDTO> login(@RequestBody UsuarioDTO usuarioLogin){	
		Usuarios user = usuarioService.login(usuarioLogin.getNombre(), usuarioLogin.getContrasenya());
		
		if(user != null) {
			return ResponseEntity.ok().body(new RespuestaLoginDTO(getToken(user)));
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
	}
	
	@PostMapping("/register")
	public ResponseEntity<Void> register(@RequestBody UsuarioDTO usuarioDto) throws NoSuchAlgorithmException {
		boolean existe = consultarUsuarios(usuarioDto);
		boolean resultado = false;
		if(!existe)
			resultado = usuarioService.register(usuarioDto);
		
		if(resultado) {
			return ResponseEntity.status(HttpStatus.CREATED).body(null); 
		}else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
	}

	
	private String getToken(Usuarios usuario) {	
		Map<String, Object> data = new HashMap<String, Object>();
		
		data.put("nombre", usuario.getNombre());
		data.put("contrasenya", usuario.getContrasenya());
		data.put("authorities", Arrays.asList("ROLE_USER"));
		
		String token = Jwts.builder().setId("springCliente")
				.setSubject(usuario.getNombre()).addClaims(data)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 3600000))  // una hora
				.signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET_KEY).compact();
		System.out.println(SecurityConstants.SECRET_KEY);
		
		return token;
	}
	private boolean consultarUsuarios(UsuarioDTO usuarioDto) {
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		String consulta = "select * FROM usuarios WHERE nombre = '"+usuarioDto.getNombre()+"'";
		
		List<Usuarios> list = session.createNativeQuery(consulta)
				.addEntity(Usuarios.class)
				.list();
		session.close();
		if(list.size() > 0)
			return true;
		else
			return false;
	}
	
}