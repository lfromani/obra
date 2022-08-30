package com.luizfelipe.obra.repository.custom;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.luizfelipe.obra.domain.Movimento;

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

}
