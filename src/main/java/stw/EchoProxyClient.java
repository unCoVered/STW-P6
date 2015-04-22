package stw;

import javax.xml.namespace.QName;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceFactory;
import java.net.URL;

public class EchoProxyClient {
	public static void main(String[] args) {
		try {
			if (args.length < 1) {
				System.out.println("Usage:: java EchoProxyClient <string>");
				return;
			}
			String cad = args[0];

			String wsdlUrl = "http://localhost:8080/axis/echo.jws?wsdl";
			String nameSpaceUri = "http://localhost:8080/axis/echo.jws";
			String serviceName = "echoService";
			String portName = "echo";

			ServiceFactory serviceFactory = ServiceFactory.newInstance();
			Service eService =
					serviceFactory.createService(new URL(wsdlUrl),
					new QName(nameSpaceUri, serviceName));
			EchoServiceIntf eIntf = (EchoServiceIntf) eService.getPort(
					new QName(nameSpaceUri, portName), EchoServiceIntf.class);

			System.out.println("Sent '" + cad + "', got '"
					+ eIntf.echoString(cad) + "'");

		} catch (Exception e) {
			System.err.println("Execution failed. Exception: " + e);
		}
	}
}