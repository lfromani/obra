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

@Entity
@Table(name = "MOVIMENTO")
public class Movimento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "MOVIMENTO_GENERATOR", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "MOVIMENTO_GENERATOR", sequenceName = "sequence_movimento", initialValue = 1, allocationSize = 1)
	private Long idMovimento;

	@JoinColumn(name = "idObra")
	@ManyToOne(fetch = FetchType.EAGER)
	private Obra obra;

	@JoinColumn(name = "idProduto")
	@ManyToOne(fetch = FetchType.EAGER)
	private Produto produto;

	@Column
	private BigDecimal quantidade;

	@Column
	private BigDecimal preco;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataLancamento = LocalDate.now();

	public Movimento() {
		super();
	}

	public Movimento(Long idMovimento, Obra obra, Produto produto, BigDecimal quantidade, LocalDate dataLancamento, BigDecimal preco) {
		super();
		this.idMovimento = idMovimento;
		this.obra = obra;
		this.produto = produto;
		this.quantidade = quantidade;
		this.dataLancamento = dataLancamento;
		this.preco = preco;
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

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

}
