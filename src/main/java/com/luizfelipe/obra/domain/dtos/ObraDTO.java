package com.luizfelipe.obra.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.luizfelipe.obra.domain.Obra;

public class ObraDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idObra;

	private String descricao;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataCadastro = LocalDate.now();

	@NotNull(message = "O campo OBSERVAÇÕES é requirido")
	private String observacoes;

	@NotNull(message = "O campo CLIENTE é requirido")
	private Long idCliente;

	private String nomeCliente;

	private Set<ProdutoDTO> produtos = new HashSet<>();

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

	public Set<ProdutoDTO> getProdutos() {
		return produtos;
	}

	public void setProdutos(Set<ProdutoDTO> produtos) {
		this.produtos = produtos;
	}

}
