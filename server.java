import java.io.*;
import java.net.*;
import java.util.*;
public class server {
public static void main(String[] args){
	
	new server();
	}//end main

	public server(){
		try{
			int clientNum = 1;
			System.out.println("Server starting");
			//create a server socket
			ServerSocket serverSocket = new ServerSocket(3869);
			
			
			
			while(true){
				Socket socket = serverSocket.accept();
				
				System.out.println("Accepted Client connection");
				
				handleAClient task = new handleAClient(socket,clientNum);
				
				System.out.println("Running thread " + clientNum);
				new Thread(task).start();
				
				clientNum++;
			
				
			}//end while loop
			
		}//end try
			catch(IOException ex){
					System.err.println(ex);
			}//end catch
	}//end server
	
	class handleAClient implements Runnable{
		private Socket socket;
		private int clientNum;
		
		public handleAClient(Socket socket,int clientNum){
			this.socket = socket;
			this.clientNum = clientNum;
		}
		
		public void run(){
			//Listen for a connection request
			try {
				
				//create data input and output streams
				DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
				
				DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
				
				while(true){
					int userInput = inputFromClient.readInt();
					
					doStuff testing = new doStuff(userInput,clientNum);
					
					outputToClient.writeUTF(testing.tryingOutStuff());
					
					outputToClient.flush();
				}
			}
			
			catch (IOException e) {
				System.out.println("Responding to quit request from the client " + clientNum);
				Thread.currentThread().interrupt();
			}
			
		}
	}
}//end server class
