package br.ps.escola.bean;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import br.ps.escola.model.Aluno;
import br.ps.escola.repository.AlunosRepository;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ListarAlunoBean implements Serializable {

	private static final long serialVersionUID = -9054804436005343835L;
	
	@Inject
	private AlunosRepository repository;
	
	private List<Aluno> alunos;
	private List<Aluno> alunosSelecionados;
	
	@PostConstruct
	public void init() {
		this.alunos = repository.listarTodos();
	}
	
	public void removerAlunos() {
		
		if (alunosSelecionados != null) {
			alunosSelecionados.forEach(aluno -> repository.remover(aluno.getId()));
		}
	}
	
	public List<Aluno> getAlunos() {
		return alunos;
	}
	
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	public List<Aluno> getAlunosSelecionados() {
		return alunosSelecionados;
	}
	
	public void setAlunosSelecionados(List<Aluno> alunosSelecionados) {
		this.alunosSelecionados = alunosSelecionados;
	}
}
