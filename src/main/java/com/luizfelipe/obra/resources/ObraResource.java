package com.luizfelipe.obra.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

}
