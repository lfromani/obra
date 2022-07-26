package com.luizfelipe.obra.domain.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.luizfelipe.obra.domain.Produto;
import com.luizfelipe.obra.domain.UnidadeMedida;

public class ProdutoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idProduto;

	@NotNull(message = "O campo Descrição é obrigatório.")
	private String descricao;

	private BigDecimal quantidade;

	private BigDecimal preco;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataCadastro = LocalDate.now();

	private Long idUnidadeMedida;

	private String unidadeMedida;

	public ProdutoDTO() {
		super();
	}

	public ProdutoDTO(Produto obj) {
		super();
		this.idProduto = obj.getIdProduto();
		this.descricao = obj.getDescricao();
		this.dataCadastro = obj.getDataCadastro();
		this.quantidade = obj.getQuantidade();
		this.preco = obj.getPreco();
		this.idUnidadeMedida = obj.getUnidadeMedida() != null ? obj.getUnidadeMedida().getIdUnidadeMedida() : null;
		this.unidadeMedida = obj.getUnidadeMedida() != null ? getUnidadeMedidaFormatado(obj.getUnidadeMedida()) : null;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Long getIdUnidadeMedida() {
		return idUnidadeMedida;
	}

	public void setIdUnidadeMedida(Long idUnidadeMedida) {
		this.idUnidadeMedida = idUnidadeMedida;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}
	
	private String getUnidadeMedidaFormatado(UnidadeMedida unidadeMedida) {
		return unidadeMedida.getDescricao() + " - (" + unidadeMedida.getSigla() + ")";		
	}

}
