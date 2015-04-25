/**
 * Autor: Alejandro Galvez
 * NIP: 631211
 * Fecha Creacion: 04-18-15
 * Fecha modificacion: 04-22-15
 * Tiempo invertido: 1h 30min.
 */
package GUI;

import common.CodeNames;
import generator.HTML.CrearPaginaHTML;
import generator.JSON.EncapsulaDias;
import main.WebServicesServer;
import parser.XML.ExtraerDiasLista;
import parser.XML.ListaDia;
import parser.XML.ProcesadorFicheroXML;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Map;
import java.util.SortedMap;

/**
 * Crea una clase que anyade un boton cuya accion linkea con los metodos encargados de generar el fichero HTML
 */
public class ButtonHTML extends JButton implements ActionListener
{

	private static String RUTA_RESOURCES = "/home/alex/Repositories/stw/Practica6/src/main/resources/predictions/";
	private static String RUTA_FICHERO = "/home/alex/Repositories/stw/Practica6/src/main/resources/";

	private ComboBox comboBox;
	private String localidad;
	private SortedMap<Integer, String> mapLocalidades;

	public ButtonHTML()
	{
		super("Obtener HTML");

		addActionListener(this);
	}

	public ButtonHTML(ComboBox comboBox, SortedMap<Integer, String> mapLocalidades)
	{
		super("Obtener HTML");

		this.comboBox = comboBox;
		this.localidad = comboBox.getValue();
		this.mapLocalidades = mapLocalidades;

		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e)
	{
		try
		{
			System.out.println("Pulsado boton html. Falta implementar SOAP.");

			this.localidad = this.comboBox.getValue();
//			String fichero = "";
			boolean encontrado = false;
			for (Map.Entry<Integer, String> entry : mapLocalidades.entrySet())
			{
				if (!encontrado)
				{
					if (entry.getValue().equals(this.localidad))
					{
						encontrado = true;

						WebServicesServer webServicesServer = new WebServicesServer();
						String nombreRecibido = webServicesServer.generarHTML(entry.getKey().toString());

						ResultWindow resultWindow = new ResultWindow(new File(nombreRecibido));

					}
				} else
					break;
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error accion botonHTML");
		}
	}
}
