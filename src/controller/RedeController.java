package controller;

import java.io.*;

public class RedeController {
	
	static InputStream returnn;
	static InputStreamReader reader;
	static BufferedReader buffer;
	
	public RedeController() {
		super();
	}
	
	private String operationalSystem() {
		String idSystem = System.getProperty("os.name");	
		//call JVM 
		return idSystem; 
	}
	
	public void showIpConfig () {
		String typeOS = operationalSystem();

		if (typeOS.contains("Windows")){
			
			try {
				
				Process process = Runtime.getRuntime().exec("ipconfig");
				//chama o ipconfig e recebe um processo como retorno
				returnn = process.getInputStream();
				//inputStream é a saída do processo 
				reader = new InputStreamReader(returnn);
				//lê o que está em returnn
				buffer = new BufferedReader(reader);
				String line = buffer.readLine();
				String adapter = "";
				
					while (line != null) {
						line = buffer.readLine();
						
						if (line == null) {
							break;
						} //BUG Fix: quando ELE quer, a linha vazia é lida
						
						if (line.contains("Ethernet")) {
							adapter = line;
						}
						
						if (line.contains("IPv4")) {
							System.out.println("Adapter name - " + adapter);
							System.out.println(line);
						}
					}
					
					buffer.close();
					reader.close();
					returnn.close();
					
			} catch(Exception e) {
				System.out.println(e.getMessage());}
			
		} else if (typeOS.contains("Linux")) {
			
			try {
				
				Process process = Runtime.getRuntime().exec("ip addr");
				returnn = process.getInputStream();
				reader = new InputStreamReader(returnn);
				buffer = new BufferedReader(reader);
				String line = buffer.readLine();
				
					while (line != null) {
						line = buffer.readLine();
						if (line == null) {
							break;} 
						// :(
						
						if (line.contains("inet")) {
							if (line.contains("inet6")) {continue;} 
							else {System.out.println(line);}
						}
						
						buffer.close();
						reader.close();
						returnn.close();
						
					}
			} catch(Exception e) {
				System.out.println(e.getMessage());}
		}	
	}
	
	public void executePing() {
		
		String typeOS = operationalSystem();

		
		if (typeOS.contains("Windows")){
		
			try {
				
				Process process = Runtime.getRuntime().exec("ping -4 -n 10 www.google.com.br"); 
				returnn = process.getInputStream();
				reader = new InputStreamReader(returnn);
				buffer = new BufferedReader(reader);
				String line = buffer.readLine();
				
					while (line != null) {
						line = buffer.readLine();
						if (line == null) {
							break;} 
						//:(
						
						if (line.contains("mili")) {
							line = buffer.readLine();
							String[] stats = line.split("=");
							System.out.println("Average ping time: " + stats[stats.length-1]);
						}
					}
					
					buffer.close();
					reader.close();
					returnn.close();
					
			}catch(Exception e) {
				System.out.println(e.getMessage());}
			
		} else if (typeOS.contains("Linux")) {
			
			try {
				
				Process process = Runtime.getRuntime().exec("ping -4 -c 10 www.google.com.br"); 
				returnn = process.getInputStream();
				reader = new InputStreamReader(returnn);
				buffer = new BufferedReader(reader);
				String line = buffer.readLine();
				
					while (line != null) {
						line = buffer.readLine();
						if (line == null) {
							break;
						} // :(
						
						if (line.contains("rtt")) {
							String[] allstats = line.split("=");
							String[] stats = allstats[allstats.length -1].split("/");
							System.out.println("Average ping time: " + stats[1]);}
					}
					
					buffer.close();
					reader.close();
					returnn.close();
					
			}catch(Exception e) {
				System.out.println(e.getMessage());}
		}
	}
}
