package kr.ac.kopo.ctc.kopo27.dto;

public class Pagination {
	private int c; // ���� ������
	private int s; // ���� ��ư
	private int e; // �� ��ư
	private int p;
	private int pp;
	private int n; // ���� ��� ���� ��ư
	private int nn; // �� ������ ������ ��ư

	// ���� �������� �����ɴϴ�.
	public int getC() {
		return c;
	}

	// ���� �������� �����մϴ�.
	public void setC(int c) {
		this.c = c;
	}

	// ���� ��ư�� �����ɴϴ�.
	public int getS() {
		return s;
	}

	// ���� ��ư�� �����մϴ�.
	public void setS(int s) {
		this.s = s;
	}

	// �� ��ư�� �����ɴϴ�.
	public int getE() {
		return e;
	}

	// �� ��ư�� �����մϴ�.
	public void setE(int e) {
		this.e = e;
	}

	// �̹� 10��� ������ ���� ��ư�� �����ɴϴ�.
	public int getP() {
		return p;
	}

	// �̹� 10��� ������ ���� ��ư�� �����մϴ�.
	public void setP(int p) {
		this.p = p;
	}

	// �� ó������ ���� ��ư�� �����ɴϴ�.
	public int getPp() {
		return pp;
	}

	// �� ó������ ���� ��ư�� �����մϴ�.
	public void setPp(int pp) {
		this.pp = pp;
	}

	// ���� ��� ���� ��ư�� �����ɴϴ�.
	public int getN() {
		return n;
	}

	// ���� ��� ���� ��ư�� �����մϴ�.
	public void setN(int n) {
		this.n = n;
	}

	// �� ������ ������ ��ư�� �����ɴϴ�.
	public int getNn() {
		return nn;
	}

	// �� ������ ������ ��ư�� �����մϴ�.
	public void setNn(int nn) {
		this.nn = nn;
	}
}
