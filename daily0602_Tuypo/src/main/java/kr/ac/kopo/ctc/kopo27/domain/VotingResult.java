package kr.ac.kopo.ctc.kopo27.domain;

public class VotingResult {// ���ϴ� ���� ���� �ѹ��� ����ϱ� ���� domain ����
	private int id;// �ĺ� ���̵�
	private int ageGroup;// ��ǥ�� ��� ���ɴ�
	private String name;// �ĺ� �̸�
	private int voteCount;// ��ǥ��
	private double votePercentage;// ��ǥ��

	public int getAgeGroup() {// ��ǥ�� ��� ���ɴ븦 �����پ��� �Լ�
		return ageGroup;
	}

	public void setAgeGroup(int ageGroup) {// ��ǥ�� ��� ���ɴ븦 �����ϴ� �Լ�
		this.ageGroup = ageGroup;
	}

	public int getId() {// �ĺ� ���̵� �����پ��� �Լ�
		return id;
	}

	public void setId(int id) {// �ĺ� ���̵� �����ϴ� �Լ�
		this.id = id;
	}

	public String getName() {// �ĺ� �̸� �����پ��� �Լ�
		return name;
	}

	public void setName(String name) {// �ĺ� �̸� �����ϴ� �Լ�
		this.name = name;
	}

	public int getVoteCount() {// ��ǥ���� ������ ���� �޼ҵ�
		return voteCount;
	}

	public void setVoteCount(int voteCount) {// ��ǥ���� �����ϴ� �޼ҵ�
		this.voteCount = voteCount;
	}

	public double getVotePercentage() {// ��ǥ���� ������ ���� �޼ҵ�
		return votePercentage;
	}

	public void setVotePercentage(double votePercentage) {// ��ǥ���� �����ϴ� �޼ҵ�
		this.votePercentage = votePercentage;
	}
}
