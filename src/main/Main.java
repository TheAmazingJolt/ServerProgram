package main;
import java.net.InetAddress;
import java.util.ArrayList;

import worlds.World;

public class Main {

	private static Storage storage = new Storage();
	private Display display;
	
	private ArrayList<Server> servers = new ArrayList<Server>();
	private ArrayList<Client> clients = new ArrayList<Client>();
	
	private static int port1 = 5000;
	private static int port2 = 5001;
	private static int port3 = 5002;
	private static int port4 = 5003;
	private static String ip1 = getIp();
	private static String ip2 = "";
	
	private static long tickCount = 0;
	
	private static World world1;
	private static World world2;
	
	public static void main(String[] args) {
		Display display = new Display();
	}

	public Main() {
		Server server1 = new Server(port1, storage, 1);
		Client client1 = new Client(ip1, port3, storage, 1);
		world1 = new World("res/worlds/world1.txt", storage, 1);
		world1.setCurrentWorld(1);
		System.out.println("a");
		if(server1.isActive()) {
			Server server2 = new Server(port2, storage, 2);
			Client client2 = new Client(ip2, port4, storage, 2);
			world2 = new World("res/worlds/world1.txt", storage, 2);
			world2.setCurrentWorld(1);
			servers.add(server1);
			servers.add(server2);
			clients.add(client1);
			clients.add(client2);
			while(server1.isActive() && server2.isActive()) {
				tickCount++;
				world1.tick();
				world2.tick();
				for(int i = 0; i < servers.size(); i++) {
					//System.out.println("Server Tick " + tickCount);
					servers.get(i).tick();
				}
				for(int i = 0; i < clients.size(); i++) {
					//System.out.println("Client Tick " + tickCount);
					clients.get(i).tick();
				}
			}
		}
	}
	
	public static String getIp() {
		String ip = "";
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (java.net.UnknownHostException e) {
			e.printStackTrace();
		}
		return ip;
	}
	
	public static void setPort1(int port) {
		port1 = port;
	}

	public static void setPort2(int port) {
		port2 = port;
	}

	public static void setPort3(int port) {
		port3 = port;
	}

	public static void setPort4(int port) {
		port4 = port;
	}

	public ArrayList<Server> getServers() {
		return servers;
	}

	public ArrayList<Client> getClients() {
		return clients;
	}

	public static void setIp1(String ip1) {
		Main.ip1 = ip1;
	}

	public static void setIp2(String ip2) {
		Main.ip2 = ip2;
	}
	
}
