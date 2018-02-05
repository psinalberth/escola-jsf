package br.ps.escola.bean;

import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import br.ps.escola.model.Aluno;
import br.ps.escola.model.Diario;
import br.ps.escola.model.Disciplina;
import br.ps.escola.model.Professor;
import br.ps.escola.model.Turma;
import br.ps.escola.repository.AlunosRepository;
import br.ps.escola.repository.DiarioRepository;
import br.ps.escola.repository.DisciplinaRepository;
import br.ps.escola.repository.ProfessorRepository;
import br.ps.escola.repository.TurmasRepository;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class FormDiarioBean implements Serializable {
	
	private static final long serialVersionUID = 2201520827294603635L;
	
	@Inject
	private DiarioRepository repository;
	
	@Inject
	private ProfessorRepository professorRepository;
	
	@Inject
	private DisciplinaRepository disciplinaRepository;
	
	@Inject
	private TurmasRepository turmasRepository;
	
	@Inject
	private AlunosRepository alunosRepository;
	
	private Integer id;
	private Diario diario;
	
	public void init() {
		
		if (id != null) {
			
			diario = repository.buscar(id);
			
		} else {
			diario = new Diario();
		}
	}
	
	public void salvar() {
		repository.salvar(diario);
	}
	
	public void remover() {
		repository.remover(diario.getId());
	}
	
	public boolean isExclusaoPermitida() {
		return repository.isExclusaoPermitida(diario.getId());
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Diario getDiario() {
		return diario;
	}
	
	public void setDiario(Diario diario) {
		this.diario = diario;
	}
	
	public List<Professor> getProfessores() {
		return professorRepository.listarTodos();
	}
	
	public List<Disciplina> getDisciplinas() {
		return disciplinaRepository.listarTodos();
	}
	
	public List<Turma> getTurmas() {
		return turmasRepository.listarTodos();
	}
	
	public List<Aluno> getAlunos() {
		return alunosRepository.listarTodos();
	}
}