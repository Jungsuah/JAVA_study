package daily0410;

public class ppt7_5 {
	public static void main(String[] args) { // �����Լ� ����
	     int[] iArray_k27 = { 1, 7, 5, 3, 2, 1, 3, 4, 9, 12, 1, 212, 33, 11, 21, 11, 2121, 121, 11, 5, 6, 33 };
	      for (int i_k27 = 0; i_k27 < iArray_k27.length; i_k27++)
	         System.out.printf(" iArray[%d] =%d\n", i_k27, iArray_k27[i_k27]);
	      // MAXã��
	      int iMax_27 = iArray_k27[0]; // ó�����۹迭���ͽ���
	      int iMin_k27 = iArray_k27[0]; // ó�����۹迭���ͽ���
	      int iMaxPt_k27 = 0;
	      int iMinPt_k27 = 0;
	      for (int i_k27 = 0; i_k27 < iArray_k27.length; i_k27++) { //�迭�� ������ŭ �����ݺ�
	         if (iMax_27 < iArray_k27[i_k27]) {// ���� �����ƽ��������� �迭���� ũ�ٸ�
	            iMax_27 = iArray_k27[i_k27];//�����ƽ��������� �迭������ �ٲٰ�
	            iMaxPt_k27 = i_k27;//�����ƽ������� �迭��ġ���� �ٲٰ�
	         }
	      }
	      for (int i_k27 = 0; i_k27 < iArray_k27.length; i_k27++) { //�迭�� ������ŭ �����ݺ�
	         if (iMin_k27 > iArray_k27[i_k27]) {// ���� �����κ������� �迭���� �۴ٸ�
	            iMin_k27 = iArray_k27[i_k27];//�����κ������� �迭������ �ٲٰ�
	            iMinPt_k27 = i_k27;//�����κ����ǹ迭��ġ���� �ٲٰ�
	         }
	      }
	      System.out.printf("MAX iArray[%d] = %d\n", iMaxPt_k27, iMax_27);//�ƽ� ���� ���
	      System.out.printf("MAX iArray[%d] = %d\n", iMinPt_k27, iMin_k27);//�� ���� ���
	}
}
