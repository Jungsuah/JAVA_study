package ClassTest;

public class TestMain3 extends Calc2 {//����� �ؼ� �޼ҵ带 ����Ҽ� �ְ� �����
	public static void main(String[] args) {
		Calc2 cc = new Calc2();// �޼ҵ带 �������� ���� ��ü ����

		System.out.println("3�� ����ǥ");//���
		System.out.println("======================================================");//�ٳ�����
		System.out.println("�̸�   ����   ����   ����   ����   ���");//���
		System.out.println("======================================================");//�ٳ�����
		System.out.printf("������  %3d    %3d    %3d    %3d    %3d", 100, 100, 100, cc.sum(100, 100, 100),
				cc.avg(100, 100, 100));//����� ���� Calc2�� �޼ҵ带 ����Ҽ�����
		System.out.println();
		System.out.println();
		System.out.println("4�� ����ǥ");//���
		System.out.println("======================================================");//�ٳ�����
		System.out.println("�̸�   ����   ����   ����   ����   ����   ���");//���
		System.out.println("======================================================");//�ٳ�����
		System.out.printf("������  %3d    %3d    %3d    %3d    %3d   %.1f", 100, 100, 100, 100, cc.sum(100, 100, 100, 100),
				cc.avg(100, 100, 100, 100));//����� ���� Calc2�� �޼ҵ带 ����Ҽ�����
		System.out.println();
		System.out.println();
		System.out.println("5�� ����ǥ");//���
		System.out.println("======================================================");//�ٳ�����
		System.out.println("�̸�   ����   ����   ����   ����   ��ȸ   ����   ���");//���
		System.out.println("======================================================");//�ٳ�����
		System.out.printf("������  %3d    %3d    %3d    %3d    %3d    %3d   %.1f", 100, 100, 100, 100, 100,
				cc.sum(100, 100, 100, 100, 100), cc.avg(100, 100, 100, 100, 100));//����� ���� Calc2�� �޼ҵ带 ����Ҽ�����

	}
}
