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
public class ButtonXML extends JButton implements ActionListener
{

	private ComboBox comboBox;
	private String localidad;
	private SortedMap<Integer, String> mapLocalidades;

	public ButtonXML()
	{
		super("Descargar XML");

		addActionListener(this);
	}

	public ButtonXML(ComboBox comboBox, SortedMap<Integer, String> mapLocalidades)
	{
		super("Descargar XML");

		this.comboBox = comboBox;
		this.localidad = comboBox.getValue();
		this.mapLocalidades = mapLocalidades;

		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e)
	{
		try
		{
			System.out.println("Pulsado boton xml");

			this.localidad = this.comboBox.getValue();
			boolean encontrado = false;
			for (Map.Entry<Integer, String> entry : mapLocalidades.entrySet())
			{
				if (!encontrado)
				{
					if (entry.getValue().equals(this.localidad))
					{
						encontrado = true;

						String nombreRecibido = callServiceDescargarFichero(entry.getKey().toString());
					}
				}
				else
					break;
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error accion botonHTML");
		}
	}

	public static String callServiceDescargarFichero(String localidad)
	{
		try {

			Options options = new Options(new String[]{});

			String endpointURL = options.getURL();

			Service service = new Service();
			Call call = (Call) service.createCall();
			call.setTargetEndpointAddress(new java.net.URL(endpointURL));
			call.setOperationName(new QName("WebServicesServer", "descargarInfoTiempo"));

			return (String) call.invoke(new Object[]{localidad});
		} catch (Exception e) {
			System.err.println(e.toString());
			e.printStackTrace();
			return null;
		}
	}
}
