package com.algaworks.festa.model;

public enum StatusStep {
	
	COMPLETO("completo"), INCOMPLETO("incompleto"), AUSENTE("ausente");
	private String nome;
	private StatusStep(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	

}
