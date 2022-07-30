package com.luizfelipe.obra;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.luizfelipe.obra.domain.Cliente;
import com.luizfelipe.obra.domain.Obra;
import com.luizfelipe.obra.domain.Produto;
import com.luizfelipe.obra.repository.ClienteRepository;
import com.luizfelipe.obra.repository.ObraRepository;
import com.luizfelipe.obra.repository.ProdutoRepository;

@SpringBootApplication
public class ObraApplication implements CommandLineRunner {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ObraRepository obraRepository;

	public static void main(String[] args) {
		SpringApplication.run(ObraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Produto produto1 = new Produto(null, "PARAFUSO", new BigDecimal(109.56), LocalDate.now());
		Produto produto2 = new Produto(null, "TURBINA", new BigDecimal(5000.00), LocalDate.now());
		Produto produto3 = new Produto(null, "GARRAFA", new BigDecimal(5.12), LocalDate.now());
		
		Set<Produto> listaProdutos = new HashSet<>();
		listaProdutos.add(produto1);
		listaProdutos.add(produto2);
		listaProdutos.add(produto3);
		
		Cliente cliente = new Cliente(null, "LUIZ FELIPE ROMANI", LocalDate.now());
		
		Obra obra = new Obra();
		obra.setDescricao("OBRA 1 TESTE");
		obra.setDataCadastro(LocalDate.now());
		obra.setObservacoes("TESTE OBSERVACOES");
		obra.setCliente(cliente);
		obra.setProdutos(listaProdutos);
		
		clienteRepository.saveAll(Arrays.asList(cliente));
		produtoRepository.saveAll(Arrays.asList(produto1));
		produtoRepository.saveAll(Arrays.asList(produto2));
		produtoRepository.saveAll(Arrays.asList(produto3));
		
		obraRepository.saveAll(Arrays.asList(obra));
		
	}

}
