package br.ps.escola.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="PROFESSOR")
public class Professor extends EntidadeBase {
	
	private static final long serialVersionUID = -468415961974232767L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_PROFESSOR", columnDefinition="TINYINT(3)")
	private int id;
	
	@NotBlank
	@Column(name="NOME", length=100)
	private String nome;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="DISCIPLINAS_PROFESSOR", joinColumns=@JoinColumn(name="ID_PROFESSOR"), inverseJoinColumns=@JoinColumn(name="ID_DISCIPLINA"))
	private List<Disciplina> disciplinas;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
}
