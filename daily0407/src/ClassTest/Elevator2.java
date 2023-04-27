package ClassTest;

public class Elevator2 {
	//Elevator2 안에서만 사용하는 private 전역 변수 
	private int limit_up_floor = 10;
	private int limit_down_floor = 0;
	private int floor = 1;
	public String help;
	
	//기본 생성자 생성
	Elevator2() {//들어오는 인자값이 없어서 생성자 안에서 값을 넣어준다.
		limit_up_floor = 10;
		limit_down_floor = 1;
		floor = 1;
		help = "엘리베이터 기본 준공완료";
	}

	//인자를 가지는 생성자 생성 -> 최대층.최소층.내가있는층을 맞춤으로 세팅해준다
	Elevator2(int up_floor, int d_floor, int in_floor) {
		limit_up_floor = up_floor;
		limit_down_floor = d_floor;
		floor = d_floor;
		help = "엘리베이터 맞춤 준공완료";
	}

	//층을 올라가는 메소드
	void up() {
		if (floor == limit_up_floor) {
			help = "마지막층입니다.";
		} else {
			floor++;
			help = String.format("[%d] 층입니다", floor);
		}
	}

	//층을 내려가는 메소드
	void down() {
		if (floor == limit_down_floor) {
			help = "처음층입니다.";
		} else {
			floor--;
			help = String.format("[%d] 층입니다", floor);
		}
	}

	//up메소드와 이름은 같지만 인자값을 다르게 가지는 메소드 -> 오버로딩
	void up(int u) {//층수가 인자로 들어오면
		for (int i = 0; i < u; i++) {
			this.up();//해당 층수까지 올라가는 메소드 호출
		}
	}

	//down메소드와 이름은 같지만 인자값을 다르게 가지는 메소드 -> 오버로딩
	void down(int u) {//층수가 인자로 들어오면
		for (int i = 0; i < u; i++) {
			down();//해당 층수까지 올라가는 메소드 호출
		}
	}

	void msg(String id) {//아이디 값을 받았을때 Elevator2 클래스 안에 변수 정보를 출력하는 메소드
		System.out.printf("%s=>[%s]  최대층[%d] 최소층[%d] 현재층[%d]\n", id, help, limit_up_floor, limit_down_floor, floor);
	}

}
