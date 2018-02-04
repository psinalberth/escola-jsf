package br.ps.escola.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;

@MappedSuperclass
public abstract class EntidadeBase implements Serializable {
	
	private static final long serialVersionUID = -2259281972330637518L;
	
	@NotBlank
	@Column(name="USUARIO_ALTERACAO", length=15)
	private String usuarioAlteracao;
	
	@Past
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	@Column(name="DATA_CRIACAO")
	private Date dataCriacao;
	
	@Past
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	@Column(name="DATA_ALTERACAO")
	private Date dataAlteracao;
	
	@Version
	@NotNull
	@Column(name="VERSAO", columnDefinition="TINYINT(3)")
	private int versao;
	
	public String getUsuarioAlteracao() {
		return usuarioAlteracao;
	}

	public void setUsuarioAlteracao(String usuarioAlteracao) {
		this.usuarioAlteracao = usuarioAlteracao;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public int getVersao() {
		return versao;
	}

	public void setVersao(int versao) {
		this.versao = versao;
	}

	@PrePersist
	public void prePersist() {
		
		this.dataCriacao = new Date();
		this.dataAlteracao = this.dataCriacao;
		
		if (this.usuarioAlteracao == null) {
			this.usuarioAlteracao = "user";
		}
	}
	
	@PreUpdate
	public void preUpdate() {
		this.dataAlteracao = new Date();
	}
}