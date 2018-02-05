package br.ps.escola.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.ps.escola.model.Professor;
import br.ps.escola.model.Professor_;
import br.ps.escola.repository.ProfessorRepository;

public class ProfessorDao extends DAO<Professor> implements ProfessorRepository {

	private static final long serialVersionUID = 5439492853740464017L;

	@Override
	public boolean isExclusaoPermitida(int id) {
		return false;
	}

	@Override
	public Professor byNome(String nome) {
		
		if (nome == null || nome.trim().length() == 0)
			return null;
		
		CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Professor> criteriaQuery = builder.createQuery(Professor.class);
		Root<Professor> root = criteriaQuery.from(Professor.class);
		criteriaQuery.where(builder.equal(root.get(Professor_.nome), nome));
		
		return getEntityManager().createQuery(criteriaQuery).getSingleResult();
	}
}
