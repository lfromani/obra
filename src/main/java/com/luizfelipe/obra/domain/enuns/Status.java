package com.luizfelipe.obra.domain.enuns;

public enum Status {

	ABERTO(0L, "ABERTO"), ANDAMENTO(1L, "EM ANDAMENTO"), ENCERRADO(2L, "ENCERRADO");

	private Long codigo;
	private String descricao;

	private Status(Long codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static Status toEnum(Long cod) {
		if (cod == null) {
			return null;
		}

		for (Status x : Status.values()) {
			if (cod.equals(x.getCodigo())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Status inválido");
	}

}
