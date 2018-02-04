package br.ps.escola.bean;

import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import com.github.javafaker.Faker;

import br.ps.escola.model.Professor;
import br.ps.escola.repository.ProfessorRepository;

import java.io.Serializable;
import java.util.Locale;

@Named
@ViewScoped
public class FormProfessorBean implements Serializable {

	private static final long serialVersionUID = 6298221118025324166L;
	
	@Inject
	private ProfessorRepository repository;
	
	private Professor professor;
	private Integer id;
	
	public void init() {
		
		if (id != null) {
			professor = repository.buscar(id);
			
		} else {
			
			Faker faker = new Faker(Locale.getDefault());
			
			professor = new Professor();
			professor.setNome(faker.name().fullName());
		}
	}
	
	public void salvar() {
		repository.salvar(professor);
	}
	
	public void remover() {
		repository.remover(professor.getId());
	}
	
	public boolean isExclusaoPermitida() {
		return repository.isExclusaoPermitida(professor.getId());
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Professor getProfessor() {
		return professor;
	}
	
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
}
