package br.ps.escola.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="AULA")
public class Aula extends EntidadeBase {
	
	private static final long serialVersionUID = -5635453544985200827L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_AULA", columnDefinition="TINYINT(3)")
	private int id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_PROFESSOR")
	private Professor professor;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_DISCIPLINA")
	private Disciplina disciplina;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_TURMA")
	private Turma turma;
	
	public int getId() {
		return id;
	}
	
	public Professor getProfessor() {
		return professor;
	}
	
	public Disciplina getDisciplina() {
		return disciplina;
	}
	
	public Turma getTurma() {
		return turma;
	}
}