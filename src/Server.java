
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
						storage.setPlayer1X(in.readFloat());
						storage.setPlayer1Y(in.readFloat());
						storage.setPlayer1Health(in.readInt());
						storage.setPlayer2Health(in.readInt());
						storage.setPlayer1XMove(in.readFloat());
						storage.setPlayer1YMove(in.readFloat());
					}else if(id == 2) {
						storage.setPlayer2X(in.readFloat());
						storage.setPlayer2Y(in.readFloat());
						storage.setPlayer2Health(in.readInt());
						storage.setPlayer1Health(in.readInt());
						storage.setPlayer2XMove(in.readFloat());
						storage.setPlayer2YMove(in.readFloat());
					}
					int size = in.readInt();
					for(int i = 1; i < size; i++) {
						if(storage.getEntityState().size() >= size) {
							storage.getEntityState().set(in.read(), in.read());
						}else {
							in.read();
							storage.getEntityState().add(in.read());
						}
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
