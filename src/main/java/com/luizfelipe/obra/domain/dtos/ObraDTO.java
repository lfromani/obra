package com.luizfelipe.obra.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.luizfelipe.obra.domain.Obra;

public class ObraDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idObra;

	private String descricao;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataCadastro = LocalDate.now();

	@NotNull(message = "O campo OBSERVAÇÕES é obrigatório.")
	private String observacoes;

	@NotNull(message = "O campo STATUS é obrigatório.")
	private Long status;

	@NotNull(message = "O campo CLIENTE é obrigatório.")
	private Long idCliente;

	private String nomeCliente;

	public ObraDTO() {
		super();
	}

	public ObraDTO(Obra obj) {
		super();
		this.idObra = obj.getIdObra();
		this.descricao = obj.getDescricao();
		this.dataCadastro = obj.getDataCadastro();
		this.observacoes = obj.getObservacoes();
		this.idCliente = obj.getCliente().getIdPessoa();
		this.nomeCliente = obj.getCliente().getNome();
		this.status = obj.getStatus().getCodigo();
	}

	public Long getIdObra() {
		return idObra;
	}

	public void setIdObra(Long idObra) {
		this.idObra = idObra;
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

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

}
