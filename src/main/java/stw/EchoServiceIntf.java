package stw;

public interface EchoServiceIntf extends java.rmi.Remote {
	public String echoString(String cad) throws java.rmi.RemoteException;
}