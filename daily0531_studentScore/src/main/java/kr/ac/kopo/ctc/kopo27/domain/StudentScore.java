package kr.ac.kopo.ctc.kopo27.domain;

public class StudentScore {

	private int id; // pk
	private String name; // �̸�
	private int studentid; // �й�
	private int kor; // ����
	private int eng; // ����
	private int mat; // ����
	private int sum = kor + eng + mat;//����
	private int ave = (kor + eng + mat) / 3;//���
	private int ranking;//��ŷ

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
