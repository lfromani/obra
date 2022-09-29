package com.luizfelipe.obra.repository.custom;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

import com.luizfelipe.obra.domain.Movimento;
import com.luizfelipe.obra.domain.dtos.ConsultaHomeObraDTO;
import com.luizfelipe.obra.domain.dtos.ConsultaHomeObraItemDTO;

public interface MovimentoRepositoryCustom {
	
	List<Movimento> findByIdObra(Long idObra);
	
	List<ConsultaHomeObraDTO> findMovimentosHome(LocalDate date);
	
	List<ConsultaHomeObraItemDTO> findMovimentosHomeItems(BigInteger idObra);
	
}
