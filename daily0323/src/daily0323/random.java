package daily0323;

public class random {

	public static void main(String[] args) {
		int min = 48;
		int max = 238;
		int cnt = 0;
		int sum = 0;

		while (true) {
			int n2 = return1();
			System.out.println(n2);
			cnt++;
			sum = sum + n2;
			if (isValid(cnt, sum)) {
				break;
			}

		}

	}

//함수: 1~45 리턴해주는 함수

	public static int return1() {
		double n = 0.0;
		int n2 = 0;
		while (true) {
			n = Math.random();
			n2 = (int) (n * 46);
			if (n2 != 0) {
				break;
			}
		}
		return n2;
	}

	public static boolean isValid(int cnt, int sum) {
		boolean ret = false;
		int min = 48;
		int max = 238;
		if (cnt == 6) {
			if (sum >= min && sum <= max) {
				ret = true;
			} else {
				System.out.println("retry");
				cnt = 0;
				sum = 0;
			}
		}
		return ret;
	}

}