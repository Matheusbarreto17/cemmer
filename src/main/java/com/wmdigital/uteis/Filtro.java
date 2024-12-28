package com.wmdigital.uteis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.wmdigital.model.Registro;


public class Filtro {
	
	private  List<String> notificacoesEncontradas;
	
	public Filtro() {
		super();
	}

	public List<String> getNotificacoesEncontradas() {
		return notificacoesEncontradas;
	}

	public void setNotificacoesEncontradas(List<String> notificacoesEncontradas) {
		this.notificacoesEncontradas = notificacoesEncontradas;
	}

	public List<Registro> FirsttFilter(List<Registro> listagem) {
		
		
		  notificacoesEncontradas = new ArrayList<>();
		
		 Iterator<Registro> iterador = listagem.iterator();
		 
		 String regex = "N\\d+";
	     Pattern pattern = Pattern.compile(regex);

		 
		 while (iterador.hasNext()) {
         	Registro registro = iterador.next();
             
             if (registro.getDescricaonot().contains("cancela") && registro.getDescricaonot().contains("SUBSTITUI") ){
              
            	 
          Matcher matcher = pattern.matcher(registro.getDescricaonot());
          
          while (matcher.find()) {
            
        	 
			notificacoesEncontradas.add(matcher.group());
			
              
          }
             
             
             }
             
		 }
		 
		 System.out.println("Notificaçoes encontradas:" +notificacoesEncontradas.toString());
		
		return listagem;
	}
	
	
	
	
	
	
	
	
	public List<Registro> SecondtFilter(List<Registro> listagem) {

	            
	            Iterator<Registro> iterador = listagem.iterator();
	            
	            
	            while (iterador.hasNext()) {
	            	Registro registro = iterador.next();
	                
	                if (registro.getDescricaonot().contains("SEM VIOLAÇÃO")) {
	                 
	                    iterador.remove();
	                }
	                
	                if (registro.getDescricaonot().contains("SEM RELATÓRIO")) {
	                    
	                    iterador.remove();
	                }
	                
	            }
	            
		
		return listagem;
	}
	
	
	
	
	
	
	
	
	

}
