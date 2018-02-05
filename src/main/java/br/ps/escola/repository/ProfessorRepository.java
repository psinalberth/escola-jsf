package br.ps.escola.repository;

import br.ps.escola.model.Professor;

public interface ProfessorRepository extends DAORepository<Professor> {
	
	public Professor byNome(String nome);
}
