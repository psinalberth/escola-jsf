package br.ps.escola.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import br.ps.escola.model.Disciplina;
import br.ps.escola.repository.DisciplinaRepository;

@Named
@ViewScoped
public class ListarDisciplinaBean implements Serializable {
	
	private static final long serialVersionUID = 5013856121542528024L;

	@Inject
	private DisciplinaRepository repository;
	
	private List<Disciplina> disciplinas;
	private List<Disciplina> disciplinasSelecionadas;
	
	@PostConstruct
	public void init() {
		this.disciplinas = repository.listarTodos();
	}
	
	public void removerDisciplinas() {
		
		if (disciplinasSelecionadas != null) {
			disciplinasSelecionadas.forEach(disciplina -> repository.remover(disciplina.getId()));
		}
	}
	
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public List<Disciplina> getDisciplinasSelecionadas() {
		return disciplinasSelecionadas;
	}
	
	public void setDisciplinasSelecionadas(List<Disciplina> disciplinasSelecionadas) {
		this.disciplinasSelecionadas = disciplinasSelecionadas;
	}
}