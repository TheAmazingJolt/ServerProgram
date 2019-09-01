package main;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.rmi.UnknownHostException;

public class Client {
	
	private Socket socket = null;
	private DataOutputStream out = null;
	private boolean active = false;
	private int id;
	
	private Storage storage;
	private Timer timer;
	
	public Client(String address, int port, Storage stor, int id) {
		this.id = id;
		this.storage = stor;
		try {
			socket = new Socket(address, port);
			System.out.println("Connected");
			
			out = new DataOutputStream(socket.getOutputStream());
		}catch(UnknownHostException u){
			u.printStackTrace();
		}catch(IOException i) {
			i.printStackTrace();
		}
		
		active = true;
		
	}
	
	public void tick() {
		if(active) {
//			try {
//				if(timer == null) {
//					timer = new Timer(25, 1);
//				}else if(timer != null && !timer.isCompleted()) {
//					timer.tick();
//				}else if(timer != null && timer.isCompleted()) {
//					if(id == 1) {
//						out.writeFloat(storage.getPlayer2X());
//						out.writeFloat(storage.getPlayer2Y());
//						out.writeInt(storage.getPlayer2Health());
//						out.writeInt(storage.getPlayer1Health());
//						out.writeFloat(storage.getPlayer2XMove());
//						out.writeFloat(storage.getPlayer2YMove());
//					}else if(id == 2) {
//						out.writeFloat(storage.getPlayer1X());
//						out.writeFloat(storage.getPlayer1Y());
//						out.writeInt(storage.getPlayer1Health());
//						out.writeInt(storage.getPlayer2Health());
//						out.writeFloat(storage.getPlayer1XMove());
//						out.writeFloat(storage.getPlayer1YMove());
//					}
//					out.write(storage.getEntityState().size());
//					for(int i : storage.getEntityState()) {
//						out.write(i);
//					}
//					timer = null;
//				}
//				return;
//			} catch (IOException e) {
//				e.printStackTrace();
//				return;
//			}
			return;
		}
//		
		try {
			out.close();
			socket.close();
		}catch(IOException i) {
			i.printStackTrace();
		}
	}

	public boolean isActive() {
		return active;
	}
	
}
