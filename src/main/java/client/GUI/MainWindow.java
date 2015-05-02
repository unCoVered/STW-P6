/**
 * Autor: Alejandro Galvez
 * NIP: 631211
 * Fecha Creacion: 04-18-15
 * Fecha modificacion: 04-22-15
 * Tiempo invertido: 1h.
 */
package client.GUI;

import javax.swing.*;
import java.awt.*;
import java.util.SortedMap;

/**
 * Ventana principal que contendrá el resto de elementos.
 */
public class MainWindow
{
	ComboBox comboBox;
	SortedMap<Integer, String> mapLocalidades;

	/**
	 * Constructor
	 */
	public MainWindow(SortedMap<Integer, String> mapLocalidades)
	{
		this.mapLocalidades = mapLocalidades;

		createWindow(mapLocalidades);
	}

	/**
	 * Crea la ventana
	 */
	private void createWindow(SortedMap<Integer, String> mapLocalidades)
	{
		JFrame frame = new JFrame("Weather");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(450, 100));

		this.comboBox = new ComboBox(mapLocalidades);
		frame.getContentPane().add(comboBox, BorderLayout.CENTER);

		//Botones
		ButtonXML buttonXML = new ButtonXML(comboBox, mapLocalidades);
		ButtonHTML buttonHTML = new ButtonHTML(comboBox, mapLocalidades);
		ButtonJSON buttonJSON = new ButtonJSON(comboBox, mapLocalidades);

		JPanel panel = new JPanel();
		panel.add(buttonXML, BorderLayout.EAST);
		panel.add(buttonHTML, BorderLayout.CENTER);
		panel.add(buttonJSON, BorderLayout.WEST);

		frame.getContentPane().add(panel, BorderLayout.SOUTH);

		//Display
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
	}

	public SortedMap<Integer, String> getMapLocalidades()
	{
		return mapLocalidades;
	}

	public void setMapLocalidades(SortedMap<Integer, String> mapLocalidades)
	{
		this.mapLocalidades = mapLocalidades;
	}

	public ComboBox getComboBox()
	{
		return comboBox;
	}
}
