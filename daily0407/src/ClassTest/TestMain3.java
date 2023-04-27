package ClassTest;

public class TestMain3 extends Calc2 {//상속을 해서 메소드를 사용할수 있게 만들기
	public static void main(String[] args) {
		Calc2 cc = new Calc2();// 메소드를 가져오기 위해 객체 생성

		System.out.println("3월 성적표");//출력
		System.out.println("======================================================");//줄나누기
		System.out.println("이름   국어   영어   수학   총점   평균");//출력
		System.out.println("======================================================");//줄나누기
		System.out.printf("폴리융  %3d    %3d    %3d    %3d    %3d", 100, 100, 100, cc.sum(100, 100, 100),
				cc.avg(100, 100, 100));//상속을 통해 Calc2의 메소드를 사용할수있음
		System.out.println();
		System.out.println();
		System.out.println("4월 성적표");//출력
		System.out.println("======================================================");//줄나누기
		System.out.println("이름   국어   영어   수학   과학   총점   평균");//출력
		System.out.println("======================================================");//줄나누기
		System.out.printf("폴리융  %3d    %3d    %3d    %3d    %3d   %.1f", 100, 100, 100, 100, cc.sum(100, 100, 100, 100),
				cc.avg(100, 100, 100, 100));//상속을 통해 Calc2의 메소드를 사용할수있음
		System.out.println();
		System.out.println();
		System.out.println("5월 성적표");//출력
		System.out.println("======================================================");//줄나누기
		System.out.println("이름   국어   영어   수학   과학   사회   총점   평균");//출력
		System.out.println("======================================================");//줄나누기
		System.out.printf("폴리융  %3d    %3d    %3d    %3d    %3d    %3d   %.1f", 100, 100, 100, 100, 100,
				cc.sum(100, 100, 100, 100, 100), cc.avg(100, 100, 100, 100, 100));//상속을 통해 Calc2의 메소드를 사용할수있음

	}
}
