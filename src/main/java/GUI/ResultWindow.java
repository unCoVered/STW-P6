/**
 * Autor: Alejandro Galvez
 * NIP: 631211
 * Fecha Creacion: 04-18-15
 * Fecha modificacion:
 * Fecha modificacion: 04-22-15
 * Tiempo invertido: 1h 30min.
 */
package GUI;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Muestra por pantalla el fichero resultante de pulsar el boton
 */
public class ResultWindow
{

	private File fileName;

	/*
	 * Constructor
	 */
	public ResultWindow(File fileName)
	{
		try
		{
			this.fileName = fileName;

			createResultWindow();
		}
		catch(IOException ex)
		{
			System.out.println("Error IO en createResult");
			ex.printStackTrace();
		}
		catch(BadLocationException exc)
		{
			System.out.println("Error BadLocation en createResult");
			exc.printStackTrace();
		}
	}

	public void createResultWindow() throws IOException, BadLocationException
	{
		JFrame frame = new JFrame("Displaying file content");

		String format = this.fileName.getName().substring(this.fileName.getName().length()-5);

		if(format.equals(".html"))
			displayHTML(frame);
		else
			displayJSON(frame);

		//Display
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Muestra el HTML
	 * @param frame
	 * @throws IOException
	 */
	private void displayHTML(JFrame frame) throws IOException
	{
		JEditorPane jEditorPane = new JEditorPane();
		jEditorPane.setEditable(false);
		jEditorPane.setContentType("text/html");

		String string = new String("");
		String stringLine = new String("");
		BufferedReader bufferedReader = new BufferedReader(new FileReader(this.fileName));
		while((stringLine = bufferedReader.readLine()) != null)
		{
			string+= stringLine + "\n";
		}

		jEditorPane.setText(string);

		frame.getContentPane().add(jEditorPane, BorderLayout.SOUTH);
	}

	/**
	 * Muestra el contenido del fichero JSON
	 * @param frame
	 * @throws IOException
	 */
	private void displayJSON(JFrame frame) throws IOException
	{
		JTextArea jTextArea = new JTextArea();
		jTextArea.setRows(40);
		jTextArea.setColumns(100);
		jTextArea.setEditable(false);
		jTextArea.setTabSize(16);

		JScrollPane jScrollPane = new JScrollPane(jTextArea);
		jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		JPanel jPanel = new JPanel();
		jPanel.add(jScrollPane);

		String string = new String("");
		String stringLine = new String("");
		BufferedReader bufferedReader = new BufferedReader(new FileReader(this.fileName));
		while((stringLine = bufferedReader.readLine()) != null)
		{
			string+= stringLine + "\n";
		}

		jTextArea.setText(string);

		frame.getContentPane().add(jPanel, BorderLayout.SOUTH);
	}

}
