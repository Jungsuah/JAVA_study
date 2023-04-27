package ClassTest;

public class InputData {
	public String[] name_k27;//������ �迭 ����
	public int[] kor_k27;//������ �迭 ����
	public int[] eng_k27;//������ �迭 ����
	public int[] mat_k27;//������ �迭 ����
	public int[] sum_k27;//������ �迭 ����
	public int[] avg_k27;//������ �迭 ����
	int korSum_k27;//������ ���� ����

	public InputData(int iPerson2_k27) {//������ ũ�⸸ŭ �迭ũ�⼳��
		name_k27 = new String[iPerson2_k27];//�迭 ũ�� �ʱ�ȭ
		kor_k27 = new int[iPerson2_k27];//�迭 ũ�� �ʱ�ȭ
		eng_k27 = new int[iPerson2_k27];//�迭 ũ�� �ʱ�ȭ
		mat_k27 = new int[iPerson2_k27];//�迭 ũ�� �ʱ�ȭ
		sum_k27 = new int[iPerson2_k27];//�迭 ũ�� �ʱ�ȭ
		avg_k27 = new int[iPerson2_k27];//�迭 ũ�� �ʱ�ȭ
	}

	public void SetData(int i_k27, String name_k27, int kor_k27, int eng_k27, int mat_k27) {//������ ���ڰ��� �迭�� i��° ���� �־��ֱ�
		this.name_k27[i_k27] = name_k27;//�̸��� i��° name�迭�� �ֱ�
		this.kor_k27[i_k27] = kor_k27;//���� i��° kor�迭�� �ֱ�
		this.eng_k27[i_k27] = eng_k27;//���� i��° eng�迭�� �ֱ�
		this.mat_k27[i_k27] = mat_k27;//���� i��° mat�迭�� �ֱ�
		this.sum_k27[i_k27] = kor_k27 + eng_k27 + mat_k27;//�հ踦 �հ�迭�� �ֱ�
		this.avg_k27[i_k27] = (int)(this.sum_k27[i_k27] / 3);//�հ質���� ��ձ��ϰ� ��չ迭�� �ֱ�
	}
	
}
