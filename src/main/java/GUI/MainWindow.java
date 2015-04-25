/**
 * Autor: Alejandro Galvez
 * NIP: 631211
 * Fecha Creacion: 04-18-15
 * Fecha modificacion: 04-22-15
 * Tiempo invertido: 1h.
 */
package GUI;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
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
		frame.setPreferredSize(new Dimension(300, 100));

		//Creamos lista con las localidades
		String[] listaLocalidades = new String[mapLocalidades.size()];
		int i = 0;
		for(int key : mapLocalidades.keySet())
		{
			listaLocalidades[i] = mapLocalidades.get(key);
			i++;
		}

		//Label de prueba
		this.comboBox = new ComboBox(listaLocalidades);
		frame.getContentPane().add(comboBox, BorderLayout.CENTER);

		//Botones
		ButtonHTML buttonHTML = new ButtonHTML(comboBox, mapLocalidades);
		ButtonJSON buttonJSON = new ButtonJSON(comboBox, mapLocalidades);

		JPanel panel = new JPanel();
		panel.add(buttonHTML, BorderLayout.EAST);
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
