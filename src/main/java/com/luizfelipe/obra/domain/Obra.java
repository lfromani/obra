package com.luizfelipe.obra.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.luizfelipe.obra.domain.enuns.Status;

@Entity
@Table(name = "OBRA")
public class Obra implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "OBRA_GENERATOR", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "OBRA_GENERATOR", sequenceName = "sequence_obra", initialValue = 1, allocationSize = 1)
	private Long idObra;
	
	@Column
	private String descricao;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataCadastro = LocalDate.now();
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataEncerramento;
	
	@JoinColumn(name = "idCliente")
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;
	
	private Status status;
	
	@Column
	private String observacoes;
	
	public Obra() {
		super();
	}
	
	public Obra(Long idObra, String descricao, LocalDate dataCadastro, Cliente cliente, Status status, String observacoes) {
		super();
		this.idObra = idObra;
		this.descricao = descricao;
		this.dataCadastro = dataCadastro;
		this.cliente = cliente;
		this.status = status;
		this.observacoes = observacoes;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDate getDataEncerramento() {
		return dataEncerramento;
	}

	public void setDataEncerramento(LocalDate dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}
	
}
