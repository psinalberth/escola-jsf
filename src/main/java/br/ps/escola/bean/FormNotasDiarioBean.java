package br.ps.escola.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import br.ps.escola.model.Aluno;
import br.ps.escola.model.Diario;
import br.ps.escola.model.NotaDiario;
import br.ps.escola.repository.AlunosRepository;
import br.ps.escola.repository.DiarioRepository;

@Named
@ViewScoped
public class FormNotasDiarioBean implements Serializable {

	private static final long serialVersionUID = -4477439660293588675L;
	
	@Inject
	private DiarioRepository repository;
	
	@Inject
	private AlunosRepository alunosRepository;
	
	private Integer id;
	private Diario diario;
	private NotaDiario notaDiario;
	
	public void init() {
		
		if (id != null) {
			diario = repository.buscar(id);
		}
	}
	
	public String adicionarNota() {
		
		if (diario.getNotasDiario() == null) {
			diario.setNotasDiario(new ArrayList<NotaDiario>());
		}
		
		NotaDiario notaDiario = new NotaDiario();
		notaDiario.setDiario(diario);
		notaDiario.setEditavel(true);
		diario.getNotasDiario().add(notaDiario);
		
		return null;
	}
	
	public void salvar() {
		repository.salvar(diario);
	}
	
	public void remover() {
		repository.remover(diario.getId());
	}
	
	public String editar(NotaDiario notaDiario) {
		
		notaDiario.setEditavel(true);
		return null;
	}
	
	public String finalizarEdicao(NotaDiario notaDiario) {
		
		notaDiario.setEditavel(false);
		repository.salvar(diario);
		
		return null;
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
	
	public NotaDiario getNotaDiario() {
		return notaDiario;
	}
	
	public void setNotaDiario(NotaDiario notaDiario) {
		this.notaDiario = notaDiario;
	}
	
	public List<Aluno> getAlunos() {
		return alunosRepository.listarTodos();
	}
}