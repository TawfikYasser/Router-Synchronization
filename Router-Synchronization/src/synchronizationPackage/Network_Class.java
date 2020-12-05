package synchronizationPackage;
import java.util.ArrayList;
import java.util.Scanner;

public class Network_Class {

	
	public static Scanner input = new Scanner(System.in);
	public static ArrayList<Device> devices = new ArrayList<Device>();

	
	
	public Network_Class() {}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		
		System.out.println("What is number of WI-FI Connections?");
		int N = input.nextInt();
		
		System.out.println("What is number of devices clients want to connect?");
		int TC = input.nextInt();
		
		String name = "";
		String type = "";
		
		
		for(int i = 0; i < TC; i++) {
			
			name= input.next();
			type= input.next();
			
			devices.add(new Device(name, type));
		}
		
		
		devices.forEach(elements ->{
			
			System.out.println(elements.getName()+ " - "+elements.getType());
			
		});
		
		
	}

}
