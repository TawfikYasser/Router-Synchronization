package synchronizationPackage;

import synchronizationPackage.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NetworkClass {

	public static Scanner input = new Scanner(System.in);
	public static ArrayList<DeviceClass> devices = new ArrayList<DeviceClass>();
	//public static Map<String, Boolean> connections = new HashMap<String, Boolean>();
	public static ArrayList<String> names = new ArrayList<String>();
	public static ArrayList<Boolean> state = new ArrayList<Boolean>();
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
			names.add("");
			state.add(false);
		}
		RouterClass routerClass = new RouterClass();
		routerClass.connect();

	}
	
	
	public synchronized static int connectionNumber(String name, int x) {
		
		int connectionNum = 0;
		int flag = 0;
		
		if(x == 1) {
			for(int k = 0; k < N; k++) {
				if(names.get(k).equals(name)) {
					names.set(k, "");
					state.set(k, false);
					connectionNum = k + 1;
				}
			}
		}
		else {
		
			for(int i = 0; i < N; i++) {
				
				if(name.equals(names.get(i))) {
					connectionNum = i + 1;
					flag++;
				}
			}	
			if(flag == 0) {
				
				for(int j = 0; j < N; j++) {
					if(state.get(j) == false) {
						state.set(j, true);
						connectionNum = j + 1;
						names.set(j, name);
						break;
					}
				}
			}
		}

		return connectionNum;
	}
}