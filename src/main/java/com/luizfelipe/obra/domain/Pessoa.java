package com.luizfelipe.obra.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.luizfelipe.obra.domain.enuns.Perfil;

public abstract class Pessoa {
	
	protected Long id;
	
	protected String nome;
	
	protected Set<Long> perfis = new HashSet<>();
	
	protected LocalDate dataCadastro = LocalDate.now();

	public Pessoa() {
		super();
		addPerfil(Perfil.CLIENTE);
	}

	public Pessoa(Long id, String nome, LocalDate dataCadastro) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataCadastro = dataCadastro;
		addPerfil(Perfil.CLIENTE);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfil(Perfil perfil) {
		this.perfis.add(perfil.getCodigo());
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

}
