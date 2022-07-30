package com.luizfelipe.obra.domain;

import java.time.LocalDate;

public class Produto {

	private Long id;
	
	private String descricao;
	
	private String quantidade;
	
	private LocalDate dataCadastro = LocalDate.now();

	public Produto() {
		super();
	}
	
	public Produto(Long id, String descricao, String quantidade, LocalDate dataCadastro) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.dataCadastro = dataCadastro;
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

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
}
