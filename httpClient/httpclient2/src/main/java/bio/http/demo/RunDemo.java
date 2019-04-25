package bio.http.demo;

import java.util.Scanner;

import org.apache.http.impl.bootstrap.ServerBootstrap;

public class RunDemo {
	public static void main(String[] args) throws InterruptedException{
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					ServerDemo.start();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}).start();
		Thread.sleep(1000);
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				String s = "ssssssssss";
				
				ClientDemo.send(s);
			}
		}).start();

	}
}
