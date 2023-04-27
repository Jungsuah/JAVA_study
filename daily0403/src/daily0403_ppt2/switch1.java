package daily0403_ppt2;

public class switch1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String k27_jumin = "123456-1234567";// 변수 선언
		switch (k27_jumin.charAt(7)) {
		case '1':
			System.out.printf("20세기전 태어난 남자 사람\n");// 7번째 자릿 수가 1일 때
		case '2':
			System.out.printf("20세기전 태어난 여자 사람\n");// 7번째 자릿 수가 2일 때
			break;// switch 문을 나간다.
		case '3':
			System.out.printf("20세기전 태어난 남자 사람\n");// 7번째 자릿 수가 3일 때
			break;// switch 문을 나간다.
		case '4':
			System.out.printf("20세기전 태어난 여자 사람\n");// 7번째 자릿 수가 4일 때
			break;// switch 문을 나간다.
		default:
			System.out.printf("사람\n");// 다 아닐 때
			break;// switch 문을 나간다.

		// case '1'에 break문이 없으므로 case2까지 출력하고 나간다.
		}
	}

}
