package com.luizfelipe.obra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.luizfelipe.obra.domain.Movimento;
import com.luizfelipe.obra.repository.custom.MovimentoRepositoryCustom;

public interface MovimentoRepository extends JpaRepository<Movimento, Long>, MovimentoRepositoryCustom {

}
