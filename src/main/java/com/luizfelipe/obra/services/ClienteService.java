package com.luizfelipe.obra.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.luizfelipe.obra.domain.Cliente;
import com.luizfelipe.obra.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente findById(Long id) {
		Optional<Cliente> obj = clienteRepository.findById(id);
		return obj.orElse(null);
	}

}
