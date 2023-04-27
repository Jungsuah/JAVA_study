package daily0403_ppt2;

public class ival1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k27_iVal;// 변수 선언
		for (int k27_i = 0; k27_i < 300; k27_i++) {// 0부터 299까지 반복
			k27_iVal = 5 * k27_i;// 5씩 곱한다.
			if (k27_iVal >= 0 && k27_iVal < 10)
				System.out.printf("일 %d\n", k27_iVal);
			// k27_iVal이 0보다 크거나 작고 10보다 작은 경우 출력(두 조건을 모두 충족해야하기 때문에 &&을 쓴다.)
			else if (k27_iVal >= 10 && k27_iVal < 100)
				System.out.printf("십 %d\n", k27_iVal);
			// k27_iVal이 10보다 크거나 작고 100보다 작은 경우 출력
			else if (k27_iVal >= 100 && k27_iVal < 1000)
				System.out.printf("백 %d\n", k27_iVal);
			// k27_iVal이 100보다 크거나 작고 1000보다 작은 경우 출력
			else
				System.out.printf("천 %d\n", k27_iVal);
			// 위에 조건을 아무것도 충족 하지 못하면 출력
		}

	}

}
