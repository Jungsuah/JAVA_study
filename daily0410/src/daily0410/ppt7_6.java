package daily0410;

import java.util.ArrayList;

public class ppt7_6 {
	public static void main(String[] args) { // �����Լ� ����
		  ArrayList iAL_k27 = new ArrayList();
	      iAL_k27.add("abc");
	      iAL_k27.add("abcd");
	      iAL_k27.add("efga");
	      iAL_k27.add("������O");
	      iAL_k27.add("1234");
	      iAL_k27.add("12rk34");
	      // iAL.add(356); ��̸���Ʈ�� ��Ʈ������ �������ϴµ� 1�߰��� ���� ������ �ȵȴ�
	      System.out.printf("*******************\n");
	      System.out.printf(" ���� ArraySize %d \n", iAL_k27.size());
	      for (int i_k27 = 0; i_k27 < iAL_k27.size(); i_k27++) {
	         System.out.printf(" ArrayList %d = %s \n", i_k27, iAL_k27.get(i_k27));
	      }
	      iAL_k27.set(3, "������"); // 3����̸���Ʈ ���뺯�� System.out.printf("* System.out.printf("
	      System.out.printf("*******************\n");
	      System.out.printf(" ���뺯�� ArraySize %d \n", iAL_k27.size());
	      for (int i_k27 = 0; i_k27 < iAL_k27.size(); i_k27++) {
	         System.out.printf(" ArrayList %d = %s \n", i_k27, iAL_k27.get(i_k27));
	      }

	      iAL_k27.remove(4); // 4����̸���Ʈ ����
	      System.out.printf("*******************\n");
	      System.out.printf(" ���뺯�� ArraySize %d \n", iAL_k27.size());
	      for (int i_k27 = 0; i_k27 < iAL_k27.size(); i_k27++) {
	         System.out.printf(" ArrayList %d = %s \n", i_k27, iAL_k27.get(i_k27));
	      }

	      iAL_k27.sort(null);
	      System.out.printf("*******************\n");
	      System.out.printf(" ����Ʈ Sort ArraySize %d\n", iAL_k27.size());
	      for (int i_k27 = 0; i_k27 < iAL_k27.size(); i_k27++) {
	         System.out.printf(" ArrayList %d = %s \n", i_k27, iAL_k27.get(i_k27));
	      }
	      iAL_k27.clear();
	      System.out.printf("*******************\n");
	      System.out.printf(" ���λ��� ArrayList %d Wn", iAL_k27.size());
	      for (int i_k27 = 0; i_k27 < iAL_k27.size(); i_k27++) {
	         System.out.printf(" ArrayList %d = %s \n", i_k27, iAL_k27.get(i_k27));
	      }
	}
}
