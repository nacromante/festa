package com.algaworks.festa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Festa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	@Column(name="id")
	private Long id;
	
	@Column(name="descricao",length=50, nullable=false)
	@Size(max=50, message="Descrição pode ter no máximo 50 caracteres")
	@NotBlank(message="Descrição é obrigatória")
	private String descricao;
	
	@ManyToOne
	private TipoFesta tipo;
	
	@Column(name="numConvidados")
	@Size(min=0, message="Número de convidados precisa ser maior que 0")
	private Integer numConvidados;
	
	@ManyToOne
	private Endereco endereco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoFesta getTipo() {
		return tipo;
	}

	public void setTipo(TipoFesta tipo) {
		this.tipo = tipo;
	}

	public Integer getNumConvidados() {
		return numConvidados;
	}

	public void setNumConvidados(Integer numConvidados) {
		this.numConvidados = numConvidados;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	
	

}
