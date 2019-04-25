package bio.http.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerHandler implements Runnable{

	private Socket socket;
	public ServerHandler(Socket socket){
		this.socket = socket;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		BufferedReader in = null;
		PrintWriter out = null;
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			String expression;
			String result = null;
			while(true){
				if((expression=in.readLine()) == null)
					break;
				System.out.println("receive" + expression);
				try {
					result = "receive" + expression;
				} catch (Exception e) {
					// TODO: handle exception
				}
				out.println(result);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			if(in != null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				in = null;
			}
			if(out != null){
				out.close();
				out = null;
			}
			if(socket != null){
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				socket = null;
			}
		}
		
	}

	
}
