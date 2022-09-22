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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.luizfelipe.obra.domain.dtos.ProdutoDTO;

@Entity
@Table(name = "PRODUTO")
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "PRODUTO_GENERATOR", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "PRODUTO_GENERATOR", sequenceName = "sequence_produto", initialValue = 1, allocationSize = 1)
	private Long idProduto;

	@Column
	private String descricao;

	@Column
	private BigDecimal quantidade;

	@Column
	private BigDecimal preco;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataCadastro = LocalDate.now();

	@JoinColumn(name = "idUnidadeMedida")
	@ManyToOne(fetch = FetchType.EAGER)
	private UnidadeMedida unidadeMedida;

	public Produto() {
		super();
	}

	public Produto(Long idProduto, String descricao, BigDecimal quantidade, LocalDate dataCadastro, BigDecimal preco) {
		super();
		this.idProduto = idProduto;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.dataCadastro = dataCadastro;
		this.preco = preco;
	}

	public Produto(ProdutoDTO dto) {
		super();
		this.idProduto = dto.getIdProduto();
		this.descricao = dto.getDescricao();
		this.quantidade = dto.getQuantidade();
		this.dataCadastro = dto.getDataCadastro();
		this.preco = dto.getPreco();
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

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

}
