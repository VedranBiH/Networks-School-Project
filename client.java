import java.io.*;
import java.net.*;
import java.util.Scanner;
public class client {

	private static DataOutputStream toServer;
	private static DataInputStream fromServer;
	
	public static void main(String[] args) {
	
		new client();
		
	}//end main
	
	public client(){
		try{
			//create a socket to connect to the server
			Socket socket = new Socket("139.62.210.149",3869);
			
			//create an input stream to receive data from the server
			fromServer = new DataInputStream(socket.getInputStream());
			
			//create an output stream to send data to the server
			toServer = new DataOutputStream(socket.getOutputStream());
			
			while(true){
			printMenu();
			System.out.println(fromServer.readUTF());
			toServer.flush();
			}
			
		}//end try
			
			catch(IOException ex){
				System.err.println(ex);
			}//end catch
		
	}//end client cons
	static void sendUserAns(int n){
		
		System.out.println("The user input is " + n);
		switch(n){
		
		case 1:
			try {
				toServer.writeInt(n);
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case 2:
			try {
				toServer.writeInt(n);
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case 3 :
			try {
				toServer.writeInt(n);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			break;
		case 4: 
			try {
				toServer.writeInt(n);
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case 5 :
			try {
				toServer.writeInt(n);
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case 6:
			try {
				toServer.writeInt(n);
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case 7:
			try {
				toServer.writeInt(n);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.exit(0);
			break;
			default :
				System.out.println("Invalid number please enter 1-7\n");
				printMenu();
				break;
		
		}
	}//end sendUserAns
	
	static void printMenu(){
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter a number corresponding to the menu below");
		System.out.print("Menu\n" 
				+"1.Host Current Date and Time\n"
				+"2.Host uptime\n"
				+"3.Host memory use\n"
				+"4.Host Netstat\n"
				+"5.Host current users\n"
				+"6.Host running processes\n"
				+"7.Quit\n");
		
		while(!input.hasNextInt()){
		input.next();
		System.out.println("Invalid input please enter a number from 1-7");
		printMenu();
		}
		
		sendUserAns(input.nextInt());
	}
}//end client


