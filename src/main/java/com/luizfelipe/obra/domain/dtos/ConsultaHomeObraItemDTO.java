package com.luizfelipe.obra.domain.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

public class ConsultaHomeObraItemDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private BigInteger idObra;

	private String produto;

	private BigDecimal quantidade;

	public BigInteger getIdObra() {
		return idObra;
	}

	public void setIdObra(BigInteger idObra) {
		this.idObra = idObra;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

}
