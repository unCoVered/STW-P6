package stw;

import main.WebServicesServer;
import org.apache.axis.Constants;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.apache.axis.utils.Options;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;

public class Tryhard
{
	public static void main(String[] args)
	{
//		callServiceMethod(args);
//		callDescargaFichero(args);
		callGenerarHTML(args);
//		callGenerarJSON(args);
	}

	public static void callServiceMethod(String[] args)
	{
		try
		{
			String endpoint = args[1];
			String methodName = "serviceMethod";
			String localidad = args[2];
			Service service = new Service();
			Call call = (Call) service.createCall();

			call.setTargetEndpointAddress(new java.net.URL(endpoint));

			call.setOperationName(methodName);

			call.addParameter("localidad", XMLType.XSD_STRING, ParameterMode.IN);

			call.setReturnType(XMLType.SOAP_STRING);

			System.out.println("\n Antes de invocar");
			System.out.println("\t URL: " + endpoint);
			System.out.println("\t MethodName: " + methodName);
			System.out.println("\t Localidad pasada por param: " + localidad + "\n");

			String result = (String) call.invoke(new Object[] { args[2] });

			System.out.println("Resultado: " + result);

		} catch (Exception e)
		{
			//			System.err.println(e.toString());
			e.printStackTrace();
			e.getCause();
		}
	}

	public static void callDescargaFichero(String[] args)
	{
		try
		{
			String endpoint = args[1];
			String methodName = "descargarInfoTiempo";
			String localidad = args[2];
			Service service = new Service();
			Call call = (Call) service.createCall();

			call.setTargetEndpointAddress(new java.net.URL(endpoint));

			call.setOperationName(methodName);

			call.addParameter("localidad", XMLType.XSD_STRING, ParameterMode.IN);

			call.setReturnType(XMLType.SOAP_STRING);

			System.out.println("\n Antes de invocar");
			System.out.println("\t URL: " + endpoint);
			System.out.println("\t MethodName: " + methodName);
			System.out.println("\t Localidad pasada por param: " + localidad + "\n");

			String result = (String) call.invoke(new Object[] { localidad });

			System.out.println("Resultado: " + result);

		} catch (Exception e)
		{
			//			System.err.println(e.toString());
			e.printStackTrace();
			e.getCause();
		}
	}

	private static String callGenerarHTML(String[] args){
		try {

			String endpointURL = args[1];

			Service service = new Service();
			Call call = (Call) service.createCall();
			call.setTargetEndpointAddress(new java.net.URL(endpointURL));
			call.setOperationName(new QName("ServicioAEMET", "generarHTML"));

			System.out.println("URL: " + args[1]);
			System.out.println("localidad: " + args[2]);

			String res = (String) call.invoke(new Object[]{args[2]});
			return res;
		} catch (Exception e) {
			System.err.println(e.toString());
			e.printStackTrace();
			return null;
		}
	}

//	public static void callGenerarHTML(String[] args)
//	{
//		try
//		{
//			String endpoint = args[1];
//			String methodName = "generarHTML";
//			String localidad = args[2];
//			Service service = new Service();
//			Call call = (Call) service.createCall();
//
//			call.setTargetEndpointAddress(new java.net.URL(endpoint));
//
//			call.setOperationName(methodName);
//
//			call.addParameter("localidad", Constants.XSD_STRING, ParameterMode.IN);
//
//			call.setReturnType(Constants.XSD_STRING);
//
//			System.out.println("\n Antes de invocar");
//			System.out.println("\t URL: " + endpoint);
//			System.out.println("\t MethodName: " + methodName);
//			System.out.println("\t Localidad pasada por param: " + localidad + "\n");
//
//			String result = (String) call.invoke(new Object[] { localidad });
//
//			System.out.println("Resultado: " + result);
//
//		} catch (Exception e)
//		{
//			//			System.err.println(e.toString());
//			e.printStackTrace();
//			e.getCause();
//		}
//	}

	public static void callGenerarJSON(String[] args)
	{
		try
		{
			String endpoint = args[1];
			String methodName = "generarJSON";
			String localidad = args[2];
			Service service = new Service();
			Call call = (Call) service.createCall();

			call.setTargetEndpointAddress(new java.net.URL(endpoint));

			call.setOperationName(methodName);

			call.addParameter("localidad", XMLType.XSD_STRING, ParameterMode.IN);

			call.setReturnType(XMLType.SOAP_STRING);

			System.out.println("\n Antes de invocar");
			System.out.println("\t URL: " + endpoint);
			System.out.println("\t MethodName: " + methodName);
			System.out.println("\t Localidad pasada por param: " + localidad + "\n");

			String result = (String) call.invoke(new Object[] { localidad });

			System.out.println("Resultado: " + result);

		} catch (Exception e)
		{
			//			System.err.println(e.toString());
			e.printStackTrace();
			e.getCause();
		}
	}

}