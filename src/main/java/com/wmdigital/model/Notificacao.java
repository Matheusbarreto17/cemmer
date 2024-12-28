package com.wmdigital.model;

public class Notificacao {
	public String descricao;
	public String id;
	public Notificacao() {
		super();
	}
	public Notificacao(String descricao, String id) {
		super();
		this.descricao = descricao;
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
