package dayilt0324;

public class testreview implements testreviewrandom {

	public static void main(String[] args) {
		int cnt = 0;
		Main main = new Main();
		while (true) {
			char[] n = null;
			boolean check = main.isValid();
			if (check == true) {
				System.out.println(n);

				cnt++;
			}
			if (cnt == 6) {
				break;
			}

		}
		// TODO Auto-generated method stub

	}

	@Override
	public int getRandom() {
		int n = (int) (Math.random() * 100);
		int ret = 0;
		while (true) {

			if (n > 0) {
				ret = n;
				break;
			}
		}
		return ret;
	}

	@Override
	public boolean isValid(int num) {
		// TODO Auto-generated method stub
		boolean ret = false;
		if (num >= 1 && num <= 45) {
			ret = true;
		}
		return ret;
	}

}
