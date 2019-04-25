package bio.http.demo2;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class IOServer {
	public static void main(String[] args) throws IOException{
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					ServerSocket serverSocket = new ServerSocket(2233);
					System.out.println("server start");
					while(true){
						Socket socket = serverSocket.accept();
						new Thread(new RunnableImp(socket)).start();;
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}).start();
	}
}
