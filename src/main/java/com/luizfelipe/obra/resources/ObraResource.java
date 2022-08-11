package com.luizfelipe.obra.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.luizfelipe.obra.domain.Obra;
import com.luizfelipe.obra.domain.dtos.ObraDTO;
import com.luizfelipe.obra.services.ObraService;

@RestController
@RequestMapping(value = "/obras")
public class ObraResource {
	
	@Autowired
	private ObraService obraService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ObraDTO> findById(@PathVariable Long id) {
		Obra obj = obraService.findById(id);
		return ResponseEntity.ok().body(new ObraDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<ObraDTO>> findAll() {
		List<Obra> objs = obraService.findAll();
		
		List<ObraDTO> listDTO = objs.stream().map(obj -> new ObraDTO(obj)).collect(Collectors.toList());
	
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<ObraDTO> create(@Valid @RequestBody ObraDTO objDTO) {
		Obra obj = obraService.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
