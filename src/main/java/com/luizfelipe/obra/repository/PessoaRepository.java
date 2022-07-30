package com.luizfelipe.obra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.luizfelipe.obra.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
