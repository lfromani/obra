package com.luizfelipe.obra.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luizfelipe.obra.domain.Obra;
import com.luizfelipe.obra.repository.ObraRepository;
import com.luizfelipe.obra.services.exceptions.ObjetoNaoEncontradoException;

@Service
public class ObraService {
	
	@Autowired
	private ObraRepository obraRepository;
	
	public Obra findById(Long id) {
		Optional<Obra> obj = obraRepository.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado! ID: " + id));
	}

	public List<Obra> findAll() {
		return obraRepository.findAll();
	}

}
