package br.ps.escola.bean;

import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import br.ps.escola.model.Turma;
import br.ps.escola.repository.TurmasRepository;

import java.io.Serializable;

@Named
@ViewScoped
public class FormTurmaBean implements Serializable {

	private static final long serialVersionUID = -734590801962990531L;
	
	@Inject
	private TurmasRepository repository;
	
	private Integer id;
	private Turma turma;
	
	public void init() {
		
		if (id != null) {
			turma = repository.buscar(id);
			
		} else {
			turma = new Turma();
		}
	}
	
	public void salvar() {
		repository.salvar(turma);
	}
	
	public void remover() {
		repository.remover(turma.getId());
	}
	
	public boolean isExclusaoPermitida() {
		return repository.isExclusaoPermitida(turma.getId());
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Turma getTurma() {
		return turma;
	}
	
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
}