package br.ps.escola.dao;

import br.ps.escola.model.Diario;
import br.ps.escola.repository.DiarioRepository;

public class DiarioDao extends DAO<Diario> implements DiarioRepository {

	private static final long serialVersionUID = 5947069741833145257L;

	@Override
	public boolean isExclusaoPermitida(int id) {
		return false;
	}
}
