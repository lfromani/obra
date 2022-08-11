package com.luizfelipe.obra.domain;

import java.time.LocalDate;
import java.util.stream.Collectors;

import javax.persistence.Entity;

import com.luizfelipe.obra.domain.dtos.UsuarioDTO;
import com.luizfelipe.obra.domain.enuns.Perfil;

@Entity(name = "USUARIO")
public class Usuario extends Pessoa {

	private static final long serialVersionUID = 1L;

	public Usuario() {
		super();
		addPerfil(Perfil.ADMIN);
	}

	public Usuario(Long idPessoa, String nome, LocalDate dataCadastro, String cpf) {
		super(idPessoa, nome, dataCadastro, cpf);
		addPerfil(Perfil.ADMIN);
	}
	
	public Usuario(UsuarioDTO dto) {
		super();
		this.idPessoa = dto.getIdUsuario();
		this.nome = dto.getNome();
		this.dataCadastro = dto.getDataCadastro();
		this.perfis = dto.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.cpf = dto.getCpf();
	}
	
}
