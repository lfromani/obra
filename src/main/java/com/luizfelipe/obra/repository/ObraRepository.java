package com.luizfelipe.obra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.luizfelipe.obra.domain.Obra;

public interface ObraRepository extends JpaRepository<Obra, Long> {

}
