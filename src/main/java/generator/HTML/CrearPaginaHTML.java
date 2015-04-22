/**
 * Autor: Alejandro Galvez
 * NIP: 631211
 * Fecha Creacion: 03-31-15
 * Fecha modificacion: 04-06-15
 * Tiempo invertido: 30min
 */
package generator.HTML;

import generator.JSON.EncapsulaDias;
import parser.datos.Dia;

import java.io.File;
import java.io.PrintWriter;

/**
 * Clase encargada de crear una pagina HTML.
 */
public class CrearPaginaHTML
{
	/**
	 * Dada una lista de Dias, inctroduce los datos en un fichero HTML
	 * de forma que se muestren los datos al ejecutar la pagina en un
	 * navegador web
	 * @param ficheroHTML
	 * @param diasPrediccion
	 */
	public static void escribeDatosDia(File ficheroHTML, EncapsulaDias diasPrediccion)
	{
		try
		{
			//Definimos printer
			PrintWriter out = new PrintWriter(ficheroHTML);

			//Cabecera
			printCabecera(out);

			//Cuerpo
			printBody(out, diasPrediccion);

			//Cerramos etiquetas hml
			printCierreFichero(out);

			//Cerramos printer
			out.flush();
			out.close();
		} catch (Exception ex)
		{
			System.out.println("Excepcion en leeDias de CrearPaginaHTML");
			ex.printStackTrace();
		}
	}

	/**
	 * Escribe la cabecera del html
	 */
	private static void printCabecera(PrintWriter out)
	{
		out.print("<!DOCTYPE html> \n"
				+ "<html lang=\"es\">\n"
				+ "<!-- Cabecera: Nombre de la pagina y llamada a CSS --> \n"
				+ "<head>\n"
				+ "\t<title>Tiempo Zaragoza</title>\n"
				+ "</head>\n");
	}

	/**
	 * Escribe el cuerpo del html
	 * @param out
	 */
	private static void printBody(PrintWriter out, EncapsulaDias diasPrediccion)
	{
		out.println("<body>");
		out.println("\t<h1>El tiempo de Aragon, esa gran nacion</h1>");
		out.println("\t<font>La web mas cutre que puedas encontrar</font>");
		out.println();

		printDatos(out, diasPrediccion);
	}


