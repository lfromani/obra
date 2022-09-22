package com.luizfelipe.obra.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.luizfelipe.obra.domain.dtos.UnidadeMedidaDTO;

@Entity
@Table(name = "UNIDADEMEDIDA")
public class UnidadeMedida implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "UNIDADEMEDIDA_GENERATOR", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "UNIDADEMEDIDA_GENERATOR", sequenceName = "sequence_unidade_medida", initialValue = 1, allocationSize = 1)
	private Long idUnidadeMedida;

	@Column
	private String descricao;

	@Column
	private String sigla;
	
	public UnidadeMedida() {
		super();
	}

	public UnidadeMedida(UnidadeMedidaDTO dto) {
		super();
		this.idUnidadeMedida = dto.getIdUnidadeMedida();
		this.descricao = dto.getDescricao();
		this.sigla = dto.getSigla();
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
