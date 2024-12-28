package com.wmdigital.gerencia;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.*;

import com.wmdigital.model.Detento;
import com.wmdigital.model.Registro;
import com.wmdigital.model.Violacao;

public class GerenciarDetento {

	private List<Registro> registros;

	public GerenciarDetento() {
		super();
	}

	public List<Registro> getRegistros() {
		return registros;
	}

	public void setRegistros(List<Registro> registros) {
		this.registros = registros;
	}
	
	public List<Detento> CriarDetentos(List<Registro> listagem) {
		
		List<Detento> detentos = new ArrayList<Detento>();
		
		for (Registro registro : listagem) {
			Detento detento = new Detento ();
			detento.setNome(registro.getNome());
			detento.setPontuario(registro.getProntuario());
			detento.setEstabelecimento(registro.getEstabelecimento());
			
			Violacao violacao = new Violacao();
			violacao.setDatadaviolacao(registro.getDatavl());
			violacao.setDatainicio(registro.getDataivl());
			violacao.setDatafinal(registro.getDatafvl());
			violacao.setDuracao(registro.getDuracaovl());
			violacao.setId(registro.getIdvl());
			violacao.setTipo(registro.getTipovl());
			violacao.setDescricao(registro.getDescricaonot());
			
			
			detento.AdicionarViolacao(violacao);
			
			detentos.add(detento);
		} 
	
		return detentos;
		
	}
	
	public List<Detento> UnificarDetento(List<Detento> listagem) {
			List<Detento> ListaFinal = new ArrayList<>();
	
	Map<String, Detento> mapaDetentos = new HashMap<>();


for (Detento detento : listagem) {
    
    if (mapaDetentos.containsKey(detento.getPontuario())) {
        Detento detentoExistente = mapaDetentos.get(detento.getPontuario());
        detentoExistente.AdicionarListaInteira(detento.getListaViolacoes());
    } else {
  
        mapaDetentos.put(detento.getPontuario(), detento);
    }
}


List<Detento> listaFinal = new ArrayList<>(mapaDetentos.values());

return listaFinal;
}
}
