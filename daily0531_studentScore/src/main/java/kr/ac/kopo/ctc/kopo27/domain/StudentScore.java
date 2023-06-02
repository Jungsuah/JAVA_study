package kr.ac.kopo.ctc.kopo27.domain;

public class StudentScore {

	private int id; // pk
	private String name; // 이름
	private int studentid; // 학번
	private int kor; // 국어
	private int eng; // 영어
	private int mat; // 수학
	private int sum = kor + eng + mat;//총점
	private int ave = (kor + eng + mat) / 3;//평균
	private int ranking;//랭킹

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public float getAve() {
		return ave;
	}

	public void setAve(int ave) {
		this.ave = ave;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	@Override
	public String toString() {
		return "StudentScore [id=" + id + ", name=" + name + ", studentid=" + studentid + ", kor=" + kor + ", eng="
				+ eng + ", mat=" + mat + ", sum=" + sum + ", ave=" + ave + ", ranking=" + ranking + "]";
	}

}
