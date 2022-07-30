package com.luizfelipe.obra.domain;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity(name = "CLIENTE")
public class Cliente extends Pessoa {

	private static final long serialVersionUID = 1L;

	public Cliente() {
		super();
	}

	public Cliente(Long id, String nome, LocalDate dataCadastro) {
		super(id, nome, dataCadastro);
	}
	
}
