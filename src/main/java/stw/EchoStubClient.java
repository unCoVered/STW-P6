package stw;

public class EchoStubClient {
	public static void main(String[] args) {
		try {
			if (args.length < 1) {
				System.out.println("Usage:: java EchoStubClient <string> ");
				return;
			}
			String cad = args[0];
			localhost.axis.echo_jws.EchoService efs =
					new localhost.axis.echo_jws.EchoServiceLocator();
			localhost.axis.echo_jws.Echo e = efs.getecho();
			System.out.println("Sent '" + cad + "', got '"
					+ e.echoString(cad)
					+ "'");
		} catch (Exception e) {
			System.err.println("Execution failed. Exception: " + e);
		}
	}
}