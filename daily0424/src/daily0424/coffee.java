package daily0424;

import java.util.Scanner;

public class coffee {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("�ȳ��ϼ���, �� Ŀ���Դϴ�. ���ܵ帱���?");
	int coffeeNum = sc.nextInt();
	System.out.println("Ȥ�� ������ ������ � �Դϱ�?");
	Integer stamp = sc.nextInt();
	while(stamp != null) {
		if (stamp + coffeeNum > 9) {
			System.out.println("10�� ��ż� ������ 1�� �����Դϴ�~");
			break;
		}else if(stamp + coffeeNum == 9) {
			System.out.println("���ð͵� �����ø� ���� ������ " + (stamp + coffeeNum) +"�� �Դϴ�. �������� ���� ���� ����� �弼��");
			break;
		}else {
			System.out.println("���� ���帱�Կ�. ���ñ��� ���� ������ " + (stamp + coffeeNum) +"�� �Դϴ�.");
			break;
		}
	}
	
	int hpay = 2000 * coffeeNum;
	int time = coffeeNum * 3;
	System.out.println(hpay + "�� �Դϴ�. �ҿ�ð��� "+time+"�� �Դϴ�." );
	
	int workpay = 500 * coffeeNum; //60�п� 10000�� �ñ��̴ϱ� 3�п� 500�� ���� -> Ŀ�����ܴ� �˹ٴ� 500�� �����
	System.out.println("�˹� ���� ��� : " + workpay + "�� �Դϴ�.");
			
	int income = (int) ((hpay - workpay) * 0.4);
	System.out.println("������ : " + income + "�� �Դϴ�.");
}
}
