package java_intensive;

public class Calc implements Calculator{
	public static final double PI = 3.14;//상수 - 값이 바뀌지 않음
	private int memory;
	
//	public int add(int a, int b) {
//		int sum = a + b;
//		this.memory = sum;
//		return sum;
//	}
	
	public static double getCircleLenth(double r) {//객체 입장에서 전역적으로 사용되는 값이면 static으로 선언해서 사용
		return 2 * PI * r;
//		Calc.PI //Calc가 생략된 것이다
	}
	
	public int getMemory() {
		return memory;
	}
	public void setMemory(int memory) {
		this.memory = memory;
	}

	@Override
	public int add(int a, int b) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
