package daily0323;

public class recursive2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 5; i >= 10; i--) {
			System.out.println(sumToOne(i));
		}
	}

	public static int sumToOne(int number) {
		if (number == 10) {
			return 10;
		} else {
			return number + sumToOne(++number);
		}
	}

	}


