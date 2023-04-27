package dayilt0324;

import java.util.Arrays;
import java.util.Collections;


public class sor2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] temp = { 2, 33, 7, 5, 12, 34, 99, 25, 53, 20 };
		Arrays.sort(temp);
		for (int i = 0; i < temp.length; i++) {
			System.out.println(temp[i]);
		}
		System.out.println("==================");
		Arrays.sort(temp, Collections.reverseOrder());
		for (int i = 0; i < temp.length; i++) {
			System.out.println(temp[i]);
		}

	}
}
