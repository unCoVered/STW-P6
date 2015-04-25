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
//		callGenerarHTML(args);
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

			String result = (String) call.invoke(new Object[] { localidad });

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

	public static void callGenerarHTML(String[] args)
	{
		try
		{
			String endpoint = args[1];
			String methodName = "generarHTML";
			String localidad = args[2];
			Service service = new Service();
			Call call = (Call) service.createCall();

			call.setTargetEndpointAddress(new java.net.URL(endpoint));

			call.setOperationName(methodName);

			call.addParameter("localidad", Constants.XSD_STRING, ParameterMode.IN);

			call.setReturnType(Constants.XSD_STRING);

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

//	public static void callServiceMethod(String[] args)
//	{
//		try
//		{
//			String endpointURL = args[1];
//			String localidad = args[2];
//			String serviceName = "serviceMethod";
//			String nameSpace = "http://main/";
//
//			if ((args.length < 3) || (args == null))
//				localidad = "";
//
//			Service  service = new Service();
//			Call call = (Call) service.createCall();
//
//			call.setTargetEndpointAddress(new java.net.URL(endpointURL));
//			call.setOperationName(new QName(nameSpace, serviceName));
//
//			call.addParameter("localidad", Constants.XSD_STRING, ParameterMode.IN);
//			call.setReturnType(Constants.XSD_STRING);
//
//			System.out.println("Antes de invocar");
//			String ret = (String) call.invoke(new Object[] { localidad });
//
//			System.out.println("URL : " + endpointURL);
//			System.out.println("You typed : " + ret);
//		} catch (Exception e)
//		{
//			//			System.err.println(e.toString());
//			e.printStackTrace();
//			e.getCause();
//		}
//	}

	//	public static void callDescargaFichero(String[] args)
//	{
//		try
//		{
//			String endpointURL = args[1];
//			Integer localidad = Integer.parseInt(args[2]);
//			String serviceName = "descargarInfoTiempo";
//			String nameSpace = "http://main/";
//
//			if ((args.length < 3) || (args == null))
//				localidad = 0;
//
//			Service  service = new Service();
//			Call call = (Call) service.createCall();
//
//			call.setTargetEndpointAddress(new java.net.URL(endpointURL));
//			call.setOperationName(new QName(nameSpace, serviceName));
//
//			call.addParameter("localidad", Constants.XSD_INTEGER, ParameterMode.IN);
//			call.setReturnType(Constants.XSD_STRING);
//
//			System.out.println("Antes de invocar");
//			String ret = (String) call.invoke(new Object[] { localidad });
//
//			System.out.println("URL : " + endpointURL);
//			System.out.println("You typed : " + ret);
//		} catch (Exception e)
//		{
//			//			System.err.println(e.toString());
//			e.printStackTrace();
//			e.getCause();
//		}
//	}

//	public static void callGenerarHTML(String[] args)
//	{
//		try
//		{
//			String endpointURL = args[1];
//			Integer localidad = Integer.parseInt(args[2]);
//			String serviceName = "generarHTML";
//			String nameSpace = "http://main/";
//
//			if ((args.length < 3) || (args == null))
//				localidad = 0;
//
//			Service  service = new Service();
//			Call call = (Call) service.createCall();
//
//			call.setTargetEndpointAddress(new java.net.URL(endpointURL));
//			call.setOperationName(new QName(nameSpace, serviceName));
//
//			call.addParameter("localidad", Constants.XSD_INTEGER, ParameterMode.IN);
//			call.setReturnType(Constants.XSD_STRING);
//
//			System.out.println("Antes de invocar");
//			String ret = (String) call.invoke(new Object[] { localidad });
//
//			System.out.println("URL : " + endpointURL);
//			System.out.println("You typed : " + ret);
//		} catch (Exception e)
//		{
//			//			System.err.println(e.toString());
//			e.printStackTrace();
//			e.getCause();
//		}
//	}

//	public static void callGenerarJSON(String[] args)
//	{
//		try
//		{
//			String endpointURL = args[1];
//			Integer localidad = Integer.parseInt(args[2]);
//			String serviceName = "generarJSON";
//			String nameSpace = "http://main/";
//
//			if ((args.length < 3) || (args == null))
//				localidad = 0;
//
//			Service  service = new Service();
//			Call call = (Call) service.createCall();
//
//			call.setTargetEndpointAddress(new java.net.URL(endpointURL));
//			call.setOperationName(new QName(nameSpace, serviceName));
//
//			call.addParameter("localidad", Constants.XSD_INTEGER, ParameterMode.IN);
//			call.setReturnType(Constants.XSD_STRING);
//
//			System.out.println("Antes de invocar");
//			String ret = (String) call.invoke(new Object[] { localidad });
//
//			System.out.println("URL : " + endpointURL);
//			System.out.println("You typed : " + ret);
//		} catch (Exception e)
//		{
//			//			System.err.println(e.toString());
//			e.printStackTrace();
//			e.getCause();
//		}
//	}
}