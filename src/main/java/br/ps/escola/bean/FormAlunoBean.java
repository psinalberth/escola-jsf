package br.ps.escola.bean;

import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import com.github.javafaker.Faker;

import br.ps.escola.model.Aluno;
import br.ps.escola.repository.AlunosRepository;

import java.io.Serializable;
import java.util.Locale;

@Named
@ViewScoped
public class FormAlunoBean implements Serializable {

	private static final long serialVersionUID = -3626952503953147883L;
	
	@Inject
	private AlunosRepository repository;
	
	private Integer id;
	private Aluno aluno;
	
	public void init() {
		
		if (id != null) {
			aluno = repository.buscar(id);
			
		} else {
			
			Faker faker = new Faker(Locale.getDefault());
			
			aluno = new Aluno();
			aluno.setNome(faker.name().fullName());
		}
	}
	
	public void salvar() {
		repository.salvar(aluno);
	}
	
	public void remover() {
		repository.remover(aluno.getId());
	}
	
	public boolean isExclusaoPermitida() {
		return repository.isExclusaoPermitida(aluno.getId());
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Aluno getAluno() {
		return aluno;
	}
	
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
}
