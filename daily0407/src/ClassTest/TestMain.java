package ClassTest;

public class TestMain {
	private static int inVal;//클래스에서만 사용할수있는 숫자형 변수 선언

	public static void up() {//static 메소드 up 생성
		inVal++;//호출되면 무조건 inVal+1
		System.out.printf("난 그냥 메소드[%d]\n", inVal);//+1된 inVal를 출력
	}

	public static void main(String[] args) {//메인부
		inVal = 0;//static 변수 inVal 0으로 초기화
		Elevator elev = new Elevator();//Elevator 객체 생성

		up();//TestMain에 있는 up 메소드 호출

		for (int i = 0; i < 10; i++) {//0 - 9까지 10번 반복
			elev.up(); // 생성한 Elevator 객체에 있는 메소드 up을 호출
			System.out.printf("MSG[%s]\n", elev.help);//up메소드로 만들어진 문자열 help 출력 
		}

		for (int i = 0; i < 10; i++) {//0 - 9까지 10번 반복
			elev.down();// 생성한 Elevator 객체에 있는 메소드 down을 호출
			System.out.printf("MSG[%s]\n", elev.help);//up메소드로 만들어진 문자열 help 출력 
		}
	}
}
