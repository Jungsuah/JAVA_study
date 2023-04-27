package daily0405;

public class sss {
	public static void main(String[] args) {
		int k27_iNumVal = 200000000;// 변수 선언 및 초기화
		String k27_sNumVal = String.valueOf(k27_iNumVal);// string 변수로 사용하기 위해 string.valueOf을 써줌 (10자리)
		String k27_sNumVoice = "";// 변수 선언 및 초기화
		System.out.printf(" ==> %s [%d자리]\n", k27_sNumVal, k27_sNumVal.length());// k27_sNumVal와 자릿수 출력

		int k27_i, k27_j;// 변수 선언
		String[] k27_units = { "영", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구" };// 배열 선언
		String[] k27_unitX = { "", "십", "백", "천", "만", "십", "백", "천", "억", "십" };// 배열 선언

		k27_i = 0;// 숫자 자릿수
		k27_j = k27_sNumVal.length() - 1;// k27_sNumval의 길이에서 하나 빼준 값을 대입(9)

		while (true) {
			if (k27_i >= k27_sNumVal.length())// k27_i가 k27_sNumVal길이(10)보다 크거나 같으면 break;
				break;

			System.out.printf("%s[%s]", k27_sNumVal.substring(k27_i, k27_i + 1),
					// substring으로 k27_i에서 k27_i + 1 자릿수 전까지를 잘라서 출력
					k27_units[Integer.parseInt(k27_sNumVal.substring(k27_i, k27_i + 1))]);
			// int형으로 형변환한 값을 k27_units의 인덱스 값으로 넣어줌
			if (k27_iNumVal == 0 && k27_sNumVal.length() == 1) {
				k27_sNumVoice = k27_units[0];
				break;
			}
			if (k27_sNumVal.substring(k27_i, k27_i + 1).equals("0")) {
				// 해당 자리수가 0이랑 같으면
				if (k27_unitX[k27_j].equals("억") || k27_unitX[k27_j].equals("만")) {
					// k27_unitX의 해당 인덱스에 억이나 만이 있으면
					if (k27_i > 2 && k27_sNumVal.substring(k27_i - 3, k27_i).equals("000")) {
						// k27_i > 2를 하는 이유는 k27_i - 3을 할 때 범위를 벗어나지 않게 하기위해서
						// k27_i - 3에서 k27_i전까지 잘라서 그 값이 000이면
						k27_sNumVoice = k27_sNumVoice + "";// ""을 누적
					} else {
						k27_sNumVoice = k27_sNumVoice + "" + k27_unitX[k27_j];// 아니면 이 값 누적
					}
				} else {
					// 아무짓도 안 함

				}
			} else {
				k27_sNumVoice = k27_sNumVoice + k27_units[Integer.parseInt(k27_sNumVal.substring(k27_i, k27_i + 1))]
						+ k27_unitX[k27_j];// 누적
			}
			k27_i++;// 자릿수를 하나 늘려줌
			k27_j--;// 자릿수를 하나 줄여줌

		}

		System.out.printf("\n %s[%s]\n", k27_sNumVal, k27_sNumVoice);// 누적된 값 출력
	}
}
