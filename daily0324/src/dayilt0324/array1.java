package dayilt0324;

public class array1 {

	public static void main(String[] args) {
		int[] numbers = new int[10];
		String[] name = { "kim", "lee", "park" };

		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
		for (int i = 0; i < name.length; i++) {
			try {
				System.out.println(name[2]);
			} catch (Exception e) {
				System.out.println("Error");
			}
			System.out.println(name[i]);

		}

	}

}
