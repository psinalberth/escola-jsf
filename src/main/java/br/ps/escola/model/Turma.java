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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="TURMA")
public class Turma extends EntidadeBase {
	
	private static final long serialVersionUID = -2909547309587670829L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_TURMA", columnDefinition="TINYINT(3)")
	private int id;
	
	@NotBlank
	@Column(name="CODIGO", length=5)
	private String codigo;
	
	@Min(value=1900)
	@NotNull
	@Column(name="ANO", columnDefinition="SMALLINT(4)")
	private Integer ano;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="DISCIPLINAS_TURMA", joinColumns=@JoinColumn(name="ID_TURMA"), inverseJoinColumns=@JoinColumn(name="ID_DISCIPLINA"))
	private List<Disciplina> disciplinas;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="ALUNOS_TURMA", joinColumns=@JoinColumn(name="ID_TURMA"), inverseJoinColumns=@JoinColumn(name="ID_ALUNO"))
	private List<Aluno> alunos;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public Integer getAno() {
		return ano;
	}
	
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public List<Aluno> getAlunos() {
		return alunos;
	}
	
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
}