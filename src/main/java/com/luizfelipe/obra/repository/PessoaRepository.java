package com.luizfelipe.obra.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.luizfelipe.obra.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	
	Optional<Pessoa> findByCpf(String cpf);

	Optional<Pessoa> findByLogin(String login);
	
}
