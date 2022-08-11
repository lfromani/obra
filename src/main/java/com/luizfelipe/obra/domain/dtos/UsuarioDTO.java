package com.luizfelipe.obra.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.luizfelipe.obra.domain.Usuario;
import com.luizfelipe.obra.domain.enuns.Perfil;

public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idUsuario;

	@NotNull(message = "o campo nome é requirido.")
	private String nome;

	private Set<Long> perfis = new HashSet<>();

	@NotNull(message = "o campo CPF é requirido.")
	private String cpf;

	@NotNull(message = "o campo CPF é requirido.")
	private String login;

	@NotNull(message = "o campo CPF é requirido.")
	private String senha;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataCadastro = LocalDate.now();

	public UsuarioDTO() {
		super();
		addPerfis(Perfil.ADMIN);
	}

	public UsuarioDTO(Usuario obj) {
		super();
		this.idUsuario = obj.getIdPessoa();
		this.nome = obj.getNome();
		this.dataCadastro = obj.getDataCadastro();
		this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.cpf = obj.getCpf();
		addPerfis(Perfil.ADMIN);
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfis(Perfil perfil) {
		this.perfis.add(perfil.getCodigo());
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
