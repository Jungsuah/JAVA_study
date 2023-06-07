package kr.ac.kopo.ctc.kopo27.domain;

public class Hubo_Table {
	private int id;//후보 아이디
	private String name;//후보 이름
	
	public int getId() {//후보 아이디 가져다쓰는 함수
		return id;
	}
	public void setId(int id) {//후보 아이디 설정하는 함수
		this.id = id;
	}
	public String getName() {//후보 이름 가져다쓰는 함수
		return name;
	}
	public void setName(String name) {//후보 이름 설정하는 함수
		this.name = name;
	}
}

