package com.luizfelipe.obra.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Obra {
	
	private Long id;
	
	private String descricao;
	
	private LocalDate dataCadastro = LocalDate.now();
	
	private Cliente cliente;
	
	private Set<Produto> produtos = new HashSet<>();
	
	private String observacoes;
	
	public Obra(Long id, String descricao, LocalDate dataCadastro, Cliente cliente, Set<Produto> produtos, String observacoes) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.dataCadastro = dataCadastro;
		this.cliente = cliente;
		this.produtos = produtos;
		this.observacoes = observacoes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Set<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
}
