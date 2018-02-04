package br.ps.escola.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import br.ps.escola.model.EntidadeBase;
import br.ps.escola.repository.DAORepository;

public class DAO<T extends EntidadeBase> implements DAORepository<T> {
	
	private static final long serialVersionUID = 5771962610483591766L;
	
	@Inject
	EntityManager entityManager;
	
	@Override
	public void salvar(T entidade) {
		entityManager.merge(entidade);
	}

	@Override
	public List<T> listarTodos() {
		
		Class<T> tipoClasse = recuperarTipo();
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = builder.createQuery(tipoClasse);
		criteriaQuery.select(criteriaQuery.from(tipoClasse));
		
		return entityManager.createQuery(criteriaQuery).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	private Class<T> recuperarTipo() {
		
		Class<?> classe = this.getClass();
		
		while (!classe.getSuperclass().equals(DAO.class)) {
			classe = classe.getSuperclass();
		}
		
		ParameterizedType tipoClasse = (ParameterizedType) classe.getGenericSuperclass();
		
		return (Class<T>) tipoClasse.getActualTypeArguments()[0];
	}

	@Override
	public T buscar(int id) {
		return entityManager.find(null, id);
	}

	@Override
	public void remover(T entidade) {
		entityManager.remove(entidade);
	}

	@Override
	public void remover(int id) {
		entityManager.remove(buscar(id));
	}
}
