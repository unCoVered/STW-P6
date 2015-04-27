/**
 * Autor: Alejandro Galvez
 * NIP: 631211
 * Fecha Creacion: 04-18-15
 * Fecha modificacion:
 * Tiempo invertido:
 */
package server.parser.XML;

import server.common.CodeNames;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import java.util.List;
import java.util.SortedMap;

/**
 * Obtiene los nombres de las localidades y los asocia con su ID
 */
public class ExtraerNombres
{
	/**
	 * Rellena un mapa con el ID + Nombre de las localidades
	 */
	public static void rellenaMapLocalidades(String archivo, SortedMap<Integer, String> localidades)
	{
		try
		{
			// Elegimos server.parser
			SAXBuilder constructor = new SAXBuilder();

			// Construimos arbol
			Document doc = constructor.build(archivo);

			// Obtenemos raiz
			Element raiz = doc.getRootElement();

			if (raiz.getName().equals(CodeNames.ROOT_ATR))
			{
				// Lista de secciones
				List<Element> secciones = raiz.getChildren();

				for (Element seccion : secciones)
				{
					if (seccion.getName().equals("nombre"))
					{
						localidades.put(Integer.parseInt(archivo.substring(archivo.length() - 9).substring(0, 5)),
								seccion.getValue());
					}
				}
			}
		} catch (Exception ex)
		{
			System.out.println("Exception rellenaLocalidades");
			ex.printStackTrace();
		}
	}

}
