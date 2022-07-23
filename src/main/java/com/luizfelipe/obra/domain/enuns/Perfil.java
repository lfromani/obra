package com.luizfelipe.obra.domain.enuns;

public enum Perfil {
	
	ADMIN(0L, "ROLE_ADMIN"),
	CLIENTE(1L, "ROLE_CLIENTE"),
	FORNECEDOR(2L, "ROLE_FORNECEDOR");

	private Long codigo;
	private String descricao;
	
	public static Perfil toEnum(Long codigo) {
		if (codigo == null) {
			return null;
		}
		
		for (Perfil p : Perfil.values()) {
			if (codigo.equals(p.getCodigo())) {
				return p;
			}
		}
		
		throw new IllegalArgumentException("Perfil inválido.");
	}
	
	private Perfil(Long codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
