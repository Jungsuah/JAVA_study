package ClassTest;

public class InputData {
	public String[] name_k27;//문자형 배열 선언
	public int[] kor_k27;//숫자형 배열 선언
	public int[] eng_k27;//숫자형 배열 선언
	public int[] mat_k27;//숫자형 배열 선언
	public int[] sum_k27;//숫자형 배열 선언
	public int[] avg_k27;//숫자형 배열 선언
	int korSum_k27;//숫자형 변수 선언

	public InputData(int iPerson2_k27) {//들어오는 크기만큼 배열크기설정
		name_k27 = new String[iPerson2_k27];//배열 크기 초기화
		kor_k27 = new int[iPerson2_k27];//배열 크기 초기화
		eng_k27 = new int[iPerson2_k27];//배열 크기 초기화
		mat_k27 = new int[iPerson2_k27];//배열 크기 초기화
		sum_k27 = new int[iPerson2_k27];//배열 크기 초기화
		avg_k27 = new int[iPerson2_k27];//배열 크기 초기화
	}

	public void SetData(int i_k27, String name_k27, int kor_k27, int eng_k27, int mat_k27) {//들어오는 인자값을 배열에 i번째 값에 넣어주기
		this.name_k27[i_k27] = name_k27;//이름을 i번째 name배열에 넣기
		this.kor_k27[i_k27] = kor_k27;//국어 i번째 kor배열에 넣기
		this.eng_k27[i_k27] = eng_k27;//영어 i번째 eng배열에 넣기
		this.mat_k27[i_k27] = mat_k27;//수학 i번째 mat배열에 넣기
		this.sum_k27[i_k27] = kor_k27 + eng_k27 + mat_k27;//합계를 합계배열에 넣기
		this.avg_k27[i_k27] = (int)(this.sum_k27[i_k27] / 3);//합계나눠서 평균구하고 평균배열에 넣기
	}
	
}
