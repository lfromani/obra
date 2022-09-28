package com.luizfelipe.obra.domain.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

public class ConsultaHomeObraItemDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idObra;

	private String produto;

	private BigDecimal quantidade;

	public Long getIdObra() {
		return idObra;
	}

	public void setIdObra(Long idObra) {
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
