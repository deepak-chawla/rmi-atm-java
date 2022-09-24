import java.rmi.*;

public class EchoClient{
public static void main(String[]args)  throws RemoteException, NotBoundException, 
java.net.MalformedURLException{

ATM ob = (ATM)Naming.lookup("rmi://localhost/MyObject");

int number1 = ob.add(2,3);
int number2 = ob.sub(2,3);

System.out.println("Addition Value: "+number1);
System.out.println("Substract Value: "+number2); } }
