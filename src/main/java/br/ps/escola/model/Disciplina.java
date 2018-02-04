package br.ps.escola.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="DISCIPLINA")
public class Disciplina extends EntidadeBase {

	private static final long serialVersionUID = -1320346384845791486L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_DISCIPLINA", columnDefinition="TINYINT(3)")
	private int id;
	
	@NotBlank
	@Column(name="DESCRICAO", length=100)
	private String descricao;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
