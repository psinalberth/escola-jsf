package br.ps.escola.dao;

import br.ps.escola.model.Aluno;
import br.ps.escola.repository.AlunosRepository;

public class AlunoDao extends DAO<Aluno> implements AlunosRepository {

	private static final long serialVersionUID = 8978954285907527789L;

	@Override
	public boolean isExclusaoPermitida(int id) {
		return false;
	}
}
