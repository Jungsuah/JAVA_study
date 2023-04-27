package ClassTest;

public class TvRemocon2Main {

	static TvRemocon2_k27 tvRe_k27;

	public static void main(String[] args) {
		// 현채 채널과 볼륨 입력
		tvRe_k27 = new TvRemocon2_k27(); //새로운 객체 생성
		System.out.println();

		for (int i_k27 = 0; i_k27 < 10; i_k27++) {//10번 채널 증가
			tvRe_k27.ChannelUp_k27();//생성자 호출
			tvRe_k27.msg2("채널 10개 올리기");//출력
		}
		System.out.println();

		for (int i_k27 = 0; i_k27 < 10; i_k27++) {//10번 채널 감소
			tvRe_k27.ChannelDn_k27();//생성자 호출
			tvRe_k27.msg2("채널 10개 내리기");//출력
		}
		System.out.println();

		for (int i_k27 = 0; i_k27 < 5; i_k27++) {//5번 채널 증가
			tvRe_k27.VolUp_k27();//생성자 호출
			tvRe_k27.msg1("볼륨 5개 올리기");//출력
		}
		System.out.println();

		for (int i_k27 = 0; i_k27 < 5; i_k27++) {//5번 채널 감소
			tvRe_k27.VolDn_k27();//생성자 호출
			tvRe_k27.msg1("볼륨 5개 내리기");//출력
		}
	}
}
