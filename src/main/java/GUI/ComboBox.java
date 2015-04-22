/**
 * Autor: Alejandro Galvez
 * NIP: 631211
 * Fecha Creacion: 04-18-15
 * Fecha modificacion:
 * Tiempo invertido:
 */
package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	public ComboBox(String[] villageArray)
	{
		super(new BorderLayout());

		this.villageArray = villageArray;

		this.villageComboBox = new JComboBox(villageArray);
		this.villageComboBox.setSelectedIndex(0);
		this.villageComboBox.addActionListener(this);

		add(villageComboBox, BorderLayout.PAGE_START);
	}

	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Cambiado el comboBox");

		this.setVillageComboBox((JComboBox)e.getSource());
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
