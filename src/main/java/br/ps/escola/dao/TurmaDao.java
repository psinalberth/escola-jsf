package br.ps.escola.dao;

import br.ps.escola.model.Turma;
import br.ps.escola.repository.TurmasRepository;

public class TurmaDao extends DAO<Turma> implements TurmasRepository {

	private static final long serialVersionUID = -7275275148287406051L;

	@Override
	public boolean isExclusaoPermitida(int id) {
		return false;
	}
}
