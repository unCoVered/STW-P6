package stw;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import javax.xml.namespace.QName;

public class TestClient2 {
	public static void main(String [] args) {
		try {
			String endpoint = "http://localhost:8080/axis/echo.jws";
			Service service = new Service();

			Call call = (Call) service.createCall();
			call.setTargetEndpointAddress( new java.net.URL(endpoint) );
			call.setOperationName("echoString");
			/*************************************************************/
			call.addParameter("testParam",
					org.apache.axis.Constants.XSD_STRING,
					javax.xml.rpc.ParameterMode.IN);
			call.setReturnType(org.apache.axis.Constants.XSD_STRING);
			/*************************************************************/
			String ret = (String) call.invoke( new Object[] { "Hello!" } );
			System.out.println("Sent 'Hello!', got '" + ret + "'");
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}
}