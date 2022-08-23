package com.luizfelipe.obra.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.luizfelipe.obra.domain.UnidadeMedida;
import com.luizfelipe.obra.domain.dtos.UnidadeMedidaDTO;
import com.luizfelipe.obra.repository.UnidadeMedidaRepository;
import com.luizfelipe.obra.services.exceptions.ObjetoNaoEncontradoException;

@Service
public class UnidadeMedidaService {
	
	@Autowired
	UnidadeMedidaRepository repository;
	
	public UnidadeMedida findById(Long id) {
		Optional<UnidadeMedida> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("UnidadeMedida não encontrado! ID: " + id));
	}

	public List<UnidadeMedida> findAll() {
		return repository.findAll();
	}

	public UnidadeMedida create(UnidadeMedidaDTO objDTO) {
		objDTO.setIdUnidadeMedida(null);

		UnidadeMedida newObj = new UnidadeMedida(objDTO);
		return repository.save(newObj);
	}

	public UnidadeMedida update(Long id, @Valid UnidadeMedidaDTO objDTO) {
		objDTO.setIdUnidadeMedida(id);
		UnidadeMedida oldObj = findById(id);
		oldObj = new UnidadeMedida(objDTO);
		return repository.save(oldObj);
	}

	public void delete(Long id) {
		UnidadeMedida obj = findById(id);
		if (Objects.nonNull(obj))
			repository.deleteById(id);
	}
	
}
