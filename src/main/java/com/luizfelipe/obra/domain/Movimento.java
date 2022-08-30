package com.luizfelipe.obra.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "movimento")
public class Movimento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMovimento;

	@JoinColumn(name = "idObra")
	@ManyToOne(fetch = FetchType.EAGER)
	private Obra obra;

	@JoinColumn(name = "idProduto")
	@ManyToOne(fetch = FetchType.EAGER)
	private Produto produto;

	@Column
	private BigDecimal quantidade;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataLancamento = LocalDate.now();

	public Movimento() {
		super();
	}

	public Movimento(Long idMovimento, Obra obra, Produto produto, BigDecimal quantidade, LocalDate dataLancamento) {
		super();
		this.idMovimento = idMovimento;
		this.obra = obra;
		this.produto = produto;
		this.quantidade = quantidade;
		this.dataLancamento = dataLancamento;
	}

	public Long getIdMovimento() {
		return idMovimento;
	}

	public void setIdMovimento(Long idMovimento) {
		this.idMovimento = idMovimento;
	}

	public Obra getObra() {
		return obra;
	}

	public void setObra(Obra obra) {
		this.obra = obra;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

}
