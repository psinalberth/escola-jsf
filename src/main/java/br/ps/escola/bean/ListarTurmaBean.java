package br.ps.escola.bean;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import br.ps.escola.model.Turma;
import br.ps.escola.repository.TurmasRepository;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ListarTurmaBean implements Serializable {

	private static final long serialVersionUID = 3164414381028556028L;
	
	@Inject
	private TurmasRepository repository;
	
	private List<Turma> turmas;
	private List<Turma> turmasSelecionadas;
	
	@PostConstruct
	public void init() {
		this.turmas = repository.listarTodos();
	}
	
	public void removerTurmas() {
		
		if (turmasSelecionadas != null) {
			turmasSelecionadas.forEach(turma -> repository.remover(turma.getId()));
		}
	}
	
	public List<Turma> getTurmas() {
		return turmas;
	}
	
	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
	
	public List<Turma> getTurmasSelecionadas() {
		return turmasSelecionadas;
	}
	
	public void setTurmasSelecionadas(List<Turma> turmasSelecionadas) {
		this.turmasSelecionadas = turmasSelecionadas;
	}
}
