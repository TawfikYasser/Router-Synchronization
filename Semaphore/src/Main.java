
public class Main {
	public static void main(String[] args) throws InterruptedException {
		Semaphore semaphore = new Semaphore(4);
		semaphore.reserve();
	}
}
