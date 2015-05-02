package server;

import server.common.CodeNames;
import server.generator.HTML.CrearPaginaHTML;
import server.generator.JSON.CrearFicheroJSON;
import server.generator.JSON.EncapsulaDias;
import org.apache.axis.AxisFault;
import server.parser.XML.ExtraerDiasLista;
import server.parser.XML.GestorDescargaFichero;
import server.parser.XML.ListaDia;
import server.parser.XML.ProcesadorFicheroXML;

import java.io.File;

public class WebServicesServer
{

	private String RUTA_RESOURCES = "/home/alex/Repositories/stw/Practica6/src/main/resources/predictions";
	private String RUTA_FICHERO = "/home/alex/Repositories/stw/Practica6/src/main/resources/";

	public WebServicesServer(){}

	public String descargarInfoTiempo(String idlocalidadRecibo) throws AxisFault
	{
		Integer idlocalidad = Integer.parseInt(idlocalidadRecibo);

		File file = GestorDescargaFichero
				.descargarFichero(RUTA_RESOURCES, "http://www.aemet.es/xml/municipios/localidad_" + idlocalidad + ".xml");

		return file.getAbsolutePath();TAREA:
- Funciona. Errores de libs arreglados
	}

	public String generarHTML(String idlocalidadRecibo) throws AxisFault
	{
		ListaDia listaDia = new ListaDia();

		Integer idlocalidad = Integer.parseInt(idlocalidadRecibo);

		String fichero = RUTA_RESOURCES + "/" + CodeNames.LOCALIDAD_STRING + idlocalidad + CodeNames.XML_EXTENSION;

		ProcesadorFicheroXML.leePrediccion(listaDia, fichero);

		EncapsulaDias diasEncapsulados = new EncapsulaDias(ExtraerDiasLista.extraerDias(listaDia));

		File fileHTML = new File(RUTA_FICHERO + CodeNames.PREDICCION_STRING + idlocalidad + CodeNames.HTML_EXTENSION);
		CrearPaginaHTML.escribeDatosDia(fileHTML, diasEncapsulados);

		return fileHTML.getAbsolutePath();
	}

	public String generarJSON(String idlocalidadRecibo) throws AxisFault
	{
		ListaDia listaDia = new ListaDia();

		Integer idlocalidad = Integer.parseInt(idlocalidadRecibo);

		String fichero = RUTA_RESOURCES + "/" + CodeNames.LOCALIDAD_STRING + idlocalidad + CodeNames.XML_EXTENSION;

		ProcesadorFicheroXML.leePrediccion(listaDia, fichero);

		EncapsulaDias diasEncapsulados = new EncapsulaDias(ExtraerDiasLista.extraerDias(listaDia));

		File fileJSON = new File(RUTA_FICHERO + CodeNames.PREDICCION_STRING + idlocalidad + CodeNames.JSON_EXTENSION);
		CrearFicheroJSON.leeDias(fileJSON, diasEncapsulados);

		return fileJSON.getAbsolutePath();
	}

	public String serviceMethod(String arg)
	{
		return arg;
	}

}
