package synchronizationPackage;

import java.io.IOException;

import synchronizationPackage.*;

public class SemaphoreClass {
	public Integer bound = 0;

	public SemaphoreClass(Integer bound) {
		// TODO Auto-generated constructor stub
		this.bound = bound;
	}

	public synchronized void reserve(String name) throws InterruptedException, IOException {
		bound--;
		if (bound < 0) {
			int g = 0;
			for (int i = 0; i < NetworkClass.devices.size(); i++) {
				if (NetworkClass.devices.get(i).getName().equals(name)) {
					g = i;
					break;
				}
			}
			System.out.println(name + " ( " + NetworkClass.devices.get(g).getType() + " )" + " Arrived and waiting");
			FileClasse fileClasse = new FileClasse(
					name + " ( " + NetworkClass.devices.get(g).getType() + " )" + " Arrived and waiting" + " ");
			wait();
		} else {
			int g = 0;
			for (int i = 0; i < NetworkClass.devices.size(); i++) {
				if (NetworkClass.devices.get(i).getName().equals(name)) {
					g = i;
					break;
				}
			}
			System.out.println(name + " ( " + NetworkClass.devices.get(g).getType() + " )" + " Arrived");
			FileClasse fileClasse3 = new FileClasse(
					name + " ( " + NetworkClass.devices.get(g).getType() + " )" + " Arrived" + " ");

		}

	}

	public synchronized void release(String name) throws IOException {
		bound++;
		if (bound <= 0)
			notify();

		System.out.println("- Connection " + NetworkClass.connectionNumber(name, 1) + ": " + name + " Logged out");
		FileClasse fileClasse4 = new FileClasse(
				"- Connection " + NetworkClass.connectionNumber(name, 1) + ": " + name + " Logged out" + " ");

	}

	public Integer getBound() {
		return bound;
	}

	public void setBound(Integer bound) {
		this.bound = bound;
	}
}