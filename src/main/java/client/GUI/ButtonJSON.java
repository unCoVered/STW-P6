/**
 * Autor: Alejandro Galvez
 * NIP: 631211
 * Fecha Creacion: 04-18-15
 * Fecha modificacion: 04-22-15
 * Tiempo invertido: 1h 30min.
 */
package client.GUI;

import client.MainGUI;
import org.apache.axis.utils.Options;
import server.common.CodeNames;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import javax.swing.*;
import javax.xml.namespace.QName;
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
			System.out.println("Pulsado boton JSON");

			this.localidad = this.comboBox.getValue();
			boolean encontrado = false;
			for (Map.Entry<Integer, String> entry : mapLocalidades.entrySet())
			{
				if (!encontrado)
				{
					if (entry.getValue().equals(this.localidad))
					{
						encontrado = true;

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

	private static String callGenerarJSON(String localidad)
	{
		try {
			Options options = new Options(new String[]{});

			String endpointURL = options.getURL();

			Service service = new Service();
			Call call = (Call) service.createCall();
			call.setTargetEndpointAddress(new java.net.URL(endpointURL));
			call.setOperationName(new QName("WebServicesServer", "generarJSON"));

			return (String) call.invoke(new Object[]{localidad});
		}
		catch (Exception e) {
			System.err.println(e.toString());
			e.printStackTrace();
			return null;
		}
	}
}
