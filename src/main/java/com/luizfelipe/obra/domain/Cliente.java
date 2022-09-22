package com.luizfelipe.obra.domain;

import java.time.LocalDate;
import javax.persistence.Entity;
import com.luizfelipe.obra.domain.dtos.ClienteDTO;
import com.luizfelipe.obra.domain.enuns.Perfil;

@Entity
public class Cliente extends Pessoa {

	private static final long serialVersionUID = 1L;

	public Cliente() {
		super();
		addPerfil(Perfil.CLIENTE);
	}

	public Cliente(Long idPessoa, String nome, LocalDate dataCadastro, String cpf, String login, String senha, 
			String endereco, String telefone, String email, LocalDate dataNascimento) {
		
		super(idPessoa, nome, dataCadastro, cpf, login, senha, endereco, telefone, email, dataNascimento);
		addPerfil(Perfil.CLIENTE);
	}
	
	public Cliente(ClienteDTO dto) {
		super();
		this.idPessoa = dto.getIdCliente();
		this.nome = dto.getNome();
		this.dataCadastro = dto.getDataCadastro();
		this.cpf = dto.getCpf();
		this.endereco = dto.getEndereco();
		this.telefone = dto.getTelefone();
		this.email = dto.getEmail();
		this.dataNascimento = dto.getDataNascimento();
	}
	
}
