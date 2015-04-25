package main;

import GUI.ResultWindow;
import common.CodeNames;
import generator.HTML.CrearPaginaHTML;
import generator.JSON.CrearFicheroJSON;
import generator.JSON.EncapsulaDias;
import parser.XML.ExtraerDiasLista;
import parser.XML.GestorDescargaFichero;
import parser.XML.ListaDia;
import parser.XML.ProcesadorFicheroXML;

import java.io.File;

public class WebServicesServer
{

	private String RUTA_RESOURCES = "/home/alex/Repositories/stw/Practica6/src/main/resources/predictions";
	private String RUTA_FICHERO = "/home/alex/Repositories/stw/Practica6/src/main/resources/";

	public WebServicesServer(){}

	public String descargarInfoTiempo(String idlocalidadRecibo)
	{
		Integer idlocalidad = Integer.parseInt(idlocalidadRecibo);

		GestorDescargaFichero
				.descargarFichero(RUTA_RESOURCES, "http://www.aemet.es/xml/municipios/localidad_" + idlocalidad + ".xml");

		return RUTA_RESOURCES + "localidad__" + idlocalidad + ".xml";
	}

	public String generarHTML(String idlocalidadRecibo)
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

	public String generarJSON(String idlocalidadRecibo)
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
		System.out.println("Entra aqui");
		return arg;
	}

}
