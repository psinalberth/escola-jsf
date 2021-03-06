package br.ps.escola.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.ps.escola.model.Aluno;
import br.ps.escola.repository.AlunosRepository;

@FacesConverter("alunoConverter")
public class AlunoConverter implements Converter {
	
	@Inject
	private AlunosRepository repository;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		if (value == null || value.trim().length() == 0)
			return null;
		
		return repository.buscar(Integer.parseInt(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if (value == null)
			return null;
		
		Aluno aluno = (Aluno) value;
		
		return String.valueOf(aluno.getId());
	}
}