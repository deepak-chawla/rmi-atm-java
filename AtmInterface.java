import java.rmi.*;
import java.rmi.server.*;

interface AtmInterface extends Remote{
void register() throws RemoteException;
String login() throws RemoteException;
double money() throws RemoteException;
void withdraw() throws RemoteException;
String deposit() throws RemoteException;
}
