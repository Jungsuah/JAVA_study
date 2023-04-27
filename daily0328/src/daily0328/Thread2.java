package daily0328;

public class Thread2 {

	public static void main(String[] args) {

		while (true) {
			int num = (int) (Math.random() * 45);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(num);

		}

	}

}
