package searchengine.server;

import java.io.*;
import java.net.Socket;
import java.util.StringTokenizer;

import searchengine.search.SearchDriver;

public class Client {
	public static String main(String v) throws Exception {
		String sentence;
		String aa;
		SearchDriver sd=new SearchDriver();
		String modifiedsentence;
		BufferedReader infromuser = new BufferedReader(new InputStreamReader(
				System.in));
		//Socket clientSocket = new Socket("127.0.0.1", 4001);
		//DataOutputStream outtoServer = new DataOutputStream(clientSocket.getOutputStream());
	
		//DataInputStream infromserver = new DataInputStream(clientSocket.getInputStream());
		//System.out.println("Enter Message to Server");
		
		sentence = v;
		//outtoServer.writeBytes(sentence + '\n');
		//modifiedsentence = infromserver.readUTF();
		//aa=modifiedsentence;
		//System.out.println("FROM SERVER:  " + modifiedsentence);
		//clientSocket.close();
		StringTokenizer st = new StringTokenizer(sentence," ");
		String str1 = st.nextToken();
		String str2 = st.nextToken();
		String str3 = st.nextToken();
		String str4 = st.nextToken();
		aa=sd.Search(str2, str3, str4, str1);			
		
		return aa;

	}
}
