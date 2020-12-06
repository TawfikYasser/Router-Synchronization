package synchronizationPackage;

import synchronizationPackage.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NetworkClass {

	public static Scanner input = new Scanner(System.in);
	public static ArrayList<DeviceClass> devices = new ArrayList<DeviceClass>();
	public static Map<Integer, Boolean> connections = new HashMap<Integer, Boolean>();
	static int N;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.out.println("What is number of WI-FI Connections?");
		N = input.nextInt();

		System.out.println("What is number of devices clients want to connect?");
		int TC = input.nextInt();

		String name = "";
		String type = "";

		for (int i = 0; i < TC; i++) {

			name = input.next();
			type = input.next();

			devices.add(new DeviceClass(name, type));
		}

		for (int j = 0; j < N; j++) {
			connections.put((j+1), false);
		}
		RouterClass routerClass = new RouterClass();
		routerClass.connect();

	}
	
	
	public synchronized static int connectionNumber() {
		int i = 0;
		for (Map.Entry<Integer, Boolean> entry : NetworkClass.connections.entrySet()) {

			if (entry.getValue() == false) {
				entry.setValue(true);
				i = entry.getKey();
				break;
			}

		}

		return i;
	}

}