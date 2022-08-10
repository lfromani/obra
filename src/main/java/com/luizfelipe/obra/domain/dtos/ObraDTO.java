package com.luizfelipe.obra.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.luizfelipe.obra.domain.Obra;

public class ObraDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String descricao;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataCadastro = LocalDate.now();

	private String observacoes;

	private Long idCliente;

	private String nomeCliente;

	public ObraDTO() {
		super();
	}

	public ObraDTO(Obra obj) {
		super();
		this.id = obj.getId();
		this.descricao = obj.getDescricao();
		this.dataCadastro = obj.getDataCadastro();
		this.observacoes = obj.getObservacoes();
		this.idCliente = obj.getCliente().getId();
		this.nomeCliente = obj.getCliente().getNome();
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

}
