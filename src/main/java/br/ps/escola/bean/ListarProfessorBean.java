package br.ps.escola.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import br.ps.escola.model.Professor;
import br.ps.escola.repository.ProfessorRepository;

@Named
@ViewScoped
public class ListarProfessorBean implements Serializable {

	private static final long serialVersionUID = 7505665071825098316L;
	
	@Inject
	private ProfessorRepository repository;
	
	private List<Professor> professores;
	private List<Professor> professoresSelecionados;
	
	@PostConstruct
	public void init() {
		this.professores = repository.listarTodos();
	}
	
	public void removerProfessores() {
		
		if (professoresSelecionados != null) {
			
			professoresSelecionados.forEach(professor -> repository.remover(professor.getId()));
			init();
		}
	}
	
	public List<Professor> getProfessores() {
		return professores;
	}
	
	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}
	
	public List<Professor> getProfessoresSelecionados() {
		return professoresSelecionados;
	}
	
	public void setProfessoresSelecionados(List<Professor> professoresSelecionados) {
		this.professoresSelecionados = professoresSelecionados;
	}
}