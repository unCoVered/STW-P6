/**
 * Autor: Alejandro Galvez
 * NIP: 631211
 * Fecha Creacion: 04-18-15
 * Fecha modificacion:
 * Tiempo invertido:
 */
package GUI;

import generator.JSON.CrearFicheroJSON;
import generator.JSON.EncapsulaDias;
import parser.XML.ExtraerDiasLista;
import parser.XML.ListaDia;
import parser.XML.ProcesadorFicheroXML;

import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Map;
import java.util.SortedMap;

/**
 * Crea una clase que anyade un boton cuya accion linkea con los metodos encargados de generar el fichero JSON
 */
public class ButtonJSON extends JButton implements ActionListener
{

	private static String RUTA_RESOURCES = "/home/alex/Repositories/stw/Practica6/src/main/resources/predictions/";
	private static String RUTA_FICHERO = "/home/alex/Repositories/stw/Practica6/src/main/resources/";

	private ComboBox comboBox;
	private String localidad;
	private SortedMap<Integer, String> mapLocalidades;

	public ButtonJSON()
	{
		super("Obtener JSON");

		addActionListener(this);
	}

	public ButtonJSON(ComboBox comboBox, SortedMap<Integer, String> mapLocalidades)
	{
		super("Obtener JSON");

		this.comboBox = comboBox;
		this.localidad = comboBox.getValue();
		this.mapLocalidades = mapLocalidades;

		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e)
	{
		try
		{
			System.out.println("Pulsado boton JSON. Falta implementar SOAP.");

			ListaDia listaDia = new ListaDia();

			this.localidad = this.comboBox.getValue();
			boolean encontrado = false;
			String fichero = "";
			for (Map.Entry<Integer, String> entry : mapLocalidades.entrySet())
			{
				if (!encontrado)
				{
					if (entry.getValue().equals(this.localidad))
					{
						fichero = RUTA_RESOURCES + "localidad_" + entry.getKey() + ".xml";

						ProcesadorFicheroXML.leePrediccion(listaDia, fichero);

						EncapsulaDias diasEncapsulados = new EncapsulaDias(ExtraerDiasLista.extraerDias(listaDia));

						File fileJSON = new File(RUTA_FICHERO + "prediccion" + localidad + ".json");
						CrearFicheroJSON.leeDias(fileJSON, diasEncapsulados);

						ResultWindow resultWindow = new ResultWindow(fileJSON);
					}
				} else
					break;
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error accion BotonJSON");
		}
	}
}
