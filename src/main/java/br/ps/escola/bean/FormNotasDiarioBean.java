package br.ps.escola.bean;

import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import br.ps.escola.model.Aluno;
import br.ps.escola.model.Diario;
import br.ps.escola.model.NotaDiario;
import br.ps.escola.repository.AlunosRepository;
import br.ps.escola.repository.DiarioRepository;
import br.ps.escola.repository.NotasRepository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class FormNotasDiarioBean implements Serializable {
	
	private static final long serialVersionUID = -4477439660293588675L;
	
	@Inject
	private DiarioRepository diarioRepository;
	
	@Inject
	private AlunosRepository alunosRepository;
	
	@Inject
	private NotasRepository repository;
	
	private Integer id;
	private Integer diarioId;
	private NotaDiario notaDiario;
	private Diario diario;
	
	public void init() {
		
		diario = diarioRepository.buscar(diarioId);
		
		if (id != null) {
			notaDiario = repository.buscar(id);
			
		} else {
			
			notaDiario = new NotaDiario();
			notaDiario.setDiario(diario);
		}
	}
	
	public void salvar() {
		
		if (notaDiario != null && notaDiario.getId() == 0) {
		   
			if (diario.getNotasDiario() == null) {
				diario.setNotasDiario(new ArrayList<NotaDiario>());
				
			}
			
			diario.getNotasDiario().add(notaDiario);
			diarioRepository.salvar(diario);
			
		} else {
			diarioRepository.salvar(notaDiario.getDiario());
		}
	}
	
	public void remover() {
		
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getDiarioId() {
		return diarioId;
	}
	
	public void setDiarioId(Integer diarioId) {
		this.diarioId = diarioId;
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