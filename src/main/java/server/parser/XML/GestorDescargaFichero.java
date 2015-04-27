/**
 * Autor: Alejandro Galvez
 * NIP: 631211
 * Fecha Creacion: 03-31-15
 * Fecha modificacion: 04-05-15
 * Tiempo invertido: 30min
 */
package server.parser.XML;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;

public class GestorDescargaFichero
{
	/**
	 * Dada una ruta, genera un objeto file con el fichero descargado
	 *
	 * @param rutaFichero
	 * @return
	 */
	public static File descargarFichero(String rutaFichero, String urlFichero)
	{
		File fichero = null;
		URL ruta = null;
		boolean error = false;

		try
		{
			fichero = new File(rutaFichero + "/" + urlFichero.substring(urlFichero.length() - 19));
			ruta = new URL(urlFichero);

			FileUtils.copyURLToFile(ruta, fichero);
		} catch (Exception e)
		{
			System.out.println("Error descargarFichero: " + urlFichero.substring(urlFichero.length() - 19)
					+ ". Falta implementar SOAP");

			error = true;

		}
		finally
		{
			if (error)
			{

			}

			return fichero;
		}
	}
}
