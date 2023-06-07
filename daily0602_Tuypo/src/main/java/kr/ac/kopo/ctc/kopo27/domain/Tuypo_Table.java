package kr.ac.kopo.ctc.kopo27.domain;

public class Tuypo_Table {
	private int id;//투표한 후보 아이디
	private int age;//투표한 사람의 연령대
	
	public int getId() {//투표한 후보 아이디를 가져다 쓰는 함수
		return id;
	}
	public void setId(int id) {//투표한 후보 아이디를 설정하는 함수
		this.id = id;
	}
	public int getAge() {//투표한 사람의 연령대를 가져다 쓰는 함수
		return age;
	}
	public void setAge(int age) {//투표한 사람의 연령대를 설정하는 함수
		this.age = age;
	}
}