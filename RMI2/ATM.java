import java.rmi.*;
import java.rmi.server.*;

interface ATM extends Remote{
int add(int num1, int num2) throws RemoteException;
int sub(int num1, int num2) throws RemoteException;}
