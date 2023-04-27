package daily0410;

import java.util.ArrayList;

public class ppt7_7 {
	public static void main(String[] args) { // 메인함수 선언
		  int iTestMAX_k27 = 1000000;
	      ArrayList iAL_k27 = new ArrayList();

	      for (int i_k27 = 0; i_k27 < iTestMAX_k27; i_k27++) {
	         iAL_k27.add((int) (Math.random() * 1000000));
	      }

	      for (int i_k27 = 0; i_k27 < iAL_k27.size(); i_k27++) {
	         System.out.printf(" ArrayList %d = %d\n", i_k27, iAL_k27.get(i_k27));
	      }
	      System.out.printf("*************************\n");
	      iAL_k27.sort(null);
	      for (int i_k27 = 0; i_k27 < iAL_k27.size(); i_k27++)
	         System.out.printf(" ArrayList %d = %dWn", i_k27, iAL_k27.get(i_k27));
	}
}
