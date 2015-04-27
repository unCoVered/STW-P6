package client;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.utils.Options;

import javax.xml.namespace.QName;

public class Echo {

	public static void main(String[] args) {
		try {
			Options options = new Options(args);

			String endpointURL = options.getURL();

			Service service = new Service();
			Call call = (Call) service.createCall();
			call.setTargetEndpointAddress(new java.net.URL(endpointURL));
			call.setOperationName(new QName("WebServicesServer", "generarHTML"));
			String res = (String) call.invoke(new Object[]{"50297"});
			System.out.println(res);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}