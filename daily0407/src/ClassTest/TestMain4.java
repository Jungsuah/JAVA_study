package ClassTest;

public class TestMain4 {

	public static void main(String[] args) {
		Elevater3 elev3 = new Elevater3();

		for (int i = 0; i < 10; i++) {
			elev3.up();
			System.out.printf("MSG elev3 %s\n", elev3.help);
		}
		System.out.println();
		
		for (int i = 0; i < 10; i++) {
			elev3.down();
			System.out.printf("MSG elev3 %s\n", elev3.help);
		}
		System.out.println();

		elev3.Repair();
		System.out.printf("MSG elev3 %s\n", elev3.help);
	}
}
