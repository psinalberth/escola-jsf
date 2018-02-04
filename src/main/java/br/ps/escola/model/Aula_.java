package br.ps.escola.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-02-03T19:00:44.476-0300")
@StaticMetamodel(Aula.class)
public class Aula_ extends EntidadeBase_ {
	public static volatile SingularAttribute<Aula, Integer> id;
	public static volatile SingularAttribute<Aula, Professor> professor;
	public static volatile SingularAttribute<Aula, Disciplina> disciplina;
	public static volatile SingularAttribute<Aula, Turma> turma;
}
