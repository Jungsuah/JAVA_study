package ClassTest;

public class TvRemocon1 {

	static TvRemocon tvRe_k27;// 변수를 static으로 선언해서 바로 쓸수있게 만들기

	public static void main(String[] args) {
		tvRe_k27 = new TvRemocon(); // 새로운 객체 생성

		for (int i_k27 = 0; i_k27 < 10; i_k27++) {//10번 반복
			tvRe_k27.ChannelUp_k27();//채널 10개 증가
		}
		System.out.println();//줄넘김

		for (int i_k27 = 0; i_k27 < 10; i_k27++) {//10번 반복
			tvRe_k27.ChannelDn_k27();//채널 10개 감소
		}
		System.out.println();//줄넘김

		for (int i_k27 = 0; i_k27 < 5; i_k27++) {//5번 반복
			tvRe_k27.VolUp_k27();//볼륨 5개 증가
		}
		System.out.println();//줄넘김

		for (int i_k27 = 0; i_k27 < 5; i_k27++) {//5번 반복
			tvRe_k27.VolDn_k27();//볼륨 5개 감소
		}
	}
}
