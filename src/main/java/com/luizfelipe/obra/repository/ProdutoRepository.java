package com.luizfelipe.obra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.luizfelipe.obra.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
