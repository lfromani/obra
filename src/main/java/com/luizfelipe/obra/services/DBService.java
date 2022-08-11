package com.luizfelipe.obra.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.luizfelipe.obra.domain.Cliente;
import com.luizfelipe.obra.domain.Obra;
import com.luizfelipe.obra.domain.Produto;
import com.luizfelipe.obra.repository.ClienteRepository;
import com.luizfelipe.obra.repository.ObraRepository;
import com.luizfelipe.obra.repository.ProdutoRepository;

@Service
public class DBService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ObraRepository obraRepository;
	
	public void instanciaDB() {
		Produto produto1 = new Produto(null, "PARAFUSO", new BigDecimal(109.56), LocalDate.now(), new BigDecimal(500.50));
		Produto produto2 = new Produto(null, "TURBINA", new BigDecimal(5000.00), LocalDate.now(), new BigDecimal(125.99));
		Produto produto3 = new Produto(null, "GARRAFA", new BigDecimal(5.12), LocalDate.now(), new BigDecimal(1953.99));
		
		Set<Produto> listaProdutos = new HashSet<>();
		listaProdutos.add(produto1);
		listaProdutos.add(produto2);
		listaProdutos.add(produto3);
		
		Cliente cliente = new Cliente(null, "LUIZ FELIPE ROMANI", LocalDate.now(), "076.269.269-35");
		
		Obra obra = new Obra();
		obra.setDescricao("OBRA 1 TESTE");
		obra.setDataCadastro(LocalDate.now());
		obra.setObservacoes("TESTE OBSERVACOES");
		obra.setCliente(cliente);
		
		clienteRepository.saveAll(Arrays.asList(cliente));
		produtoRepository.saveAll(Arrays.asList(produto1));
		produtoRepository.saveAll(Arrays.asList(produto2));
		produtoRepository.saveAll(Arrays.asList(produto3));
		
		obraRepository.saveAll(Arrays.asList(obra));
	}

}
