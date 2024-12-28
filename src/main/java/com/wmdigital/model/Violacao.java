package com.wmdigital.model;

public class Violacao {
	
	public String datainicio;
	public String datadaviolacao;
	public String datafinal;
	public String duracao;
	public String id;
	public String tipo;
	public String descricao;

	public Violacao() {
		super();
	}

	public Violacao(String datainicio, String datadaviolacao, String datafinal, String duracao, String id, String tipo, String descricao) {
		super();
		this.datainicio = datainicio;
		this.datadaviolacao = datadaviolacao;
		this.datafinal = datafinal;
		this.duracao = duracao;
		this.id = id;
		this.tipo = tipo;
		this.descricao = descricao;
	}

	public String getDatainicio() {
		return datainicio;
	}

	public void setDatainicio(String datainicio) {
		this.datainicio = datainicio;
	}

	public String getDatadaviolacao() {
		return datadaviolacao;
	}

	public void setDatadaviolacao(String datadaviolacao) {
		this.datadaviolacao = datadaviolacao;
	}

	public String getDatafinal() {
		return datafinal;
	}

	public void setDatafinal(String datafinal) {
		this.datafinal = datafinal;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
