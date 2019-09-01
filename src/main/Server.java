package main;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private Socket socket = null;
	private ServerSocket server = null;
	private DataInputStream in = null;
	private boolean active = false;
	private int id;
	
	private Storage storage;
	private Timer timer;
	
	public Server(int port, Storage stor, int id) {
		this.id = id;
		this.storage = stor;
		try {
			server = new ServerSocket(port);
			System.out.println("Server Started");
			
			System.out.println("Waiting For A Connection");
			
			socket = server.accept();
			System.out.println("Client Accepted");
			
			in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			
		}catch(IOException i) {
			i.printStackTrace();
		}
		
		active = true;
		
	}
	
	public void tick() {
		if(active) {
			try {
				if(timer == null) {
					timer = new Timer(25, 1);
				}else if(timer != null && !timer.isCompleted()) {
					timer.tick();
				}else if(timer != null && timer.isCompleted()) {
					if(id == 1) {
						storage.setCurrentKey1(in.readUTF());
						storage.setCurrentMousePress1(in.readUTF());
						storage.setMouseX1(in.readFloat());
						storage.setMouseY1(in.readFloat());
						storage.setCameraXOffset1(in.readFloat());
						storage.setCameraYOffset1(in.readFloat());
					}else if(id == 2) {
						storage.setCurrentKey2(in.readUTF());
						storage.setCurrentMousePress2(in.readUTF());
						storage.setMouseX2(in.readFloat());
						storage.setMouseY2(in.readFloat());
						storage.setCameraXOffset2(in.readFloat());
						storage.setCameraYOffset2(in.readFloat());
					}
					timer = null;
				}
				return;
			}catch(IOException i) {
				i.printStackTrace();
				return;
			}
		}
		
		active = false;
		
		try {
			socket.close();
			in.close();
		}catch(IOException i) {
			i.printStackTrace();
		}
		
		System.out.println("Closing Connection");
	}
	
	public boolean isActive() {
		return active;
	}

}
