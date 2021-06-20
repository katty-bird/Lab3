package chatterbox;

import java.io.*; 
import java.net.*;  
import javax.swing.JOptionPane;
import java.util.Scanner;


class TCPClient { 
	    public static void main(String argv[])  
	    {	
	    	try {
	    		while (true) {
	    			System.out.println("Your message: "); 
	    			Scanner input = new Scanner(System.in);
	    			Socket clientSocket = new Socket("127.0.0.1", 8000);
	    			String modifiedSentence;
	    	        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
	   		        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
	   		        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	   		        String sentence =inFromUser.readLine(); 
	   		        outToServer.writeBytes(sentence + '\n'); 
    		        modifiedSentence = inFromServer.readLine(); 	    		        
    		        System.out.println("FROM SERVER: " + modifiedSentence + '\n');
	    		}
	    	} catch (Exception e) {
	    		System.out.println(e);
	    	}
	    }
}