package com.luizfelipe.obra.domain;

import java.time.LocalDate;

public class Cliente extends Pessoa {

	public Cliente() {
		super();
	}

	public Cliente(Long id, String nome, LocalDate dataCadastro) {
		super(id, nome, dataCadastro);
	}
	
}
