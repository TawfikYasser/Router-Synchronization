package synchronizationPackage;

import java.util.Map;
import java.util.Random;

import synchronizationPackage.*;

public class RouterClass implements Runnable {

	NetworkClass networkClass = new NetworkClass();

	SemaphoreClass semaphoreClass;

	public RouterClass() {
		semaphoreClass = new SemaphoreClass(networkClass.N);
	}

	public void connect() throws InterruptedException {

		for (int i = 0; i < networkClass.devices.size(); i++) {
			Thread t = new Thread(this, networkClass.devices.get(i).getName());
			t.start();

		}

	}

	public void disConnect() throws InterruptedException {

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Random random = new Random();
		try {

			semaphoreClass.reserve(Thread.currentThread().getName());
			System.out.println(
					"Connection " + semaphoreClass.getBound() + ": " + Thread.currentThread().getName() + " Occupied");
			Thread.currentThread().sleep(1000);
			System.out.println("Connection " + semaphoreClass.getBound() + ": " + Thread.currentThread().getName()
					+ " Performs online activity");
			Thread.currentThread().sleep((random.nextInt(5) + 1) * 1000);
			semaphoreClass.release(Thread.currentThread().getName());

			Thread.currentThread().stop();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
