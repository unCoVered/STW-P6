/**
 * Autor: Alejandro Galvez
 * NIP: 631211
 * Fecha Creacion: 04-18-15
 * Fecha modificacion: 04-22-15
 * Tiempo invertido: 30min.
 */
package main;

import GUI.MainWindow;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import parser.XML.ExtraerNombres;
import parser.XML.GestorDescargaFichero;

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
	private static String RUTA_RESOURCES = "/home/alex/Repositories/stw/Practica6/src/main/resources/predictions";
	private static String URL = "http://localhost:8080/axis/services/WebServicesServer";

	public static void main(String[] args)
	{
		try
		{
//			//Metodo para obtener la lista de municipios
//			System.out.println("Descargando XML de predicciones");
//			for (int i = 50001; i < 50299; i++)
//			{
//				Integer localidad = i;
//
//				WebServicesServer webServicesServer = new WebServicesServer();
//				webServicesServer.descargarInfoTiempo(localidad.toString());
//
////				String descargado = callServiceDescargarFichero(localidad.toString());
////				System.out.println(descargado);
//			}

			File directory = new File(RUTA_RESOURCES);
			SortedMap<Integer, String> localidades = new TreeMap<Integer, String>();
			if (directory.exists())
			{
				File[] directoryList = directory.listFiles();
				for (File file : directoryList)
				{
					String archivo = RUTA_RESOURCES + "/" + file.getName();
					ExtraerNombres.rellenaMapLocalidades(archivo, localidades);
				}
			} else
				System.out.println("No existe el directorio!");

			//Muestra la ventana con los municipio
			MainWindow window = new MainWindow(localidades);

//			String localidad = "50297";
//			callServiceRandom(localidad);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static String callServiceDescargarFichero(String localidad)
	{
		try {

			String endpointURL = URL;

			Service service = new Service();
			Call call = (Call) service.createCall();
			call.setTargetEndpointAddress(new java.net.URL(endpointURL));
			call.setOperationName(new QName("ServicioAEMET", "descargarInfoTiempo"));

			System.out.println("URL: " + URL);
			System.out.println("localidad: " + localidad);

			String res = (String) call.invoke(new Object[]{localidad});

			return res;
		} catch (Exception e) {
			System.err.println(e.toString());
			e.printStackTrace();
			return null;
		}
	}


	////////////////////////////////////////////////////////

	public static String callServiceRandom(String localidad)
	{
		try {

			String endpointURL = URL;

			Service service = new Service();
			Call call = (Call) service.createCall();
			call.setTargetEndpointAddress(new java.net.URL(endpointURL));
			call.setOperationName(new QName("ServicioAEMET", "serviceMethod"));

			System.out.println("URL: " + URL);
			System.out.println("localidad: " + localidad);

			String res = (String) call.invoke(new Object[]{localidad});

			return res;
		} catch (Exception e) {
			System.err.println(e.toString());
			e.printStackTrace();
			return null;
		}
	}

}
