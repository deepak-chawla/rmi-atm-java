import java.rmi.*;
import java.rmi.server.*;

class EchoServer{

public static void main(String[]args) 
throws RemoteException, java.net.MalformedURLException{

ATMImpl mr = new ATMImpl();

UnicastRemoteObject.exportObject(mr);

Naming.rebind("rmi://localhost/MyObject",mr);

System.out.println("RMI Server Started"); } }
