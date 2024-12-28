package com.wmdigital.interfaces;

import java.util.List;

import com.wmdigital.model.Registro;

public interface ILeitorExcel {
	
	public 	List<Registro> LerExcel(String path);
	

}
