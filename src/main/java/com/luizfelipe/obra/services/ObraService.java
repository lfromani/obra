package com.luizfelipe.obra.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luizfelipe.obra.domain.Cliente;
import com.luizfelipe.obra.domain.Obra;
import com.luizfelipe.obra.domain.dtos.ObraDTO;
import com.luizfelipe.obra.domain.enuns.Status;
import com.luizfelipe.obra.repository.ObraRepository;
import com.luizfelipe.obra.services.exceptions.ObjetoNaoEncontradoException;

@Service
public class ObraService {
	
	private static final Long STATUS_ABERTO = 0L;
	private static final Long STATUS_EM_ANDAMENTO = 1L;
	private static final Long STATUS_ENCERRADO = 2L;
	
	@Autowired
	private ObraRepository obraRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	public Obra findById(Long id) {
		Optional<Obra> obj = obraRepository.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Obra não encontrado! ID: " + id));
	}

	public List<Obra> findAll() {
		return obraRepository.findAll();
	}

	public Obra create(@Valid ObraDTO objDTO) {
		return obraRepository.save(newObra(objDTO));
	}

	public Obra update(Long id, @Valid ObraDTO objDTO) {
		objDTO.setIdObra(id);
		Obra oldObj = findById(id);
		oldObj = newObra(objDTO);
		return obraRepository.save(oldObj);
	}
	
	private Obra newObra(ObraDTO obj) {
		Cliente cliente = clienteService.findById(obj.getIdCliente());
		
		Obra obra = new Obra();
		if (obj.getIdObra() != null)
			obra.setIdObra(null);
		
		if (obj.getStatus().equals(STATUS_ENCERRADO))
			obra.setDataEncerramento(LocalDate.now());
		
		if (obj.getStatus().equals(null))
			obra.setStatus(Status.ABERTO);
		
		obra.setCliente(cliente);
		obra.setObservacoes(obj.getObservacoes());
		obra.setDataCadastro(obj.getDataCadastro());
		obra.setDescricao(obj.getDescricao());
		
		return obra;
	}

}
