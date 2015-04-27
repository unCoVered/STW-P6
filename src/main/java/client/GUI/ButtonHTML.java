/**
 * Autor: Alejandro Galvez
 * NIP: 631211
 * Fecha Creacion: 04-18-15
 * Fecha modificacion: 04-22-15
 * Tiempo invertido: 1h 30min.
 */
package client.GUI;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.utils.Options;
import server.WebServicesServer;

import javax.swing.*;
import javax.xml.namespace.QName;
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

//	private static String URL = "http://localhost:8080/axis/services/WebServicesServer";

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
			System.out.println("Pulsado boton html");

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

//						WebServicesServer webServicesServer = new WebServicesServer();
//						String nombreRecibido = webServicesServer.generarHTML(entry.getKey().toString());

						String nombreRecibido = callGenerarHTML(entry.getKey().toString());

						ResultWindow resultWindow = new ResultWindow(new File(nombreRecibido));
//						System.out.println(nombreRecibido);

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

	private static String callGenerarHTML(String localidad){
		try {

//			String endpointURL = URL;

			Options options = new Options(new String[]{});

			String endpointURL = options.getURL();

			Service service = new Service();
			Call call = (Call) service.createCall();
			call.setTargetEndpointAddress(new java.net.URL(endpointURL));
			call.setOperationName(new QName("WebServicesServer", "generarHTML"));

//			System.out.println("URL: " + URL);
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
