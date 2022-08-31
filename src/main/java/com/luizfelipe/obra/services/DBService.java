package com.luizfelipe.obra.services;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.luizfelipe.obra.domain.Usuario;
import com.luizfelipe.obra.repository.UsuarioRepository;

@Service
public class DBService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public void instanciaDB() {
		Usuario usuario = new Usuario(null, "Luiz Felipe Romani", LocalDate.now(), "07626926935", "luiz.romani", encoder.encode("123"));
		Usuario usuario2 = new Usuario(null, "Marcelo Canci", LocalDate.now(), "97206228062", "marcelo.canci", encoder.encode("123"));
		
		usuarioRepository.saveAll(Arrays.asList(usuario, usuario2));
	}

}
