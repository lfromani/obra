package com.luizfelipe.obra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.luizfelipe.obra.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
