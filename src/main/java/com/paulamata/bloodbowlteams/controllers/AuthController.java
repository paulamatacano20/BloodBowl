package com.paulamata.bloodbowlteams.controllers;


import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
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
public class AuthController{
	public static SessionFactory sessionFactory = null;
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
	@PostMapping("/restablecer")
	public ResponseEntity<Void> restablecer(@RequestBody String usuario) throws NoSuchAlgorithmException, IOException{
		
		boolean find = false;
		for (Usuarios u : usuarioService.findAll()) {
			if(u.getNombre() == usuario) {

				Properties props = new Properties();
				   props.put("mail.smtp.auth", "true");
				   props.put("mail.smtp.starttls.enable", "true");
				   props.put("mail.smtp.host", "paulisken@gmail.com");
				   props.put("mail.smtp.port", "587");
				   
				   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				      protected PasswordAuthentication getPasswordAuthentication() {
				         return new PasswordAuthentication("paulisken@gmail.com", "paulita1116");
				      }
				   });
				   Message msg = new MimeMessage(session);
				   try {
					msg.setFrom(new InternetAddress(u.getNombre(), false));

					   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(u.getNombre()));
					   msg.setSubject("Tutorials point email");
					   msg.setContent("Tutorials point email", "text/html");
					   msg.setSentDate(new Date());

					   MimeBodyPart messageBodyPart = new MimeBodyPart();
					   messageBodyPart.setContent("Tutorials point email", "text/html");

					   Multipart multipart = new MimeMultipart();
					   multipart.addBodyPart(messageBodyPart);
					   MimeBodyPart attachPart = new MimeBodyPart();
					   multipart.addBodyPart(attachPart);
					   msg.setContent(multipart);
					   Transport.send(msg);   
				} catch (AddressException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				return ResponseEntity.status(HttpStatus.CREATED).body(null);
			}
		
		}
		if(!find) {
			
			
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(null);
			
			
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
		List<Usuarios> list = usuarioService.findAll();
		if(list.contains(usuarioDto))
			return true;
		else
			return false;
	}
	
}