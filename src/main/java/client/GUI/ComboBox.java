/**
 * Autor: Alejandro Galvez
 * NIP: 631211
 * Fecha Creacion: 04-18-15
 * Fecha modificacion:
 * Tiempo invertido:
 */
package client.GUI;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.utils.Options;

import javax.swing.*;
import javax.xml.namespace.QName;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.SortedMap;

/**
 * Clase que crea un combo Box con los elementos pasados con un array
 */
public class ComboBox extends JPanel implements ActionListener
{

	private String[] villageArray;
	JComboBox villageComboBox;

	public ComboBox()
	{

	}

	public ComboBox(SortedMap<Integer, String> mapLocalidades)
	{
		super(new BorderLayout());

		this.villageArray = this.rellenaLocalidades(mapLocalidades);

		this.villageComboBox = new JComboBox(villageArray);
		this.villageComboBox.setSelectedIndex(0);
		this.villageComboBox.addActionListener(this);

		add(villageComboBox, BorderLayout.PAGE_START);
	}

	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Cambiado el comboBox");

		this.setVillageComboBox((JComboBox) e.getSource());
	}

	private String[] rellenaLocalidades(SortedMap<Integer, String> mapLocalidades)
	{
		String[] listaLocalidades = new String[mapLocalidades.size()];
		int i = 0;
		for(int key : mapLocalidades.keySet())
		{
			listaLocalidades[i] = mapLocalidades.get(key);
			i++;
		}

		return listaLocalidades;
	}

	public String[] getVillageArray()
	{
		return villageArray;
	}

	public void setVillageArray(String[] villageArray)
	{
		this.villageArray = villageArray;
	}

	public JComboBox getVillageComboBox()
	{
		return villageComboBox;
	}

	public void setVillageComboBox(JComboBox villageComboBox)
	{
		this.villageComboBox = villageComboBox;
	}

	public String getValue()
	{
		return (String) villageComboBox.getSelectedItem();
	}
}
