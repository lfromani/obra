package com.luizfelipe.obra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luizfelipe.obra.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
