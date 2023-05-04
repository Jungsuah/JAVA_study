package wifiProjectMain;

import java.util.List;

import dao.WifiItemDao;
import domain.WifiItem;
import service.WifiItemService;

public class Main {
	public static void main(String[] args) {
		System.out.println("wifi project"); // ȭ�鿡 "wifi project" ���

		WifiItemService k27_wifiItemService = new WifiItemService(); // WifiItemService �ν��Ͻ� ����
		WifiItemDao k27_wifiItemDao = new WifiItemDao(); // WifiItemDao �ν��Ͻ� ����
		List<WifiItem> k27_wifiItems = null; // WifiItem ��ü ����Ʈ ���� �� �ʱ�ȭ

		k27_wifiItems = k27_wifiItemDao.selectAll(); // DB���� ��� WifiItem ��ü ��������

		WifiItem k27_me = new WifiItem(); // ���� ��ġ ������ ��Ÿ���� WifiItem ��ü ����
		double k27_lat = 37.3860521; // ���� �� ����
		double k27_lng = 127.1214038; // �浵 �� ����
		k27_me.setLatitude(k27_lat); // ���� ��ġ ���� ����
		k27_me.setLongitude(k27_lng); // ���� ��ġ �浵 ����

		double k27_maxdist = 0; // �ִ� �Ÿ� ���� �ʱ�ȭ
		double k27_mindist = 0; // �ּ� �Ÿ� ���� �ʱ�ȭ

		WifiItem k27_Max = null; // �ִ� �Ÿ��� ���� WifiItem ��ü �ʱ�ȭ
		WifiItem k27_Min = null; // �ּ� �Ÿ��� ���� WifiItem ��ü �ʱ�ȭ

		for (WifiItem k27_target : k27_wifiItems) { // wifiItems ����Ʈ�� �ִ� ��� WifiItem ��ü�� ���� �ݺ��� ����
		    System.out.printf("**[%d��° �׸�]***********\n", k27_target.getId()); // �ش� ��ü�� �� ��° �׸����� ���
		    System.out.printf(" %s : %s\n", "���������ּ�", k27_target.getLotNumberAddress()); // �ش� WifiItem ��ü�� ���������ּ� ���
		    System.out.printf(" %s : %s\n", "����", k27_target.getLatitude()); // �ش� WifiItem ��ü�� ���� ���
		    System.out.printf(" %s : %s\n", "�浵", k27_target.getLongitude()); // �ش� WifiItem ��ü�� �浵 ���
		    double k27_dist = k27_wifiItemService.getDistance(k27_me, k27_target); // ���� ��ġ�� �ش� WifiItem ��ü�� �Ÿ� ���
		    System.out.printf(" ���� ������ �Ÿ� : %f\n", k27_dist); // ���� �Ÿ� ���
		    System.out.println("*************************");

		    if (k27_target.getId() == 1) { // ù��° �׸��� ���
		        k27_maxdist = k27_dist; // �ִ� �Ÿ� �� �ʱ�ȭ
		        k27_mindist = k27_dist; // �ּ� �Ÿ� �� �ʱ�ȭ
		    } else { // ù��° �׸��� �ƴ� ���
		        if (k27_maxdist < k27_dist) { // �ִ� �Ÿ����� ���� �Ÿ��� �� Ŭ ���
		            k27_maxdist = k27_dist; // �ִ� �Ÿ� �� ������Ʈ
		            k27_Max = k27_target; // �ִ� �Ÿ��� ���� WifiItem ��ü ������Ʈ
		        }
		        if (k27_mindist > k27_dist) { // �ּ� �Ÿ����� ���� �Ÿ��� �� ���� ���
		            k27_mindist = k27_dist; // �ּ� �Ÿ� �� ������Ʈ
		            k27_Min = k27_target;// �ּ� �Ÿ��� ���� WifiItem ��ü ������Ʈ
				}
			}
		}

		// ���� ����� ��� ���� ���
		if (k27_Min != null) {// �ּ� �Ÿ��� ���� WifiItem ��ü�� null�� �ƴϸ�
			System.out.printf("\n**[�ִ� �Ÿ�]***************\n");
			System.out.printf(" %s : %s\n", "��ġ��Ҹ�", k27_Min.getInstallationLocationName());// �ּ� �Ÿ��� ���� WifiItem ��ü�� ��ġ ��Ҹ� 
			System.out.printf(" %s : %s\n", "���������ּ�", k27_Min.getLotNumberAddress());// �ּ� �Ÿ��� ���� WifiItem ��ü�� ��ġ ���θ� �ּ�
			System.out.printf(" %s : %s\n", "����", k27_Min.getLatitude());// �ּ� �Ÿ��� ���� WifiItem ��ü�� ����
			System.out.printf(" %s : %s\n", "�浵", k27_Min.getLongitude());// �ּ� �Ÿ��� ���� WifiItem ��ü�� �浵
			System.out.printf(" ���������� �Ÿ� : %f\n", k27_mindist);// �ּ� �Ÿ��� ���� WifiItem ��ü�� ������������ �Ÿ� ���
		} else {// �ּ� �Ÿ��� ���� WifiItem ��ü�� null�̸�
			System.out.printf("\n��� ������ �����ϴ�.\n");//���
		}

		// ���� �� ��� ���� ���
		if (k27_Max != null) {// �ִ� �Ÿ��� ���� WifiItem ��ü�� null�� �ƴϸ�
			System.out.printf("\n**[�ִ� �Ÿ�]***************\n");
			System.out.printf(" %s : %s\n", "��ġ��Ҹ�", k27_Max.getInstallationLocationName());// �ִ� �Ÿ��� ���� WifiItem ��ü�� ��ġ ��Ҹ� 
			System.out.printf(" %s : %s\n", "���������ּ�", k27_Max.getLotNumberAddress());// �ִ� �Ÿ��� ���� WifiItem ��ü�� ��ġ ���θ� �ּ�
			System.out.printf(" %s : %s\n", "����", k27_Max.getLatitude());// �ִ� �Ÿ��� ���� WifiItem ��ü�� ����
			System.out.printf(" %s : %s\n", "�浵", k27_Max.getLongitude());// �ִ� �Ÿ��� ���� WifiItem ��ü�� �浵
			System.out.printf(" ���������� �Ÿ� : %f\n", k27_maxdist);// �ִ� �Ÿ��� ���� WifiItem ��ü�� ������������ �Ÿ� ���
		} else {// �ִ� �Ÿ��� ���� WifiItem ��ü�� null�̸�
			System.out.printf("\n��� ������ �����ϴ�.\n");//���
		}
	}
}
