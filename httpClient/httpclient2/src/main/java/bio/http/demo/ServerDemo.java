package bio.http.demo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
	private static int DEFAULT_PORT = 12345;
	private static ServerSocket socket;
	
	public static void start() throws IOException{
		start(DEFAULT_PORT);
	}
	
	public synchronized static void start(int port) throws IOException{
		
		try {
			
			socket = new ServerSocket(port);

			System.out.println("服务器已启动，端口号：" + port);
			
			while(true){
				Socket ss = socket.accept();
				new Thread(new ServerHandler(ss)).start();;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			if(socket != null){
				System.out.println("服务器已关闭。");
				socket.close();
				socket = null;
			}
		}
	}
	
}
