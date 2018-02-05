package br.ps.escola.bean;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import br.ps.escola.model.Disciplina;
import br.ps.escola.repository.DisciplinaRepository;

@Named
@ViewScoped
public class FormDisciplinaBean implements Serializable {

	private static final long serialVersionUID = 4347988279553509394L;
	
	@Inject
	private DisciplinaRepository repository;
	
	private Disciplina disciplina;
	private Integer id;
	
	public void init() {
		
		if (id != null) {
			disciplina = repository.buscar(id);
			
		} else {
			disciplina = new Disciplina();
		}
	}
	
	public String salvar() {
		
		repository.salvar(disciplina);
		return "lista-disciplinas?faces-redirect=true";
	}
	
	public String remover() {
		
		repository.remover(disciplina.getId());
		return "lista-disciplinas?faces-redirect=true";
	}
	
	public boolean isExclusaoPermitida() {
		return repository.isExclusaoPermitida(disciplina.getId());
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Disciplina getDisciplina() {
		return disciplina;
	}
	
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
}