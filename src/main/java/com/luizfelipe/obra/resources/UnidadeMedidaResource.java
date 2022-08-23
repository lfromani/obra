package com.luizfelipe.obra.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.luizfelipe.obra.domain.UnidadeMedida;
import com.luizfelipe.obra.domain.dtos.UnidadeMedidaDTO;
import com.luizfelipe.obra.services.UnidadeMedidaService;

@RestController
@RequestMapping(value = "/unidadesmedida")
public class UnidadeMedidaResource {
	
	@Autowired
	private UnidadeMedidaService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UnidadeMedidaDTO> findById(@PathVariable Long id) {
		UnidadeMedida obj = service.findById(id);
		return ResponseEntity.ok().body(new UnidadeMedidaDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<UnidadeMedidaDTO>> findAll() {
		List<UnidadeMedida> list = service.findAll();
		List<UnidadeMedidaDTO> listDTO = list.stream().map(obj -> new UnidadeMedidaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<UnidadeMedidaDTO> create(@Valid @RequestBody UnidadeMedidaDTO objDTO) {
		UnidadeMedida newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getIdUnidadeMedida()).toUri();
		return ResponseEntity.created(uri).build();		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<UnidadeMedidaDTO> update(@PathVariable Long id, @Valid @RequestBody UnidadeMedidaDTO objDTO) {
		UnidadeMedida obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new UnidadeMedidaDTO(obj));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<UnidadeMedidaDTO> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
