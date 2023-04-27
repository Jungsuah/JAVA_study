package daily0328;

public class Main implements Runnable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Main main = new Main();
		Thread thread = new Thread(main);
		thread.start();
	}
	@Override
	public void run() {
		System.out.println("Thread");
	}
}
