import java.rmi.*;
import java.util.Scanner;

public class AtmClient{

public static void main(String[]args)  throws RemoteException, NotBoundException, 
java.net.MalformedURLException{
AtmInterface atm = (AtmInterface)Naming.lookup("rmi://localhost/MyObject");
Scanner sc = new Scanner(System.in);
		while(true){
		System.out.println("1: register, 2: log in, 3: quit");
		int  i = sc.nextInt();
		switch (i) {
		case 1:
			atm.register();
			break;
		case 2:
			String u = atm.m2();
			while(u!=null){
			System.out.println("1: Request balance, 2: Withdraw, 4 deposit, 5 quit");
			int nextInt = sc.nextInt();
			if(nextInt==1){
				m3("select money from "+table+" where user="+u);
			}if(nextInt==2){
				break;
			}	
			}
			if(nextInt==3){
				System.out.println("Number of Deposits");
				m4("update "+table+" set money=money+"+sc.nextInt()+" where user="+u);
			}
			if(nextInt==4){
				break;
			}
			}
			break;
		}
		if(i==3){
			break;
		}
		}
	}
    

}
