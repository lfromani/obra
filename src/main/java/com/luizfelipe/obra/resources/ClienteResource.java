package com.luizfelipe.obra.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.luizfelipe.obra.domain.Cliente;
import com.luizfelipe.obra.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService clienteService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Long id) {
		Cliente obj = clienteService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
