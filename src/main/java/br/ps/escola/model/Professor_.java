package br.ps.escola.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-02-03T19:00:44.479-0300")
@StaticMetamodel(Professor.class)
public class Professor_ extends EntidadeBase_ {
	public static volatile SingularAttribute<Professor, Integer> id;
	public static volatile SingularAttribute<Professor, String> nome;
	public static volatile ListAttribute<Professor, Disciplina> disciplinas;
}
