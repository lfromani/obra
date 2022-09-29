package com.luizfelipe.obra.services;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luizfelipe.obra.domain.Movimento;
import com.luizfelipe.obra.domain.dtos.ConsultaHomeObraDTO;
import com.luizfelipe.obra.domain.dtos.ConsultaHomeObraItemDTO;
import com.luizfelipe.obra.domain.dtos.MovimentoDTO;
import com.luizfelipe.obra.domain.enuns.Status;
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
		if (objDTO.getQuantidade() != null)
			produtoService.atualizarQuantidade(objDTO.getProduto(), objDTO.getQuantidade());
		
		if (objDTO.getObra() != null)
			obraService.alterarStatus(objDTO.getObra(), Status.ANDAMENTO);
		
		Movimento movimento = new Movimento();	
		movimento.setQuantidade(objDTO.getQuantidade());
		movimento.setObra(obraService.findById(objDTO.getObra()));
		movimento.setProduto(produtoService.findById(objDTO.getProduto()));
		movimento.setDataLancamento(LocalDate.now());		
		
		return repository.save(movimento);
	}

	public List<ConsultaHomeObraDTO> findMovimentosHome() {
		List<ConsultaHomeObraDTO> lista = repository.findMovimentosHome(LocalDate.now());
		
		for (ConsultaHomeObraDTO consultaHomeObraDTO : lista) {
			List<ConsultaHomeObraItemDTO> itens = repository.findMovimentosHomeItems(consultaHomeObraDTO.getIdObra());
			consultaHomeObraDTO.setItens(itens);
		}
		
		return lista;
	}

}
