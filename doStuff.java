import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class doStuff {
	int userAns;
	String serverTask;



public doStuff(int n,int clientNum){
	System.out.println("The user enter " + n);
		switch(n){
		case 1 :
			serverTask = "date";
			System.out.println("Responding to date request from the client " + clientNum);
			break;
		case 2:
			serverTask = "uptime";
			System.out.println("Responding to uptime request from the client "+ clientNum);
			break;
		case 3:
			serverTask = "free -m";
			System.out.println("Responding to memory request from the client "+ clientNum);
			break;
		case 4:
			serverTask = "netstat";
			System.out.println("Responding to netstat request from the client " + clientNum);
			break;
		case 5:
			serverTask = "who";
			System.out.println("Responding to current users request from the client " + clientNum);
			break;
		case 6: 
			serverTask = "ps ax";
			System.out.println("Responding to running processes request from the client " + clientNum);
			break;

		}
		
	}




public String tryingOutStuff(){
	Runtime r = Runtime.getRuntime();
	
	try{
		StringBuilder output = new StringBuilder();
		Process p = r.exec(serverTask);
		
		InputStream in = p.getInputStream();
		
		BufferedInputStream buf = new BufferedInputStream(in);
		InputStreamReader inread = new InputStreamReader(buf);
		BufferedReader bufferedreader = new BufferedReader(inread);
		
		String line;
		while((line = bufferedreader.readLine()) != null){
			output.append(line);
			output.append("\n");
		}
		
		return output.toString();
	}
	
	catch(IOException e){
		System.err.println(e.getMessage());
	}
	return null;
}


}
	
