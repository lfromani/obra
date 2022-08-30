package com.luizfelipe.obra.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.luizfelipe.obra.domain.Movimento;
import com.luizfelipe.obra.repository.MovimentoRepository;

@Service
public class MovimentoService {

	@Autowired
	private MovimentoRepository repository;
	
	public List<Movimento> findByIdObra(Long idObra) {
		return repository.findByIdObra(idObra);
	}

}
