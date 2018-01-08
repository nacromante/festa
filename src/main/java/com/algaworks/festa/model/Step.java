package com.algaworks.festa.model;

public class Step {
	
	private int passo;
	private String desc;
	private StatusStep status;
	
	
	public Step(int passo, String desc, StatusStep status) {
		super();
		this.passo = passo;
		this.desc = desc;
		this.status = status;
	}
	public int getPasso() {
		return passo;
	}
	public void setPasso(int passo) {
		this.passo = passo;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public StatusStep getStatus() {
		return status;
	}
	public void setStatus(StatusStep status) {
		this.status = status;
	}
	
	

}
