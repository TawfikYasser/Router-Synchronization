import java.util.Scanner;

public class Network {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("What is number of WI-FI Connections?");
		int N = input.nextInt();
		
		System.out.println("What is number of devices Clients want to connect?");
		int TC = input.nextInt();
		
		String [] names = new String [TC];
		String [] types = new String [TC];
		
		
		for(int i = 0; i < TC; i++) {
			
			names[i] = input.next();
			types[i] = input.next();
		}
		
	}
}
