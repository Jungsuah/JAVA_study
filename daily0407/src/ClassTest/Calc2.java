package ClassTest;

public class Calc2 {
	
	public int sum(int a, int b, int c) {//인자 3개받아서 덧셈하는 메소드
		return a + b + c;//리턴
	}

	public int sum(int a, int b, int c, int d) {//인자 4개받아서 덧셈하는 메소드
		return a + b + c + d;//리턴
	}

	public int sum(int a, int b, int c, int d, int e) {//인자 5개받아서 덧셈하는 메소드
		return a + b + c + d + e;//리턴
	}

	public int avg(int a, int b, int c) {//인자 3개받아서 평균을 구하는 메소드
		return (int)(a + b + c) / 3;//리턴
	}

	public double avg(int a, int b, int c, int d) {//인자 4개받아서 평균을 구하는 메소드
		return (a + b + c + d) / 4;//리턴
	}

	public double avg(int a, int b, int c, int d, int e) {//인자 5개받아서 평균을 구하는 메소드
		return (a + b + c + d + e) / 5;//리턴
	}
}
