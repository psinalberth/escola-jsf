package br.ps.escola.bean;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import br.ps.escola.model.Diario;
import br.ps.escola.repository.DiarioRepository;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ListarDiarioBean implements Serializable {

	private static final long serialVersionUID = -3754936800457487913L;
	
	@Inject
	private DiarioRepository repository;
	
	private List<Diario> diarios;
	private List<Diario> diariosSelecionados;
	
	@PostConstruct
	public void init() {
		this.diarios = repository.listarTodos();
	}
	
	public void removerDiarios() {
		
		if (diariosSelecionados != null) {
			diariosSelecionados.forEach(diario -> repository.remover(diario.getId()));
		}
	}
	
	public List<Diario> getDiarios() {
		return diarios;
	}
	
	public void setDiarios(List<Diario> diarios) {
		this.diarios = diarios;
	}
	
	public List<Diario> getDiariosSelecionados() {
		return diariosSelecionados;
	}
	
	public void setDiariosSelecionados(List<Diario> diariosSelecionados) {
		this.diariosSelecionados = diariosSelecionados;
	}
}