package com.luizfelipe.obra.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.luizfelipe.obra.domain.Cliente;
import com.luizfelipe.obra.domain.enuns.Perfil;

public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idCliente;

	@NotNull(message = "O campo Nome é obrigatório.")
	private String nome;

	//private Set<Long> perfis = new HashSet<>();

	private String cpf;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataCadastro = LocalDate.now();

	public ClienteDTO() {
		super();
		//addPerfis(Perfil.CLIENTE);
	}

	public ClienteDTO(Cliente obj) {
		super();
		this.idCliente = obj.getIdPessoa();
		this.nome = obj.getNome();
		this.dataCadastro = obj.getDataCadastro();
		//this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.cpf = obj.getCpf();
		//addPerfis(Perfil.CLIENTE);
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
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

	/*public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfis(Perfil perfil) {
		this.perfis.add(perfil.getCodigo());
	}*/

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
