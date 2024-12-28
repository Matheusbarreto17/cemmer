package com.wmdigital.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.wmdigital.interfaces.ILeitorExcel;



public class ApachePoiLeitorExcel implements ILeitorExcel   {

	@Override
	public List<Registro> LerExcel(String path) {
		
		 String filePath = path;
	        System.out.println("filePath: " + filePath);
	        List<Registro> listaRegistro = new ArrayList<>();

	        try (FileInputStream file = new FileInputStream(filePath);
	             XSSFWorkbook workbook = new XSSFWorkbook(file)) {

	            // Acessa a primeira planilha
	            XSSFSheet sheet = workbook.getSheetAt(0);

	            // Percorre cada linha a partir da segunda (índice 1) para ignorar o cabeçalho
	            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
	                XSSFRow row = sheet.getRow(i);
	                if (row != null) {
	                    // Usando o método getCellValue para garantir leitura correta dos tipos de célula
	                    String nome = getCellValue(row.getCell(0));
	                    String prontuario = getCellValue(row.getCell(1));
	                    String estabelecimento = getCellValue(row.getCell(2));
	                    String perfil = getCellValue(row.getCell(3));
	                    String dataIvl = getCellValue(row.getCell(4));
	                    String dataVl = getCellValue(row.getCell(5));
	                    String dataFvl = getCellValue(row.getCell(6));
	                    String duracaoVl = getCellValue(row.getCell(7));
	                    String descricaoNot = getCellValue(row.getCell(8));
	                    String vara = getCellValue(row.getCell(9));
	                    String emailVara = getCellValue(row.getCell(10));
	                    String tipoVl = getCellValue(row.getCell(11));
	                    String processo = getCellValue(row.getCell(12));
	                    String processoVp = getCellValue(row.getCell(13));
	                    String idVl = getCellValue(row.getCell(14));
	                    String idNot = getCellValue(row.getCell(15));
	                    String duracaoAlm = getCellValue(row.getCell(16));
	                    String pje = getCellValue(row.getCell(17));
	                    String usuarioNot = getCellValue(row.getCell(18));
	                    String descricaoJust = getCellValue(row.getCell(19));

	                    // Cria um objeto Registro e adiciona à lista
	                    Registro registro = new Registro(nome, prontuario, estabelecimento, perfil, 
	                                                      dataIvl, dataVl, dataFvl, duracaoVl, descricaoNot, 
	                                                      vara, emailVara, tipoVl, processo, processoVp, 
	                                                      idVl, idNot, duracaoAlm, pje, usuarioNot, descricaoJust);
	                    listaRegistro.add(registro);
	                }
	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        // Exibe os registros lidos do arquivo (isso pode ser substituído por log)
	        for (Registro registro : listaRegistro) {
	            //System.out.println("Nome: " + registro.getNome());
	            //System.out.println("Prontuário: " + registro.getProntuario());
	            
	            // Adicione mais impressões conforme necessário
	        }
	        
	        System.out.println("total de registros: " + listaRegistro.size());

	   
		return listaRegistro;
	}
	
	 private String getCellValue(XSSFCell cell) {
	        if (cell == null) {
	            return "";
	        }

	        switch (cell.getCellType()) {
	            case STRING:
	                return cell.getStringCellValue();
	            case NUMERIC:
	                // Se for um número, pode ser que seja uma data ou número comum
	                if (DateUtil.isCellDateFormatted(cell)) {
	                    // Se a célula contiver uma data, convertemos para uma String formatada
	                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	                    return sdf.format(cell.getDateCellValue());
	                } else {
	                    // Se não for uma data, retornamos o número como String
	                    return String.valueOf(cell.getNumericCellValue());
	                }
	            case BOOLEAN:
	                return String.valueOf(cell.getBooleanCellValue());
	            case FORMULA:
	                // Quando a célula contém uma fórmula, usamos o valor calculado
	                return String.valueOf(cell.getNumericCellValue());  // ou cell.getStringCellValue(), dependendo do tipo da fórmula
	            default:
	                return "";
	        }
	    }

		}

