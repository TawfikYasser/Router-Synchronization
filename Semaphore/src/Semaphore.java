
public class Semaphore {
	private Integer connections = 0;
	private Integer bound = 0;

	public Semaphore(Integer bound) {
		// TODO Auto-generated constructor stub
		this.bound = bound;
	}

	public synchronized void reserve() throws InterruptedException {
		if (connections < bound) {
			connections++;
		} else {
			wait();
		}
	}

	public synchronized void release() {
		connections--;
		notify();
	}
}
