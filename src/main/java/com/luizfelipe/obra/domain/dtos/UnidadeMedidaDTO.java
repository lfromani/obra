package com.luizfelipe.obra.domain.dtos;

import java.io.Serializable;
import com.luizfelipe.obra.domain.UnidadeMedida;

public class UnidadeMedidaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idUnidadeMedida;

	private String descricao;

	private String sigla;

	public UnidadeMedidaDTO() {
		super();
	}

	public UnidadeMedidaDTO(UnidadeMedida unidadeMedida) {
		super();
		this.idUnidadeMedida = unidadeMedida.getIdUnidadeMedida();
		this.descricao = unidadeMedida.getDescricao();
		this.sigla = unidadeMedida.getSigla();
	}

	public Long getIdUnidadeMedida() {
		return idUnidadeMedida;
	}

	public void setIdUnidadeMedida(Long idUnidadeMedida) {
		this.idUnidadeMedida = idUnidadeMedida;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

}
