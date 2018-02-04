package br.ps.escola.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.ps.escola.model.Professor;
import br.ps.escola.repository.ProfessorRepository;

@Named
@RequestScoped
public class ProfessorBean {
	
	@Inject
	private ProfessorRepository repository;
	
	private Professor professor;
	private List<Professor> professores;
	
	@PostConstruct
	public void init() {
		this.professores = repository.listarTodos();
	}
	
	public void novo() {	
		professor = new Professor();
	}
	
	public void salvar() {
		
		repository.salvar(professor);
		novo();
	}
	
	public void filtrar() {
		
	}
	
	public void remover() {
		repository.remover(professor);
	}
	
	public List<Professor> getProfessores() {
		return professores;
	}
	
	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}
	
	public Professor getProfessor() {
		return professor;
	}
	
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
}
