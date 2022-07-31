package com.luizfelipe.obra.domain;

import java.time.LocalDate;
import java.util.stream.Collectors;

import javax.persistence.Entity;

import com.luizfelipe.obra.domain.dtos.ClienteDTO;
import com.luizfelipe.obra.domain.enuns.Perfil;

@Entity(name = "CLIENTE")
public class Cliente extends Pessoa {

	private static final long serialVersionUID = 1L;

	public Cliente() {
		super();
		addPerfil(Perfil.CLIENTE);
	}

	public Cliente(Long id, String nome, LocalDate dataCadastro, String cpf) {
		super(id, nome, dataCadastro, cpf);
		addPerfil(Perfil.CLIENTE);
	}
	
	public Cliente(ClienteDTO dto) {
		super();
		this.id = dto.getId();
		this.nome = dto.getNome();
		this.dataCadastro = dto.getDataCadastro();
		this.perfis = dto.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.cpf = dto.getCpf();
	}
	
	
}
