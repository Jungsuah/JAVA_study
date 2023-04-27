package daily0410;

import java.util.ArrayList;

public class ppt7_6 {
	public static void main(String[] args) { // 메인함수 선언
		  ArrayList iAL_k27 = new ArrayList();
	      iAL_k27.add("abc");
	      iAL_k27.add("abcd");
	      iAL_k27.add("efga");
	      iAL_k27.add("가나다O");
	      iAL_k27.add("1234");
	      iAL_k27.add("12rk34");
	      // iAL.add(356); 어레이리스트를 스트링으로 쓰려고하는데 1중간에 숫자 넣으면 안된다
	      System.out.printf("*******************\n");
	      System.out.printf(" 시작 ArraySize %d \n", iAL_k27.size());
	      for (int i_k27 = 0; i_k27 < iAL_k27.size(); i_k27++) {
	         System.out.printf(" ArrayList %d = %s \n", i_k27, iAL_k27.get(i_k27));
	      }
	      iAL_k27.set(3, "가라라라"); // 3번어레이리스트 내용변경 System.out.printf("* System.out.printf("
	      System.out.printf("*******************\n");
	      System.out.printf(" 내용변경 ArraySize %d \n", iAL_k27.size());
	      for (int i_k27 = 0; i_k27 < iAL_k27.size(); i_k27++) {
	         System.out.printf(" ArrayList %d = %s \n", i_k27, iAL_k27.get(i_k27));
	      }

	      iAL_k27.remove(4); // 4번어레이리스트 삭제
	      System.out.printf("*******************\n");
	      System.out.printf(" 내용변경 ArraySize %d \n", iAL_k27.size());
	      for (int i_k27 = 0; i_k27 < iAL_k27.size(); i_k27++) {
	         System.out.printf(" ArrayList %d = %s \n", i_k27, iAL_k27.get(i_k27));
	      }

	      iAL_k27.sort(null);
	      System.out.printf("*******************\n");
	      System.out.printf(" 리스트 Sort ArraySize %d\n", iAL_k27.size());
	      for (int i_k27 = 0; i_k27 < iAL_k27.size(); i_k27++) {
	         System.out.printf(" ArrayList %d = %s \n", i_k27, iAL_k27.get(i_k27));
	      }
	      iAL_k27.clear();
	      System.out.printf("*******************\n");
	      System.out.printf(" 전부삭제 ArrayList %d Wn", iAL_k27.size());
	      for (int i_k27 = 0; i_k27 < iAL_k27.size(); i_k27++) {
	         System.out.printf(" ArrayList %d = %s \n", i_k27, iAL_k27.get(i_k27));
	      }
	}
}
