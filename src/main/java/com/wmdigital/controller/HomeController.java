package com.wmdigital.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.FileTemplateResolver;

import com.wmdigital.gerencia.GerenciarDetento;
import com.wmdigital.gerencia.GerenciarViolacao;
import com.wmdigital.model.ApachePoiLeitorExcel;
import com.wmdigital.model.Detento;
import com.wmdigital.model.Registro;
import com.wmdigital.uteis.Filtro;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;


@WebServlet(urlPatterns = {"/home", "/home/uploadArquivo", "/sucesso"})
@MultipartConfig
public class HomeController extends HttpServlet {
	
	 private static final long serialVersionUID = 1L;
	 
	    private static final String UPLOAD_DIRECTORY = "uploads";
	    
	    private File fileup;
	    
	    private TemplateEngine templateEngine;

	 
	    
	    @Override
	    public void init() throws ServletException {
	    	super.init();
	    	
//	    	 FileTemplateResolver templateResolver = new FileTemplateResolver();
//	         templateResolver.setPrefix(getServletContext().getRealPath("/WEB-INF/templates/"));  // Diretório onde estão seus templates
//	         templateResolver.setSuffix(".html");  // Sufixo dos arquivos de template
//
//	         // Inicializando o TemplateEngine com o templateResolver
//	         this.templateEngine = new TemplateEngine();
//	         this.templateEngine.setTemplateResolver(templateResolver);

	    	
	    }
	    
	    // Método GET - Página inicial
	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String path = request.getServletPath();

	        // Se a rota for "/home", exibe a página inicial
	        if ("/home".equals(path)) {
	            mostrarHome(request, response);
	            
	        }
	        else if ("/sucesso".equals(path)) {
	        	 mostrarSucesso(request, response);
	        	 
	        } else {
	            response.sendError(HttpServletResponse.SC_NOT_FOUND);
	        }
	    }

	    private void mostrarSucesso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	request.getRequestDispatcher("/html/sucesso.html").forward(request, response);
			
		}

		// Método POST - Upload de Arquivo
	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String path = request.getServletPath();

	        // Se a rota for "/home/uploadArquivo", processa o upload
	        if ("/home/uploadArquivo".equals(path)) {
	            processarUploadArquivo(request, response);
	        } else {
	            response.sendError(HttpServletResponse.SC_NOT_FOUND);
	        }
	    }

	    // Método para exibir a página inicial
	    private void mostrarHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        request.getRequestDispatcher("/html/home.html").forward(request, response);
	        System.out.println("Página inicial exibida");
	    }

	    // Método para processar o upload do arquivo
	    private void processarUploadArquivo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	 Part filePart = request.getPart("excelFile"); // Nome do campo do arquivo no formulário HTML
	         String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

	         // Diretório de upload relativo ao contexto da aplicação
	         String uploadPath = getServletContext().getRealPath("/"+ UPLOAD_DIRECTORY);
	         
	         // Cria o diretório se não existir
	         File uploadDir = new File(uploadPath);
	         if (!uploadDir.exists()) {
	             uploadDir.mkdirs();
	             System.out.println("Diretório de upload criado: " + uploadPath);
	         }

	         // Caminho completo para o arquivo que será salvo
	         File fileToSave = new File(uploadDir, fileName);
	         
	         fileup=fileToSave;

	         // Grava o arquivo no diretório de uploads
	         try (InputStream fileContent = filePart.getInputStream();
	              FileOutputStream fos = new FileOutputStream(fileToSave)) {
	             
	             byte[] buffer = new byte[1024];
	             int bytesRead;
	             while ((bytesRead = fileContent.read(buffer)) != -1) {
	                 fos.write(buffer, 0, bytesRead);
	             }
	         }

	         // Retorna uma resposta para o cliente
	         response.getWriter().println("Arquivo " + fileName + " enviado com sucesso para " + UPLOAD_DIRECTORY + "!");
	         System.out.println("Arquivo salvo emmm: " + fileToSave.getAbsolutePath());
	        
	        // sucessoFile(request,response);
	         
	         ApachePoiLeitorExcel lerExcel = new ApachePoiLeitorExcel();
	         List<Registro> ListRegistro = lerExcel.LerExcel( fileToSave.getAbsolutePath());
	         
	         //Gerenciar Detento
	         
	         GerenciarDetento gerencia = new GerenciarDetento();
	         List<Detento> ListDetento = gerencia.CriarDetentos(ListRegistro);
	         System.out.println("detentos:" + ListDetento.size());
	         //List<Detento> ListDetentoUnificados = gerencia.UnificarDetento(ListDetento);
	         List<Detento> Listfinal = gerencia.UnificarDetento(ListDetento);
	         System.out.println("detentos unificados:" + Listfinal.size());
	         
	         
	         //Gerenciar Violacao
	         GerenciarViolacao gerir = new GerenciarViolacao();
	         List<Detento> ListDetentoFiltrada = gerir.RetirarViolacao(Listfinal);
	         System.out.println("detentos filtrados:" + ListDetentoFiltrada.size());
	         System.out.println("detentosteste:" + ListDetentoFiltrada.getFirst().getNome()); 
	         System.out.println("violacoestotal:" + ListDetentoFiltrada.getFirst().getListaViolacoes().size());
	         for (Detento detento : ListDetentoFiltrada) {
	        	 System.out.println("detentos nome:" + detento.getNome()); 
	        	 System.out.println("detentos violacoes:" + detento.getListaViolacoes().size()); 
	         }
	         
	         //Filtro
	        Filtro filtro = new Filtro();
	        List<Registro> ListRegistro2 =filtro.FirsttFilter(ListRegistro);
	        
//	     	List<Registro> FirsttFilter =  new ArrayList<>();
//	     	List<String> notificacoesEncontradas = new ArrayList<>();
//	     	System.out.println("Notificaçoes encontradas:" +notificacoesEncontradas.toString());
	         
	      // Supondo que ListDetentoFiltrada seja sua lista de detentos filtrados
	         Context context = new Context();
	         context.setVariable("detentosfiltrados", ListDetentoFiltrada);

	         // Obtenha o TemplateEngine
	         TemplateEngine templateEngine = new TemplateEngine();
	         FileTemplateResolver templateResolver = new FileTemplateResolver();
	         templateResolver.setPrefix(getServletContext().getRealPath("/WEB-INF/templates/"));
	         templateResolver.setSuffix(".html");
	         templateEngine.setTemplateResolver(templateResolver);

	         // Renderize o template
	         String renderedTemplate = templateEngine.process("sucesso", context);  // "sucesso" é o nome do arquivo template Thymeleaf

	         // Defina a resposta
	         response.setContentType("text/html");
	         response.getWriter().write(renderedTemplate);
	         
	        // request.setAttribute("detentosfiltrados", ListDetentoFiltrada);
	         //RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/templates/sucesso.html");
	         //dispatcher.forward(request, response);

	    }
	    
	    		    
	    // Método para exibir a página inicial
	    private void sucessoFile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        request.getRequestDispatcher("/html/sucesso.html").forward(request, response);
	        System.out.println("Página sucesso exibida");
	    }
}
	    	
	    	
	    	
	   
	    
