import java.rmi.*;
import java.rmi.server.*;

class AtmServer{

public static void main(String[]args) 
throws RemoteException, java.net.MalformedURLException{

AtmImpl mr = new AtmImpl();

UnicastRemoteObject.exportObject(mr);

Naming.rebind("rmi://localhost/MyObject",mr);

System.out.println("RMI Server Started"); } }
