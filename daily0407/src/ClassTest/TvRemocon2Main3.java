package ClassTest;

public class TvRemocon2Main3 {

	static TvRemoconX tvRe_k27;

	public static void main(String[] args) {
		// 현채 채널과 볼륨 입력
		tvRe_k27 = new TvRemoconX(48); // 배터리값을 설정해주기
		System.out.println();

		for (int i_k27 = 0; i_k27 < 10; i_k27++) {
			tvRe_k27.ChannelUp_k27();
			tvRe_k27.msg2("채널 10개 올리기");
		}
		System.out.println();

		for (int i_k27 = 0; i_k27 < 10; i_k27++) {
			tvRe_k27.ChannelDn_k27();
			tvRe_k27.msg2("채널 10개 내리기");
		}
		System.out.println();

		for (int i_k27 = 0; i_k27 < 5; i_k27++) {
			tvRe_k27.VolUp_k27();
			tvRe_k27.msg1("볼륨 5개 올리기");
		}
		System.out.println();

		for (int i_k27 = 0; i_k27 < 5; i_k27++) {
			tvRe_k27.VolDn_k27();
			tvRe_k27.msg1("볼륨 5개 내리기");
		}
		System.out.println();
		
		tvRe_k27.checkBattery();
	}
}
