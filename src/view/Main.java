package view;

import controller.RedeController;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int option = 0;
		String menu = """
				
						Choose an option
						
						1 - Show IPv4 address
						2 - Test average ping
						9 - Exit
						
				""";
		
		RedeController controll = new RedeController();
		Scanner scan = new Scanner(System.in);
		
		while (option != 9) {
			
			System.out.println(menu);
			option = scan.nextInt();
			
			switch (option) {
			
			case 1:
				controll.showIpConfig();
				break;
			case 2:
				controll.executePing();
				break;
			case 9:
				System.out.println("Exiting...");
				break;
			} 
		}
		
		scan.close();
	}
}

//My first code written in English 