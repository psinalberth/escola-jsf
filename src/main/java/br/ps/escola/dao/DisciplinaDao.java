package br.ps.escola.dao;

import java.math.BigInteger;

import br.ps.escola.model.Disciplina;
import br.ps.escola.repository.DisciplinaRepository;

public class DisciplinaDao extends DAO<Disciplina> implements DisciplinaRepository {

	private static final long serialVersionUID = -120330375315511970L;

	@Override
	public boolean isExclusaoPermitida(int id) {
		
		BigInteger rowCount = (BigInteger) getEntityManager().createNativeQuery("select count(*) from DISCIPLINAS_PROFESSOR where ID_DISCIPLINA = :id")
		.setParameter("id", id).getSingleResult();
		
		return rowCount.intValue() == 0;
	}
}
