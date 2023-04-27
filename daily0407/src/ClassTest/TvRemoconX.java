package ClassTest;

public class TvRemoconX extends TvRemocon2_k27 {
	int battery;//숫자변수선언
	int maxBattery = 100;//최대배터리변수선언
	int warnBattery = 50;//최소배터리변수선언
	String warn;//경고출력할 문자열 선언

	public TvRemoconX() {
	}//기본생성자
	
	public TvRemoconX(int battery) {// 배터리를 받아서 값을 세팅하기
		this.battery = battery;//배터리값을 받아서 클래스내에 변수에 넣기
		System.out.println("현재 세팅된 배터리양 : " + this.battery);//설정된 배터리 출력
	}

	void checkBattery() {//배터리 체크하는 메소드 생성
		if (battery <= 100 && battery >= 50) {//50에서 100사이에 배터리가 존재하면
			warn = String.format("건전지 교체가 필요하지 않습니다.");//경고문 출력변수에 넣기
		} else {
			warn = String.format("건전지 교체가 필요합니다.");//경고문 출력변수에 넣기
		}
		System.out.println(warn);//경고문 출력
	}
}
