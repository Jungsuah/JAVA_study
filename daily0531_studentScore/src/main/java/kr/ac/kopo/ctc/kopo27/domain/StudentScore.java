package kr.ac.kopo.ctc.kopo27.domain;

public class StudentScore {

	private int id; // 학생 점수 데이터의 고유 식별자 (Primary Key)
	private String name; // 학생 이름
	private int studentid; // 학번
	private int kor; // 국어 점수
	private int eng; // 영어 점수
	private int mat; // 수학 점수
	private int sum = kor + eng + mat; // 총점
	private int ave = (kor + eng + mat) / 3; // 평균
	private int ranking; // 랭킹

	public int getId() {//아이디를 가져가서 쓸수있게 하는 getter
		return id;
	}

	public void setId(int id) {//아이디를 가져와 id에 대입하는 setter
		this.id = id;
	}

	public String getName() {//이름 가져가서 쓸수있게 하는 getter
		return name;
	}

	public void setName(String name) {//이름 가져와서 쓸수있게 하는 setter
		this.name = name;
	}

	public int getStudentid() {//학생 학번을 가져옵니다.
		return studentid;
	}

	public void setStudentid(int studentid) {//학생 학번을 설정합니다.
		this.studentid = studentid;
	}

	public int getKor() {//국어 점수를 가져옵니다.
		return kor;
	}

	public void setKor(int kor) {//국어 점수를 설정합니다.
		this.kor = kor;
	}

	public int getEng() {//영어 점수를 가져옵니다.
		return eng;
	}

	public void setEng(int eng) {//영어 점수를 설정합니다.
		this.eng = eng;
	}

	public int getMat() {//수학 점수를 가져옵니다.
		return mat;
	}

	public void setMat(int mat) {//수학 점수를 설정합니다.
		this.mat = mat;
	}

	public int getSum() {//총점을 가져옵니다.
		return sum;
	}

	public void setSum(int sum) {//총점을 설정합니다.
		this.sum = sum;
	}

	public float getAve() {//평균을 가져옵니다.
		return ave;
	}

	public void setAve(int ave) {//평균을 설정합니다.
		this.ave = ave;
	}

	public int getRanking() {//랭킹을 가져옵니다.
		return ranking;
	}

	public void setRanking(int ranking) {//랭킹을 설정합니다.
		this.ranking = ranking;
	}

}