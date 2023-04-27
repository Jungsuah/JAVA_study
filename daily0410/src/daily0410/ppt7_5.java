package daily0410;

public class ppt7_5 {
	public static void main(String[] args) { // 메인함수 선언
	     int[] iArray_k27 = { 1, 7, 5, 3, 2, 1, 3, 4, 9, 12, 1, 212, 33, 11, 21, 11, 2121, 121, 11, 5, 6, 33 };
	      for (int i_k27 = 0; i_k27 < iArray_k27.length; i_k27++)
	         System.out.printf(" iArray[%d] =%d\n", i_k27, iArray_k27[i_k27]);
	      // MAX찾기
	      int iMax_27 = iArray_k27[0]; // 처음시작배열부터시작
	      int iMin_k27 = iArray_k27[0]; // 처음시작배열부터시작
	      int iMaxPt_k27 = 0;
	      int iMinPt_k27 = 0;
	      for (int i_k27 = 0; i_k27 < iArray_k27.length; i_k27++) { //배열의 갯수만큼 루프반복
	         if (iMax_27 < iArray_k27[i_k27]) {// 만일 기존맥스변수보다 배열값이 크다면
	            iMax_27 = iArray_k27[i_k27];//기존맥스변수값은 배열값으로 바꾸고
	            iMaxPt_k27 = i_k27;//기존맥스변수의 배열위치값도 바꾸고
	         }
	      }
	      for (int i_k27 = 0; i_k27 < iArray_k27.length; i_k27++) { //배열의 갯수만큼 루프반복
	         if (iMin_k27 > iArray_k27[i_k27]) {// 만일 기존민변수보다 배열값이 작다면
	            iMin_k27 = iArray_k27[i_k27];//기존민변수값은 배열값으로 바꾸고
	            iMinPt_k27 = i_k27;//기존민변수의배열위치값도 바꾸고
	         }
	      }
	      System.out.printf("MAX iArray[%d] = %d\n", iMaxPt_k27, iMax_27);//맥스 변수 출력
	      System.out.printf("MAX iArray[%d] = %d\n", iMinPt_k27, iMin_k27);//민 변수 출력
	}
}
