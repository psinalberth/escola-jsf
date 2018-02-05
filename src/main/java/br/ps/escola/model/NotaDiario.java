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
@Table(name="NOTA_DIARIO")
public class NotaDiario extends EntidadeBase {
	
	private static final long serialVersionUID = 4056740315791994022L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_NOTA_DIARIO")
	private int id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_DIARIO", nullable=false)
	private Diario diario;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_ALUNO", nullable=false)
	private Aluno aluno;
	
	@Column(name="NOTA1")
	private Double nota1;
	
	@Column(name="NOTA2")
	private Double nota2;
	
	@Column(name="NOTA3")
	private Double nota3;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Diario getDiario() {
		return diario;
	}

	public void setDiario(Diario diario) {
		this.diario = diario;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Double getNota1() {
		return nota1;
	}

	public void setNota1(Double nota1) {
		this.nota1 = nota1;
	}

	public Double getNota2() {
		return nota2;
	}

	public void setNota2(Double nota2) {
		this.nota2 = nota2;
	}

	public Double getNota3() {
		return nota3;
	}

	public void setNota3(Double nota3) {
		this.nota3 = nota3;
	}
}
