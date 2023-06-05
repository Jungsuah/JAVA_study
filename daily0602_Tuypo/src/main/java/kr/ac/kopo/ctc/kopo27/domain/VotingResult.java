package kr.ac.kopo.ctc.kopo27.domain;

public class VotingResult {// 원하는 쿼리 값을 한번에 출력하기 위한 domain 생성
	private int id;// 후보 아이디
	private int ageGroup;// 투표한 사람 연령대
	private String name;// 후보 이름
	private int voteCount;// 득표수
	private double votePercentage;// 득표율

	public int getAgeGroup() {// 투표한 사람 연령대를 가져다쓰는 함수
		return ageGroup;
	}

	public void setAgeGroup(int ageGroup) {// 투표한 사람 연령대를 설정하는 함수
		this.ageGroup = ageGroup;
	}

	public int getId() {// 후보 아이디 가져다쓰는 함수
		return id;
	}

	public void setId(int id) {// 후보 아이디 설정하는 함수
		this.id = id;
	}

	public String getName() {// 후보 이름 가져다쓰는 함수
		return name;
	}

	public void setName(String name) {// 후보 이름 설정하는 함수
		this.name = name;
	}

	public int getVoteCount() {// 득표수를 가져다 쓰는 메소드
		return voteCount;
	}

	public void setVoteCount(int voteCount) {// 득표수를 설정하는 메소드
		this.voteCount = voteCount;
	}

	public double getVotePercentage() {// 득표율을 가져다 쓰는 메소드
		return votePercentage;
	}

	public void setVotePercentage(double votePercentage) {// 득표율을 설정하는 메소드
		this.votePercentage = votePercentage;
	}
}
