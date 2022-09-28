package com.luizfelipe.obra.repository.custom;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luizfelipe.obra.domain.Movimento;
import com.luizfelipe.obra.domain.dtos.ConsultaHomeObraDTO;
import com.luizfelipe.obra.domain.dtos.ConsultaHomeObraItemDTO;

@Repository
@Transactional(readOnly = true)
public class MovimentoRepositoryImpl implements MovimentoRepositoryCustom {
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Movimento> findByIdObra(Long idObra) {
		StringBuilder sb = new StringBuilder()
			.append(" select movimento from Movimento movimento ")
			.append(" inner join fetch movimento.obra obra ")
			.append(" where obra.idObra = :idObra ");
		
		TypedQuery<Movimento> typedQuery = entityManager.createQuery(sb.toString(), Movimento.class);
		
		typedQuery.setParameter("idObra", idObra);
		
		return typedQuery.getResultList();
	}

	@Override
	public List<ConsultaHomeObraDTO> findMovimentosHome(LocalDate date) {
		StringBuilder sb = new StringBuilder()
			.append(" SELECT ")
			.append(" O.ID_OBRA AS IDOBRA,")
			.append(" CONCAT(CONCAT(O.ID_OBRA , ' - '), O.DESCRICAO) AS OBRA ")
			.append(" FROM MOVIMENTO M ")
			.append(" INNER JOIN OBRA O ON O.ID_OBRA = M.ID_OBRA ")
			.append(" WHERE M.DATA_LANCAMENTO = :dataAtual ")
			.append(" GROUP BY O.ID_OBRA ");
		
		
		Query query = entityManager.createNativeQuery(sb.toString());		
		query.setParameter("dataAtual", date);
		
		List<ConsultaHomeObraDTO> lista = query.getResultList();
		
		return lista;
	}

	@Override
	public List<ConsultaHomeObraItemDTO> findMovimentosHomeItems(Long idObra) {
		StringBuilder sb = new StringBuilder()
			.append(" SELECT ")
			.append(" M.ID_OBRA AS IDOBRA, ")
			.append(" CONCAT(CONCAT(P.ID_PRODUTO, ' - '), P.DESCRICAO) AS PRODUTO, ")
			.append(" SUM(M.QUANTIDADE) AS QUANTIDADE ")
			.append(" FROM MOVIMENTO M ")
			.append(" INNER JOIN OBRA O ON O.ID_OBRA = M.ID_OBRA ")
			.append(" INNER JOIN PRODUTO P ON P.ID_PRODUTO = M.ID_PRODUTO ") 
			.append(" WHERE O.ID_OBRA = :idObra")
			.append(" GROUP BY M.ID_OBRA, M.ID_PRODUTO ");
		
		Query query = entityManager.createNativeQuery(sb.toString());		
		query.setParameter("idObra", idObra);
		
		List<ConsultaHomeObraItemDTO> listaItem = query.getResultList();
		
		return listaItem;
	}

}
