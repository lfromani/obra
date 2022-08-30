package com.luizfelipe.obra.repository.custom;

import java.util.List;
import com.luizfelipe.obra.domain.Movimento;

public interface MovimentoRepositoryCustom {
	
	List<Movimento> findByIdObra(Long idObra);
	
}
