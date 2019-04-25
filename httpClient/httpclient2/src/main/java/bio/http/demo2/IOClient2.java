package bio.http.demo2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

import javax.xml.crypto.Data;

public class IOClient2 {
	public static void main(String[] args){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					System.out.println("client start");
					//创建socket
					Socket socket = new Socket("127.0.0.1", 2233);
					//输出流
					InputStream in = socket.getInputStream();
					OutputStream out = socket.getOutputStream();
					while(true){
						Date date = new Date();
						String s = "hello world" + date.toString();
						out.write(s.getBytes());
						byte[] readd = new byte[100];
						in.read(readd);
						System.out.println(new String(readd));
						Thread.sleep(2000);
					}
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}).start();
	}
}
