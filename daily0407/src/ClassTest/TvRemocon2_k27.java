package ClassTest;

public class TvRemocon2_k27 {
	private int limit_up_channel_k27 = 100;//최대채널변수 생성
	private int limit_down_channel_k27 = 1;//최소채널변수 생성
	private int  channel_k27= 1;//현재 채널
	
	private int limit_up_volum_k27 = 100;//최대채널볼륨 생성
	private int limit_down_volum_k27 = 0;//최소채널볼륨 생성
	private int  volum_k27= 0;//현재 볼륨
	
	public String help_k27;//결과출력할 문자열변수 선언
	
	public TvRemocon2_k27() {//기본생성자 선언
		super();
	}

	//채널과 볼륨을 인자로 받는 메소드 생성
	public TvRemocon2_k27(int wchannel_k27, int wvolum_k27) {
		this.channel_k27 = wchannel_k27;//입력받은 채널값을 클래스 안에있는 channel에 넣어준다
		this.volum_k27 = wvolum_k27;//입력받은 볼륨값을 클래스 안에있는 channel에 넣어준다
		System.out.println("원하는 인자값 받기 완료!");
		System.out.println("현재 세팅된 채널 : " + channel_k27);//세팅된 채널 확인
		System.out.println("현재 세팅된 볼륨 : " + volum_k27);//세팅된 볼륨 확인
	}

	public void VolUp_k27() {//볼륨 올리는 메소드 만들기
		if (volum_k27 == limit_up_volum_k27) {//만약에 최대 볼륨이랑 현재볼륨이 같다면
			help_k27 = "최대볼륨입니다.";//최대볼륨인것을 알려주기
		}else {
			volum_k27++;//그렇지 않으면 계속 볼륨 증가
			help_k27 = String.format("볼륨은 %d입니다", volum_k27);//help 문자형 변수에 현재 volum_k27을 넣기
		}
	}

	public void VolDn_k27() {//볼륨 내리는 메소드 만들기
		if (volum_k27 == limit_down_channel_k27) {//만약에 최소 볼륨이랑 현재볼륨이 같다면
			help_k27 = "최소볼륨입니다.";//최소볼륨인것을 알려주기
		}else {
			volum_k27--;//그렇지 않으면 계속 볼륨 감소
			help_k27 = String.format("볼륨은 %d입니다", volum_k27);//help 문자형 변수에 현재 volum_k27을 넣기
		}
	}

	public void ChannelUp_k27() {//채널 올리는 메소드 만들기
		if (channel_k27 == limit_up_channel_k27) {//만약에 최대채널이랑 현재채널이 같다면
			help_k27 = "최대채널입니다.";//최대채널인것을 알려주기
		}else {
			channel_k27++;//그렇지 않으면 계속 채널 증가
			help_k27 = String.format("채널은 %d입니다", channel_k27);//help 문자형 변수에 현재 channel_k27을 넣기
		}
	}

	public void ChannelDn_k27() {//채널 내리는 메소드 만들기
		if (channel_k27 == limit_down_volum_k27) {//만약에 최소채널이랑 현재채널이 같다면
			help_k27 = "최소채널입니다.";//최소채널인것을 알려주기
		}else {
			channel_k27--;//그렇지 않으면 계속 채널 감소
			help_k27 = String.format("채널은 %d입니다", channel_k27);//help 문자형 변수에 현재 channel_k27을 넣기
		}
	}
	
	void msg1(String vid) {//아이디 값을 받았을때 Elevator2 클래스 안에 변수 정보를 출력하는 메소드
		System.out.printf("최대볼륨[%d] 최소볼륨[%d] 현재볼륨[%d]\n",  limit_up_volum_k27, limit_down_volum_k27, volum_k27);
	}
	
	void msg2(String cid) {//아이디 값을 받았을때 Elevator2 클래스 안에 변수 정보를 출력하는 메소드
		System.out.printf("최대채널[%d] 최소채널[%d] 현재채널[%d]\n", limit_up_channel_k27, limit_down_channel_k27, channel_k27);
	}
	
	//------------------------------------------------------------------
	//up메소드와 이름은 같지만 인자값을 다르게 가지는 메소드 -> 오버로딩
//		void ChannelUp(int wchannel) {//채널 인자로 들어오면
//			for (int i = 0; i < wchannel; i++) {
//				this.ChannelUp();//해당 채널까지 올라가는 메소드 호출
//			}
//		}
//		
//		//up메소드와 이름은 같지만 인자값을 다르게 가지는 메소드 -> 오버로딩
//		void VolUp(int wvolum) {//볼륨 인자로 들어오면
//			for (int i = 0; i < wvolum; i++) {
//				this.VolUp();//해당 볼륨까지 올라가는 메소드 호출
//			}
//		}
//
//		//down메소드와 이름은 같지만 인자값을 다르게 가지는 메소드 -> 오버로딩
//		void ChannelDn(int wchannel) {//채널이 인자로 들어오면
//			for (int i = 0; i < wchannel; i++) {
//				this.ChannelDn();//해당 채널까지 올라가는 메소드 호출
//			}
//		}
//		
//		//down메소드와 이름은 같지만 인자값을 다르게 가지는 메소드 -> 오버로딩
//		void VolDn(int wvolum) {//볼륨이 인자로 들어오면
//			for (int i = 0; i < wvolum; i++) {
//				this.VolDn();//해당 볼륨까지 올라가는 메소드 호출
//			}
//		}
	//------------------------------------------------------------------
		
}
