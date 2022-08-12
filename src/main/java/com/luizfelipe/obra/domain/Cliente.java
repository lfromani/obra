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

	public Cliente(Long idPessoa, String nome, LocalDate dataCadastro, String cpf, String login, String senha) {
		super(idPessoa, nome, dataCadastro, cpf, login, senha);
		addPerfil(Perfil.CLIENTE);
	}
	
	public Cliente(ClienteDTO dto) {
		super();
		this.idPessoa = dto.getIdCliente();
		this.nome = dto.getNome();
		this.dataCadastro = dto.getDataCadastro();
		this.perfis = dto.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.cpf = dto.getCpf();
	}
	
}
