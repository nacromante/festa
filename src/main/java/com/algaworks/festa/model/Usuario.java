package com.algaworks.festa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	@Column(name="id")
	private Long id;
	
	@Column(name="login",nullable=false)
	private String login;
	
	@Column(name="senha",nullable=false)
	@NotBlank(message="Senha é obrigatória")
	private String senha;
	
	@Column(name="autorizacao",nullable=false)
	private String autorizacao;
	
	@Transient
	private String senhaRepita;
	
	
	public boolean senhaConfere() {
		return this.senha.equals(senhaRepita);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getAutorizacao() {
		return autorizacao;
	}

	public void setAutorizacao(String autorizacao) {
		this.autorizacao = autorizacao;
	}

	public String getSenhaRepita() {
		return senhaRepita;
	}

	public void setSenhaRepita(String senhaRepita) {
		this.senhaRepita = senhaRepita;
	}
	
	

}
