package kr.ac.kopo.ctc.kopo27.dto;

public class Pagination {
	private int c; // 현재 페이지
	private int s; // 시작 버튼
	private int e; // 끝 버튼
	private int p;
	private int pp;
	private int n; // 다음 블록 시작 버튼
	private int nn; // 맨 마지막 페이지 버튼

	// 현재 페이지를 가져옵니다.
	public int getC() {
		return c;
	}

	// 현재 페이지를 설정합니다.
	public void setC(int c) {
		this.c = c;
	}

	// 시작 버튼을 가져옵니다.
	public int getS() {
		return s;
	}

	// 시작 버튼을 설정합니다.
	public void setS(int s) {
		this.s = s;
	}

	// 끝 버튼을 가져옵니다.
	public int getE() {
		return e;
	}

	// 끝 버튼을 설정합니다.
	public void setE(int e) {
		this.e = e;
	}

	// 이번 10블록 전으로 가는 버튼을 가져옵니다.
	public int getP() {
		return p;
	}

	// 이번 10블록 전으로 가는 버튼을 설정합니다.
	public void setP(int p) {
		this.p = p;
	}

	// 맨 처음으로 가는 버튼을 가져옵니다.
	public int getPp() {
		return pp;
	}

	// 맨 처음으로 가는 버튼을 설정합니다.
	public void setPp(int pp) {
		this.pp = pp;
	}

	// 다음 블록 시작 버튼을 가져옵니다.
	public int getN() {
		return n;
	}

	// 다음 블록 시작 버튼을 설정합니다.
	public void setN(int n) {
		this.n = n;
	}

	// 맨 마지막 페이지 버튼을 가져옵니다.
	public int getNn() {
		return nn;
	}

	// 맨 마지막 페이지 버튼을 설정합니다.
	public void setNn(int nn) {
		this.nn = nn;
	}
}