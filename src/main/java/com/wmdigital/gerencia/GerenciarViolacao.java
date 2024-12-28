package com.wmdigital.gerencia;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.wmdigital.model.Detento;
import com.wmdigital.model.Violacao;

public class GerenciarViolacao {

    public List<Detento> RetirarViolacao(List<Detento> listagem) {
        
        List<Detento> ListaDetento = new ArrayList<>();
                
        for (Detento detento : listagem) {
            
            List<Violacao> ListaViolacao = detento.getListaViolacoes();
            
            Iterator<Violacao> iterador = ListaViolacao.iterator();
            
            
            while (iterador.hasNext()) {
                Violacao violacao = iterador.next();
                
                if (violacao.getDescricao().contains("SEM VIOLAÇÃO")) {
                 
                    iterador.remove();
                }
                
                if (violacao.getDescricao().contains("SEM RELATÓRIO")) {
                    
                    iterador.remove();
                }
                
            }
            
            if (!detento.getListaViolacoes().isEmpty()) {
                ListaDetento.add(detento);
            }
        }
        
        return ListaDetento;
    }
}
