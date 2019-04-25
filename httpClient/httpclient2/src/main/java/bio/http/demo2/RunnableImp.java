package bio.http.demo2;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class RunnableImp implements Runnable{
	
	private Socket socket;
	public RunnableImp(Socket socket){
		this.socket = socket;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			byte[] data = new byte[1024];
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			int len;
			while((len = in.read(data)) > 0){
				System.out.println(Thread.currentThread().getName());
				System.out.println(new String(data,0,len));
				System.out.println((Thread.currentThread().getName() + "receive"));
				out.write((Thread.currentThread().getName() + "receive").getBytes());
			}
			
		}catch(Exception e){
			
		}finally{
		}
		
	}
	
	
}
