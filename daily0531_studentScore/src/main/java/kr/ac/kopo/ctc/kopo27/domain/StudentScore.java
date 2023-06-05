package kr.ac.kopo.ctc.kopo27.domain;

public class StudentScore {

	private int id; // �л� ���� �������� ���� �ĺ��� (Primary Key)
	private String name; // �л� �̸�
	private int studentid; // �й�
	private int kor; // ���� ����
	private int eng; // ���� ����
	private int mat; // ���� ����
	private int sum = kor + eng + mat; // ����
	private int ave = (kor + eng + mat) / 3; // ���
	private int ranking; // ��ŷ

	public int getId() {//���̵� �������� �����ְ� �ϴ� getter
		return id;
	}

	public void setId(int id) {//���̵� ������ id�� �����ϴ� setter
		this.id = id;
	}

	public String getName() {//�̸� �������� �����ְ� �ϴ� getter
		return name;
	}

	public void setName(String name) {//�̸� �����ͼ� �����ְ� �ϴ� setter
		this.name = name;
	}

	public int getStudentid() {//�л� �й��� �����ɴϴ�.
		return studentid;
	}

	public void setStudentid(int studentid) {//�л� �й��� �����մϴ�.
		this.studentid = studentid;
	}

	public int getKor() {//���� ������ �����ɴϴ�.
		return kor;
	}

	public void setKor(int kor) {//���� ������ �����մϴ�.
		this.kor = kor;
	}

	public int getEng() {//���� ������ �����ɴϴ�.
		return eng;
	}

	public void setEng(int eng) {//���� ������ �����մϴ�.
		this.eng = eng;
	}

	public int getMat() {//���� ������ �����ɴϴ�.
		return mat;
	}

	public void setMat(int mat) {//���� ������ �����մϴ�.
		this.mat = mat;
	}

	public int getSum() {//������ �����ɴϴ�.
		return sum;
	}

	public void setSum(int sum) {//������ �����մϴ�.
		this.sum = sum;
	}

	public float getAve() {//����� �����ɴϴ�.
		return ave;
	}

	public void setAve(int ave) {//����� �����մϴ�.
		this.ave = ave;
	}

	public int getRanking() {//��ŷ�� �����ɴϴ�.
		return ranking;
	}

	public void setRanking(int ranking) {//��ŷ�� �����մϴ�.
		this.ranking = ranking;
	}

}