	/**
	 * Escribe las etiquetas de cierre del html
	 */
	private static void printCierreFichero(PrintWriter out)
	{
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * Escribe los datos en el html
	 */
	private static void printDatos(PrintWriter out, EncapsulaDias diasPrediccion)
	{
		//Sacamos los dias
		Dia diaPrediccion1 = diasPrediccion.getListaDias().get(0);
		Dia diaPrediccion2 = diasPrediccion.getListaDias().get(1);
		Dia diaPrediccion3 = diasPrediccion.getListaDias().get(2);
		Dia diaPrediccion4 = diasPrediccion.getListaDias().get(3);
		Dia diaPrediccion5 = diasPrediccion.getListaDias().get(4);
		Dia diaPrediccion6 = diasPrediccion.getListaDias().get(5);

		try
		{
			//Inicio tabla
			out.println("\t<table border=1 align=\"center\" cellspacing=\"0\"  style=\"width: 100%\">");

			//Fila fecha y periodos
			out.println("\t\t<tr>");
			out.println("\t\t\t<th rowspan=2 align=\"center\"><h5>Fecha</h5></th>");
			out.println("\t\t\t<td colspan=3 align=\"center\"><font size=\"2\"> Prediccion del dia " + diaPrediccion1.getFecha().toString().substring(4, 10) + "</font></td>");
			out.println("\t\t\t<td colspan=2 align=\"center\"><font size=\"2\"> Prediccion del dia " + diaPrediccion2.getFecha().toString().substring(4, 10) + "</font></td>");
			out.println("\t\t\t<td colspan=2 align=\"center\"><font size=\"2\"> Prediccion del dia " + diaPrediccion3.getFecha().toString().substring(4, 10) + "</font></td>");
			out.println("\t\t\t<td rowspan=2 align=\"center\"><font size=\"2\"> Prediccion del dia " + diaPrediccion4.getFecha().toString().substring(4, 10) + "</font></td>");

//			if(!diaPrediccion5.getFecha().toString().equals(null) || !diaPrediccion6.getFecha().toString().equals(null))
//			{
//				out.println("\t\t\t<td rowspan=2 align=\"center\"><font size=\"2\"> Prediccion del dia " + diaPrediccion5
//								.getFecha().toString().substring(4, 10) + "</font></td>");
//				out.println("\t\t\t<td rowspan=2 align=\"center\"><font size=\"2\"> Prediccion del dia " + diaPrediccion6
//								.getFecha().toString().substring(4, 10) + "</font></td>");
//			}

			out.println("\t\t</tr>");

			out.println("\t\t<tr>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">6-12</font></td>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">12-18</font></td>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">18-24</font></td>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">0-12</font></td>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">12-24</font></td>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">0-12</font></td>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">12-24</font></td>");
			out.println("\t\t</tr>");

			//Fila Estado Cielo
			out.println("\t\t<tr>");
			out.println("\t\t\t<th><h5>Estado cielo</h5></th>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">" +  diaPrediccion1.getEstadoCielo().get("00-06")[0] + "</font></td>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">" +  diaPrediccion1.getEstadoCielo().get("12-18")[0] + "</font></td>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">" +  diaPrediccion1.getEstadoCielo().get("18-24")[0] + "</font></td>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">" +  diaPrediccion2.getEstadoCielo().get("00-12")[0] + "</font></td>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">" +  diaPrediccion2.getEstadoCielo().get("12-24")[0] + "</font></td>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">" +  diaPrediccion3.getEstadoCielo().get("00-12")[0] + "</font></td>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">" +  diaPrediccion3.getEstadoCielo().get("12-24")[0] + "</font></td>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">" +  diaPrediccion4.getEstadoCielo().get("00-24")[0] + "</font></td>");

//			if(!diaPrediccion5.getEstadoCielo().equals(null) || !diaPrediccion6.getEstadoCielo().equals(null))
//			{
//				out.println(
//						"\t\t\t<td align=\"center\"><font size=\"2\">" + diaPrediccion5.getEstadoCielo().get("00-24")[0]
//								+ "</font></td>");
//				out.println(
//						"\t\t\t<td align=\"center\"><font size=\"2\">" + diaPrediccion6.getEstadoCielo().get("00-24")[0]
//								+ "</font></td>");
//			}

			out.println("\t\t</tr>");

			//Fila Prob. Preci
			out.println("\t\t<tr>");
			out.println("\t\t\t<th><h5>Prob. precip.</h5></th>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">" +  diaPrediccion1.getProbPrecipitacion().get("00-06") + "</font></td>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">" +  diaPrediccion1.getProbPrecipitacion().get("12-18") + "</font></td>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">" +  diaPrediccion1.getProbPrecipitacion().get("18-24") + "</font></td>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">" +  diaPrediccion2.getProbPrecipitacion().get("00-12") + "</font></td>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">" +  diaPrediccion2.getProbPrecipitacion().get("12-24") + "</font></td>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">" +  diaPrediccion3.getProbPrecipitacion().get("00-12") + "</font></td>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">" +  diaPrediccion3.getProbPrecipitacion().get("12-24") + "</font></td>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">" +  diaPrediccion4.getProbPrecipitacion().get("00-24") + "</font></td>");

//			if(!diaPrediccion5.getProbPrecipitacion().equals(null) || !diaPrediccion6.getProbPrecipitacion().equals(null))
//			{
//				out.println("\t\t\t<td align=\"center\"><font size=\"2\">" + diaPrediccion5.getProbPrecipitacion()
//						.get("00-24") + "</font></td>");
//				out.println("\t\t\t<td align=\"center\"><font size=\"2\">" + diaPrediccion6.getProbPrecipitacion()
//						.get("00-24") + "</font></td>");
//			}

			out.println("\t\t</tr>");

			//Fila Cota Nieve
			out.println("\t\t<tr>");
			out.println("\t\t\t<th><h5>Cota nieve</h5></th>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">" +  diaPrediccion1.getCotaNieveProv().get("00-06") + "</font></td>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">" +  diaPrediccion1.getCotaNieveProv().get("12-18") + "</font></td>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">" +  diaPrediccion1.getCotaNieveProv().get("18-24") + "</font></td>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">" +  diaPrediccion2.getCotaNieveProv().get("00-12") + "</font></td>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">" +  diaPrediccion2.getCotaNieveProv().get("12-24") + "</font></td>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">" +  diaPrediccion3.getCotaNieveProv().get("00-12") + "</font></td>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">" +  diaPrediccion3.getCotaNieveProv().get("12-24") + "</font></td>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">" +  diaPrediccion4.getCotaNieveProv().get("00-24") + "</font></td>");

//			if(!diaPrediccion5.getCotaNieveProv().equals(null) || !diaPrediccion6.getCotaNieveProv().equals(null))
//			{
//				out.println("\t\t\t<td align=\"center\"><font size=\"2\">" + diaPrediccion5.getCotaNieveProv().get("00-24")
//								+ "</font></td>");
//				out.println("\t\t\t<td align=\"center\"><font size=\"2\">" + diaPrediccion6.getCotaNieveProv().get("00-24")
//								+ "</font></td>");
//			}

			out.println("\t\t</tr>");

			//Fila Temp. min
			out.println("\t\t<tr>");
			out.println("\t\t\t<th><h5>Temperatura</h5></th>");
			out.println("\t\t\t<td colspan=3 align=\"center\"><font size=\"2\">" +  diaPrediccion1.getTemperatura().getMinima() + "/" + diaPrediccion1.getTemperatura().getMaxima() + "</font></td>");
			out.println("\t\t\t<td colspan=2 align=\"center\"><font size=\"2\">" +  diaPrediccion2.getTemperatura().getMinima() + "/" + diaPrediccion2.getTemperatura().getMaxima() + "</font></td>");
			out.println("\t\t\t<td colspan=2 align=\"center\"><font size=\"2\">" +  diaPrediccion3.getTemperatura().getMinima() + "/" + diaPrediccion3.getTemperatura().getMaxima() + "</font></td>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">" +  diaPrediccion4.getTemperatura().getMinima() + "/" + diaPrediccion4.getTemperatura().getMaxima() + "</font></td>");

//			if(!diaPrediccion5.getTemperatura().equals(null) || !diaPrediccion6.getTemperatura().equals(null))
//			{
//				out.println("\t\t\t<td align=\"center\"><font size=\"2\">" + diaPrediccion5.getTemperatura().getMinima()
//						+ "/" + diaPrediccion5.getTemperatura().getMaxima() + "</font></td>");
//				out.println("\t\t\t<td align=\"center\"><font size=\"2\">" + diaPrediccion6.getTemperatura().getMinima()
//						+ "/" + diaPrediccion6.getTemperatura().getMaxima() + "</font></td>");
//			}

			out.println("\t\t</tr>");

			//Fila Viento
			out.println("\t\t<tr>");
			out.println("\t\t\t<th rowspan=2><h5>Viento</h5></th>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">" +  diaPrediccion1.getViento().get("00-06")[0] + "</font></td>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">" +  diaPrediccion1.getViento().get("12-18")[0] + "</font></td>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">" +  diaPrediccion1.getViento().get("18-24")[0] + "</font></td>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">" +  diaPrediccion2.getViento().get("00-12")[0] + "</font></td>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">" +  diaPrediccion2.getViento().get("12-24")[0] + "</font></td>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">" +  diaPrediccion3.getViento().get("00-12")[0] + "</font></td>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">" +  diaPrediccion3.getViento().get("12-24")[0] + "</font></td>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">" +  diaPrediccion4.getViento().get("00-24")[0] + "</font></td>");

//			if(!diaPrediccion5.getViento().equals(null) || !diaPrediccion6.getViento().equals(null))
//			{
//				out.println("\t\t\t<td align=\"center\"><font size=\"2\">" + diaPrediccion5.getViento().get("00-24")[0]
//						+ "</font></td>");
//				out.println("\t\t\t<td align=\"center\"><font size=\"2\">" + diaPrediccion6.getViento().get("00-24")[0]
//						+ "</font></td>");
//			}

			out.println("\t\t</tr>");

			out.println("\t\t<tr>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">" +  diaPrediccion1.getViento().get("00-06")[1] + "</font></td>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">" +  diaPrediccion1.getViento().get("12-18")[1] + "</font></td>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">" +  diaPrediccion1.getViento().get("18-24")[1] + "</font></td>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">" +  diaPrediccion2.getViento().get("00-12")[1] + "</font></td>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">" +  diaPrediccion2.getViento().get("12-24")[1] + "</font></td>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">" +  diaPrediccion3.getViento().get("00-12")[1] + "</font></td>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">" +  diaPrediccion3.getViento().get("12-24")[1] + "</font></td>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">" +  diaPrediccion4.getViento().get("00-24")[1] + "</font></td>");

//			if(!diaPrediccion5.getViento().equals(null) || !diaPrediccion6.getViento().equals(null))
//			{
//				out.println("\t\t\t<td align=\"center\"><font size=\"2\">" + diaPrediccion5.getViento().get("00-24")[1]
//						+ "</font></td>");
//				out.println("\t\t\t<td align=\"center\"><font size=\"2\">" + diaPrediccion6.getViento().get("00-24")[1]
//						+ "</font></td>");
//			}

			out.println("\t\t</tr>");

			//Fila indice UV
			out.println("\t\t<tr>");
			out.println("\t\t\t<th><h5>UVMaximo</h5></th>");
			out.println("\t\t\t<td colspan=3 align=\"center\"><font size=\"2\">" +  diaPrediccion1.getUvMax() + "</font></td>");
			out.println("\t\t\t<td colspan=2 align=\"center\"><font size=\"2\">" +  diaPrediccion2.getUvMax() + "</font></td>");
			out.println("\t\t\t<td colspan=2 align=\"center\"><font size=\"2\">" +  diaPrediccion3.getUvMax() + "</font></td>");
			out.println("\t\t\t<td align=\"center\"><font size=\"2\">" +  diaPrediccion4.getUvMax() + "</font></td>");

//			if(!diaPrediccion5.getUvMax().equals(null) || !diaPrediccion6.getUvMax().equals(null))
//			{
//				out.println("\t\t\t<td align=\"center\"><font size=\"2\">" + diaPrediccion5.getUvMax() + "</font></td>");
//				out.println("\t\t\t<td align=\"center\"><font size=\"2\">" + diaPrediccion6.getUvMax() + "</font></td>");
//			}

			out.println("\t\t</tr>");

			//Fin tabla
			out.println("\t</table>");
		} catch (Exception ex)
		{
			System.out.println("Excepcion en printDatos");
			ex.printStackTrace();
		}
	}
}
