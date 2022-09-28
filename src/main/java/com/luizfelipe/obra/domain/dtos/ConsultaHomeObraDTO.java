package com.luizfelipe.obra.domain.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ConsultaHomeObraDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idObra;

	private String obra;

	private List<ConsultaHomeObraItemDTO> itens = new ArrayList<ConsultaHomeObraItemDTO>();

	public Long getIdObra() {
		return idObra;
	}

	public void setIdObra(Long idObra) {
		this.idObra = idObra;
	}

	public String getObra() {
		return obra;
	}

	public void setObra(String obra) {
		this.obra = obra;
	}

	public List<ConsultaHomeObraItemDTO> getItens() {
		return itens;
	}

	public void setItens(List<ConsultaHomeObraItemDTO> itens) {
		this.itens = itens;
	}

}
