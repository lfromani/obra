package com.luizfelipe.obra.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.luizfelipe.obra.domain.Cliente;
import com.luizfelipe.obra.repository.ClienteRepository;
import com.luizfelipe.obra.services.exceptions.ObjetoNaoEncontradoException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente findById(Long id) {
		Optional<Cliente> obj = clienteRepository.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado! ID: " + id));
	}

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

}
