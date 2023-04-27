package ClassTest;

public class TvRemocon {
	int channel_k27 = 0;//숫자형 변수 선언
	int volum_k27 = 0;//숫자형 변수 선언
	int limit_up_channel = 10;//최대채널 설정 숫자형 변수 선언
	int limit_down_channel = 0;//최소채널 설정 숫자형 변수 선언
	int limit_up_volum = 5;//최대볼륨 설정 숫자형 변수 선언
	int limit_down_volum = 0;//최소볼륨 설정 숫자형 변수 선언
	String help_k27;//문자형 변수 선언

	public void VolUp_k27() {//볼륨 올리는 메소드 만들기
		if (volum_k27 == limit_up_volum) {//만약에 최대 볼륨이랑 현재볼륨이 같다면
			help_k27 = "최대볼륨입니다.";//최대볼륨인것을 알려주기
		}else {
			volum_k27++;//그렇지 않으면 계속 볼륨 증가
			help_k27 = String.format("볼륨은 %d입니다", volum_k27);//help 문자형 변수에 현재 volum_k27을 넣기
		}
		System.out.println(help_k27);//출력
	}

	public void VolDn_k27() {//볼륨 내리는 메소드 만들기
		if (volum_k27 == limit_down_channel) {//만약에 최소 볼륨이랑 현재볼륨이 같다면
			help_k27 = "최소볼륨입니다.";//최소볼륨인것을 알려주기
		}else {
			volum_k27--;//그렇지 않으면 계속 볼륨 감소
			help_k27 = String.format("볼륨은 %d입니다", volum_k27);//help 문자형 변수에 현재 volum_k27을 넣기
		}
		System.out.println(help_k27);//출력
	}

	public void ChannelUp_k27() {//채널 올리는 메소드 만들기
		if (channel_k27 == limit_up_channel) {//만약에 최대채널이랑 현재채널이 같다면
			help_k27 = "최대채널입니다.";//최대채널인것을 알려주기
		}else {
			channel_k27++;//그렇지 않으면 계속 채널 증가
			help_k27 = String.format("채널은 %d입니다", channel_k27);//help 문자형 변수에 현재 channel_k27을 넣기
		}
		System.out.println(help_k27);//출력
	}

	public void ChannelDn_k27() {//채널 내리는 메소드 만들기
		if (channel_k27 == limit_down_volum) {//만약에 최소채널이랑 현재채널이 같다면
			help_k27 = "최소채널입니다.";//최소채널인것을 알려주기
		}else {
			channel_k27--;//그렇지 않으면 계속 채널 감소
			help_k27 = String.format("채널은 %d입니다", channel_k27);//help 문자형 변수에 현재 channel_k27을 넣기
		}
		System.out.println(help_k27);//출력
	}
}
