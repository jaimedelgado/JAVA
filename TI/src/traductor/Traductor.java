/**
 * 
 */
package traductor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import modelo.Etapa;
import modelo.EtapaEjemplo;
import modelo.Recurso;

/**
 * @author Jaime Delgado Linares
 *
 */
public class Traductor {
	
	/**
	 * 
	 */
	public Traductor() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Traduce la etapa creando un archivo html que representa la etapa en el directorio "dir"
	 * @param etapa - Etapa de la que quieres crear el archivo html
	 * @param dir - Nombre del directorio donde quieres que se guarden los archivos html
	 */
	public static void traduceEtapa(Etapa etapa, String dir){
		try {
			File carpetaHtml = new File("src\\" + dir);
			String carpetahtml = carpetaHtml.getAbsoluteFile().toString() + "\\";
			FileWriter archivo = new FileWriter("src\\" + dir + "\\" + etapa.html()); 
			PrintWriter out = new PrintWriter(archivo);
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<body>");
			out.println("<div id=\"container\" style=\"width:800px;\">");
			out.println("<div id=\"header\" style=\"background-color:#c0c0c0;\">");
			out.println("<h1 style=\"margin-bottom:0;text-align:center;\">" + "Jaime Delgado Linares" +"</h1>");
			out.println("</div>");
			out.println("<div id=\"menu\" style=\"background-color:#f0f0f0;height:400px;width:200px;float:left;\">");
			
			for(int i=0; i<etapa.numContinuaciones(); i++){
				out.println("<br>");
				out.println("<form name=\"input\" action=\"" + carpetahtml + etapa.continuaciones()[i].etapa().html() + "\" method=\"get\" style=\"text-align:center;\">");
				out.println("<input type=\"submit\" value=\"" + etapa.continuaciones()[i].texto() + "\">");
				out.println("</form>");
				
			}
			out.println("</div>");
			out.println("<div id=\"content\" style=\"background-color:#f8f8f8;height:400px;width:600px;float:left;\">");
			out.println("<iframe src=\"" + carpetahtml + etapa.recurso().html() + "\" style=\"height:400px;width:600px;\" frameborder=\"0\" >");
			out.println("</div>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
			out.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	/**
	 * Traduce un recurso creando el archivo html que representa el recurso en la carpeta "dir"
	 * @param recurso - Recurso del que quieres crear el archivo html
	 * @param dir - Nombre del directorio en el que quieres guardar los archivos
	 */
	public static void traduceRecurso(Recurso recurso, String dir){		
		try {
			File carpetaFotos = new File("src\\fotos");
			String carpetaF = carpetaFotos.getAbsoluteFile().toString() + "\\";
			FileWriter archivo = new FileWriter("src\\" + dir + "\\" + recurso.html()); 
			PrintWriter out = new PrintWriter(archivo);
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<body>");
			out.println("<div id=\"recurso\" style=\"text-align:center;\">");
			String im = carpetaF + recurso.imagen();
			out.println("<img border=\"0\" src=\"" + im + "\">");
			out.println("<br>");
			out.println(recurso.descripcion());
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
			out.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		traduceEtapa(EtapaEjemplo.etapaEjemplo, "pruebaFinal");
	}

}
