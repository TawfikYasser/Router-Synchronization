package synchronizationPackage;

import synchronizationPackage.*;

public class SemaphoreClass {
	public Integer bound = 0;

	public SemaphoreClass(Integer bound) {
		// TODO Auto-generated constructor stub
		this.bound = bound;
	}

	public synchronized void reserve(String name) throws InterruptedException {
		bound--;
		if (bound < 0) {
			System.out.println(name + " Arrived and waiting");
			wait();
		} else {

			System.out.println(name + " Arrived");
		}

	}

	public synchronized void release(String name) {
		bound++;
		if (bound <= 0)
			notify();
		
		System.out.println("Connection " + NetworkClass.connectionNumber(name, 1) + ": " + name + " Logged out");
		
	}

	public Integer getBound() {
		return bound;
	}

	public void setBound(Integer bound) {
		this.bound = bound;
	}
}