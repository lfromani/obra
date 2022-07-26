package com.luizfelipe.obra.services;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luizfelipe.obra.domain.Movimento;
import com.luizfelipe.obra.domain.dtos.MovimentoDTO;
import com.luizfelipe.obra.repository.MovimentoRepository;

@Service
public class MovimentoService {

	@Autowired
	private MovimentoRepository repository;
	
	@Autowired
	private ObraService obraService;
	
	@Autowired
	private ProdutoService produtoService;
	
	public List<Movimento> findByIdObra(Long idObra) {
		return repository.findByIdObra(idObra);
	}

	public Movimento create(@Valid MovimentoDTO objDTO) {
		Movimento movimento = new Movimento();	
		movimento.setQuantidade(objDTO.getQuantidade());
		movimento.setObra(obraService.findById(objDTO.getObra()));
		movimento.setProduto(produtoService.findById(objDTO.getProduto()));
		movimento.setDataLancamento(LocalDate.now());		
		
		return repository.save(movimento);
	}

}
