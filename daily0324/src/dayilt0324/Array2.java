package dayilt0324;

public class Array2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] numbers = new int[3][5];
		int cnt;
		cnt = 0;
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers[i].length; j++) {
				numbers[i][j] = cnt;
				System.out.println(numbers[i][j]);
				cnt++;
			}
		}
	}

}
