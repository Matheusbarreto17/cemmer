package com.wmdigital.model;

import java.io.Serializable;

public class Registro implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nome;
	
	private String prontuario;
	
	private String estabelecimento;
	
	private String perfil; 
	
	private String dataivl;  
	
	private String datavl;
	
	private String datafvl;
	
	private String duracaovl;
	
	private String descricaonot;
	
	private String vara;
	
	private String emailvara;
	
	private String tipovl;
	
	private String processo;
	
	private String processovp;
	
	private String idvl;
	
	private String idnot;
	
	private String duracaoalm;
	
	private String pje;
	
	private String usarionot;
	
	private String descricaojust;
	
	public Registro() {
		
	}

	public Registro(String nome, String prontuario, String estabelecimento, String perfil, String dataivl,
			String datavl, String datafvl, String duracaovl, String descricaonot, String vara, String emailvara,
			String tipovl, String processo, String processovp, String idvl, String idnot, String duracaoalm, String pje,
			String usarionot, String descricaojust) {
		super();
		this.nome = nome;
		this.prontuario = prontuario;
		this.estabelecimento = estabelecimento;
		this.perfil = perfil;
		this.dataivl = dataivl;
		this.datavl = datavl;
		this.datafvl = datafvl;
		this.duracaovl = duracaovl;
		this.descricaonot = descricaonot;
		this.vara = vara;
		this.emailvara = emailvara;
		this.tipovl = tipovl;
		this.processo = processo;
		this.processovp = processovp;
		this.idvl = idvl;
		this.idnot = idnot;
		this.duracaoalm = duracaoalm;
		this.pje = pje;
		this.usarionot = usarionot;
		this.descricaojust = descricaojust;
	}

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getProntuario() {
		return prontuario;
	}


	public void setProntuario(String prontuario) {
		this.prontuario = prontuario;
	}


	public String getEstabelecimento() {
		return estabelecimento;
	}


	public void setEstabelecimento(String estabelecimento) {
		this.estabelecimento = estabelecimento;
	}


	public String getPerfil() {
		return perfil;
	}


	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}


	public String getDataivl() {
		return dataivl;
	}


	public void setDataivl(String dataivl) {
		this.dataivl = dataivl;
	}


	public String getDatavl() {
		return datavl;
	}


	public void setDatavl(String datavl) {
		this.datavl = datavl;
	}


	public String getDatafvl() {
		return datafvl;
	}


	public void setDatafvl(String datafvl) {
		this.datafvl = datafvl;
	}


	public String getDuracaovl() {
		return duracaovl;
	}


	public void setDuracaovl(String duracaovl) {
		this.duracaovl = duracaovl;
	}


	public String getDescricaonot() {
		return descricaonot;
	}


	public void setDescricaonot(String descricaonot) {
		this.descricaonot = descricaonot;
	}


	public String getVara() {
		return vara;
	}


	public void setVara(String vara) {
		this.vara = vara;
	}


	public String getEmailvara() {
		return emailvara;
	}


	public void setEmailvara(String emailvara) {
		this.emailvara = emailvara;
	}


	public String getTipovl() {
		return tipovl;
	}


	public void setTipovl(String tipovl) {
		this.tipovl = tipovl;
	}


	public String getProcesso() {
		return processo;
	}


	public void setProcesso(String processo) {
		this.processo = processo;
	}


	public String getProcessovp() {
		return processovp;
	}


	public void setProcessovp(String processovp) {
		this.processovp = processovp;
	}


	public String getIdvl() {
		return idvl;
	}


	public void setIdvl(String idvl) {
		this.idvl = idvl;
	}


	public String getIdnot() {
		return idnot;
	}


	public void setIdnot(String idnot) {
		this.idnot = idnot;
	}


	public String getDuracaoalm() {
		return duracaoalm;
	}


	public void setDuracaoalm(String duracaoalm) {
		this.duracaoalm = duracaoalm;
	}


	public String getPje() {
		return pje;
	}


	public void setPje(String pje) {
		this.pje = pje;
	}


	public String getUsarionot() {
		return usarionot;
	}


	public void setUsarionot(String usarionot) {
		this.usarionot = usarionot;
	}


	public String getDescricaojust() {
		return descricaojust;
	}


	public void setDescricaojust(String descricaojust) {
		this.descricaojust = descricaojust;
	}


	@Override
	public String toString() {
		return "Nome:" + nome;
	}
	
}
