/**
 * Autor: Alejandro Galvez
 * NIP: 631211
 * Fecha Creacion: 04-18-15
 * Fecha modificacion: 04-22-15
 * Tiempo invertido: 1h 30min.
 */
package GUI;

import common.CodeNames;
import generator.JSON.CrearFicheroJSON;
import generator.JSON.EncapsulaDias;
import main.WebServicesServer;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import parser.XML.ExtraerDiasLista;
import parser.XML.ListaDia;
import parser.XML.ProcesadorFicheroXML;

import javax.swing.*;
import javax.xml.namespace.QName;
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
	private static String URL = "http://localhost:8080/axis/services/WebServicesServer";

	private ComboBox comboBox;
	private String localidad;
	private SortedMap<Integer, String> mapLocalidades;

	public ButtonJSON()
	{
		super(CodeNames.JSON_BUTTON);

		addActionListener(this);
	}

	public ButtonJSON(ComboBox comboBox, SortedMap<Integer, String> mapLocalidades)
	{
		super(CodeNames.JSON_BUTTON);

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


			this.localidad = this.comboBox.getValue();
			boolean encontrado = false;
			for (Map.Entry<Integer, String> entry : mapLocalidades.entrySet())
			{
				if (!encontrado)
				{
					if (entry.getValue().equals(this.localidad))
					{
						encontrado = true;
//
//						WebServicesServer webServicesServer = new WebServicesServer();
//						String nombreRecibido = webServicesServer.generarJSON(entry.getKey().toString());

						String nombreRecibido = callGenerarJSON(entry.getKey().toString());

						ResultWindow resultWindow = new ResultWindow(new File(nombreRecibido));

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

	private static String callGenerarJSON(String localidad){
		try {

			String endpointURL = URL;

			Service service = new Service();
			Call call = (Call) service.createCall();
			call.setTargetEndpointAddress(new java.net.URL(endpointURL));
			call.setOperationName(new QName("ServicioAEMET", "generarJSON"));

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
