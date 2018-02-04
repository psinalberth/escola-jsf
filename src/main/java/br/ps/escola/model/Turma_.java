package br.ps.escola.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-02-03T19:00:44.481-0300")
@StaticMetamodel(Turma.class)
public class Turma_ {
	public static volatile SingularAttribute<Turma, Integer> id;
	public static volatile SingularAttribute<Turma, String> codigo;
	public static volatile SingularAttribute<Turma, Integer> ano;
	public static volatile ListAttribute<Turma, Disciplina> disciplinas;
	public static volatile ListAttribute<Turma, Aluno> alunos;
}
