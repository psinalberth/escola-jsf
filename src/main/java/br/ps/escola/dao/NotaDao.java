package br.ps.escola.dao;

import br.ps.escola.model.NotaDiario;
import br.ps.escola.repository.NotasRepository;

public class NotaDao extends DAO<NotaDiario> implements NotasRepository {

	private static final long serialVersionUID = -6512310680783312029L;

	@Override
	public boolean isExclusaoPermitida(int id) {
		return false;
	}
}
