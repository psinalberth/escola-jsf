package br.ps.escola.repository;

import java.io.Serializable;
import java.util.List;

public interface DAORepository<T> extends Serializable {
	
	public void salvar(T entidade);
	
	public List<T> listarTodos();
	
	public T buscar(int id);
	
	public void remover(T entidade);
	
	public void remover(int id);
}
