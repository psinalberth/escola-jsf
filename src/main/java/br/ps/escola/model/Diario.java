package br.ps.escola.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="DIARIO")
public class Diario extends EntidadeBase {
	
	private static final long serialVersionUID = -7194021572865391925L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_DIARIO", columnDefinition="SMALLINT(5)")
	private int id;
	
	@NotNull
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_PROFESSOR", nullable=false, columnDefinition="TINYINT(3)")
	private Professor professor;
	
	@NotNull
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_DISCIPLINA", nullable=false, columnDefinition="TINYINT(3)")
	private Disciplina disciplina;
	
	@NotNull
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_TURMA", nullable=false, columnDefinition="TINYINT(3)")
	private Turma turma;
	
	@Valid
	@OneToMany(fetch=FetchType.LAZY, orphanRemoval=true, mappedBy="diario")
	private List<NotaDiario> notasDiario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public List<NotaDiario> getNotasDiario() {
		return notasDiario;
	}

	public void setNotasDiario(List<NotaDiario> notasDiario) {
		this.notasDiario = notasDiario;
	}
}