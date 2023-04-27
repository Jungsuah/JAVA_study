package ClassTest;

public class Elevater3 extends Elevator2 {//자바는 단일상속만 가능! 
	//Elevater3는 Elevator2를 상속했기때문에 더이상 상속 불가!
	
	//새로운 메소드 정의
	void Repair() {
		help = String.format("수리중입니다");
	}
}
