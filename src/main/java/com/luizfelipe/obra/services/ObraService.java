package com.luizfelipe.obra.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luizfelipe.obra.domain.Cliente;
import com.luizfelipe.obra.domain.Obra;
import com.luizfelipe.obra.domain.dtos.ObraDTO;
import com.luizfelipe.obra.repository.ObraRepository;
import com.luizfelipe.obra.services.exceptions.ObjetoNaoEncontradoException;

@Service
public class ObraService {
	
	@Autowired
	private ObraRepository obraRepository;
	@Autowired
	private ClienteService clienteService;
	
	public Obra findById(Long id) {
		Optional<Obra> obj = obraRepository.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado! ID: " + id));
	}

	public List<Obra> findAll() {
		return obraRepository.findAll();
	}

	public Obra create(@Valid ObraDTO objDTO) {
		return obraRepository.save(newObra(objDTO));
	}
	

	public Obra update(Long id, @Valid ObraDTO objDTO) {
		objDTO.setId(id);
		Obra oldObj = findById(id);
		oldObj = newObra(objDTO);
		return obraRepository.save(oldObj);
	}
	
	private Obra newObra(ObraDTO obj) {
		Cliente cliente = clienteService.findById(obj.getIdCliente());
		
		Obra obra = new Obra();
		if (obj.getId() != null) {
			obra.setId(obj.getId());
		}
		
		obra.setCliente(cliente);
		obra.setObservacoes(obj.getObservacoes());
		obra.setDataCadastro(obj.getDataCadastro());
		obra.setDescricao(obj.getDescricao());
		
		return obra;
	}

}
