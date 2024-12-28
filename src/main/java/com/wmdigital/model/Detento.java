package com.wmdigital.model;

import java.util.ArrayList;
import java.util.List;

public class Detento {
	public String nome;
	public String pontuario;
	public String estabelecimento;
	public  List<Violacao> ListaViolacoes = new ArrayList<>();
	
	public Detento(String nome, String pontuario, String estabelecimento, List<Violacao> listaViolacoes) {
		super();
		this.nome = nome;
		this.pontuario = pontuario;
		this.estabelecimento = estabelecimento;
		ListaViolacoes = listaViolacoes;
		}

	public Detento() {
		super();
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPontuario() {
		return pontuario;
	}

	public void setPontuario(String pontuario) {
		this.pontuario = pontuario;
	}

	public String getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(String estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public List<Violacao> getListaViolacoes() {
		return ListaViolacoes;
	}

	public void setListaViolacoes(List<Violacao> listaViolacoes) {
		ListaViolacoes = listaViolacoes;
	}
	
	  public void AdicionarViolacao(Violacao v)
	  
	    {
	        ListaViolacoes.add(v);
	       
	    }
	  
	  public void ExcluirViolacao(Violacao violacao) 
	  
	  	{
		  ListaViolacoes.remove(violacao);
	  	}
	  
	  
	  public void AdicionarListaInteira(List<Violacao> lista) {
		  
		  for (Violacao violacao : lista) {
			  
			  ListaViolacoes.add(violacao);
			
		}
		 
	  }

	@Override
	public String toString() {
		return "Detento [nome=" + nome + "]";
	}
	  
	  
}
