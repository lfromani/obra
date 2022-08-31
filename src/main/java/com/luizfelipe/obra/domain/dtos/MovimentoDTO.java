package com.luizfelipe.obra.domain.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MovimentoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idMovimento;

	private Long obra;

	private Long produto;

	private BigDecimal quantidade;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataLancamento = LocalDate.now();

	public MovimentoDTO() {
		super();
	}

	public Long getIdMovimento() {
		return idMovimento;
	}

	public void setIdMovimento(Long idMovimento) {
		this.idMovimento = idMovimento;
	}

	public Long getObra() {
		return obra;
	}

	public void setObra(Long obra) {
		this.obra = obra;
	}

	public Long getProduto() {
		return produto;
	}

	public void setProduto(Long produto) {
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
