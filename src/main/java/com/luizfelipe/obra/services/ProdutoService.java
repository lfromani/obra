package com.luizfelipe.obra.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luizfelipe.obra.domain.Produto;
import com.luizfelipe.obra.domain.UnidadeMedida;
import com.luizfelipe.obra.domain.dtos.ProdutoDTO;
import com.luizfelipe.obra.repository.ProdutoRepository;
import com.luizfelipe.obra.services.exceptions.ObjetoNaoEncontradoException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private UnidadeMedidaService unidadeMedidaService;
	

	public Produto findById(Long id) {
		Optional<Produto> obj = produtoRepository.findById(id);
		
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Produto não encontrado! ID: " + id));
	}

	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}

	public Produto create(ProdutoDTO objDTO) {
		objDTO.setIdProduto(null);
		objDTO.setDataCadastro(LocalDate.now());
		
		Produto newObj = new Produto(objDTO);
		
		newObj.setUnidadeMedida(unidadeMedidaService.findById(objDTO.getIdUnidadeMedida()));
		
		return produtoRepository.save(newObj);
	}

	public Produto update(Long id, @Valid ProdutoDTO objDTO) {
		objDTO.setIdProduto(id);
		Produto oldObj = findById(id);
		
		UnidadeMedida unidadeMedida = oldObj.getUnidadeMedida();
		
		oldObj = new Produto(objDTO);
		oldObj.setUnidadeMedida(unidadeMedida);
		
		return produtoRepository.save(oldObj);
	}

	public void delete(Long id) {
		Produto obj = findById(id);
		if (Objects.nonNull(obj))
			produtoRepository.deleteById(id);
	}

	public void atualizarQuantidade(Long produto, BigDecimal quantidade) {
		Produto p = findById(produto);
		
		//System.out.println("Saldo atual: " + p.getQuantidade().toString());
		//System.out.println("Quantidade: " + quantidade.toString());
		
		p.setQuantidade(p.getQuantidade().subtract(quantidade));
		
		//System.out.println("Saldo novo: " + p.getQuantidade().toString());
		
		produtoRepository.save(p);
	}

}
