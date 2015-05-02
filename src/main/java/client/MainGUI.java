/**
 * Autor: Alejandro Galvez
 * NIP: 631211
 * Fecha Creacion: 04-18-15
 * Fecha modificacion: 04-22-15
 * Tiempo invertido: 30min.
 */
package client;

import client.GUI.MainWindow;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.utils.Options;
import server.parser.CSV.ExtraerLocalidadesCSV;

import javax.xml.namespace.QName;
import java.io.File;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Clase con el main de la aplicacion
 * Muestra una ventana que permite elegir municipio y tipo de fichero a obtener
 */
public class MainGUI
{
	public static void main(String[] args)
	{
		String RUTA_RESOURCES = "/home/alex/Repositories/stw/Practica6/src/main/resources/";

		try
		{
			SortedMap<Integer, String> localidades = new TreeMap<Integer, String>();
			File fileCSV = new File(RUTA_RESOURCES + "codigos.csv");

			ExtraerLocalidadesCSV.readCSV(fileCSV, localidades);

			MainWindow window = new MainWindow(localidades);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
