package com.algaworks.festa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Endereco implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	@Column(name="id")
	private Long id;
	
	@Column(name="cep",length=9, nullable=false)
	@NotBlank(message="CEP é obrigatório")
	private String cep;
	
	@Column(name="rua", nullable=false)
	@NotBlank(message="Rua é obrigatória")
	private String rua;
	
	@Column(name="numero", nullable=false)
	@NotBlank(message="Número é obrigatório")
	private String numero;
	
	@Column(name="bairro", nullable=false)
	private String bairro;
	
	@Column(name="complemento", nullable=false)
	private String complemento;

	@Column(name="cidade", nullable=false)
	private String cidade;
	
	@Column(name="Estado", nullable=false)
	private String estado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return rua;
	}

	public void setLogradouro(String logradouro) {
		this.rua = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	
	

}
