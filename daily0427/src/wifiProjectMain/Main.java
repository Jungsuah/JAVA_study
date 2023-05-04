package wifiProjectMain;

import java.util.List;

import dao.WifiItemDao;
import domain.WifiItem;
import service.WifiItemService;

public class Main {
	public static void main(String[] args) {
		System.out.println("wifi project"); // ȭ�鿡 "wifi project" ���

		WifiItemService wifiItemService = new WifiItemService(); // WifiItemService �ν��Ͻ� ����
		WifiItemDao wifiItemDao = new WifiItemDao(); // WifiItemDao �ν��Ͻ� ����
		List<WifiItem> wifiItems = null; // WifiItem ��ü ����Ʈ ���� �� �ʱ�ȭ

		wifiItems = wifiItemDao.selectAll(); // DB���� ��� WifiItem ��ü ��������

		WifiItem me = new WifiItem(); // ���� ��ġ ������ ��Ÿ���� WifiItem ��ü ����
		double k27_lat = 37.3860521; // ���� �� ����
		double k27_lng = 127.1214038; // �浵 �� ����
		me.setLatitude(k27_lat); // ���� ��ġ ���� ����
		me.setLongitude(k27_lng); // ���� ��ġ �浵 ����

		double maxdist = 0; // �ִ� �Ÿ� ���� �ʱ�ȭ
		double mindist = 0; // �ּ� �Ÿ� ���� �ʱ�ȭ

		WifiItem Max = null; // �ִ� �Ÿ��� ���� WifiItem ��ü �ʱ�ȭ
		WifiItem Min = null; // �ּ� �Ÿ��� ���� WifiItem ��ü �ʱ�ȭ

		for (WifiItem target : wifiItems) { // wifiItems ����Ʈ�� �ִ� ��� WifiItem ��ü�� ���� �ݺ��� ����
		    System.out.printf("**[%d��° �׸�]***********\n", target.getId()); // �ش� ��ü�� �� ��° �׸����� ���
		    System.out.printf(" %s : %s\n", "���������ּ�", target.getLotNumberAddress()); // �ش� WifiItem ��ü�� ���������ּ� ���
		    System.out.printf(" %s : %s\n", "����", target.getLatitude()); // �ش� WifiItem ��ü�� ���� ���
		    System.out.printf(" %s : %s\n", "�浵", target.getLongitude()); // �ش� WifiItem ��ü�� �浵 ���
		    double dist = wifiItemService.getDistance(me, target); // ���� ��ġ�� �ش� WifiItem ��ü�� �Ÿ� ���
		    System.out.printf(" ���� ������ �Ÿ� : %f\n", dist); // ���� �Ÿ� ���
		    System.out.println("*************************");

		    if (target.getId() == 1) { // ù��° �׸��� ���
		        maxdist = dist; // �ִ� �Ÿ� �� �ʱ�ȭ
		        mindist = dist; // �ּ� �Ÿ� �� �ʱ�ȭ
		    } else { // ù��° �׸��� �ƴ� ���
		        if (maxdist < dist) { // �ִ� �Ÿ����� ���� �Ÿ��� �� Ŭ ���
		            maxdist = dist; // �ִ� �Ÿ� �� ������Ʈ
		            Max = target; // �ִ� �Ÿ��� ���� WifiItem ��ü ������Ʈ
		        }
		        if (mindist > dist) { // �ּ� �Ÿ����� ���� �Ÿ��� �� ���� ���
		            mindist = dist; // �ּ� �Ÿ� �� ������Ʈ
		            Min = target;// �ּ� �Ÿ��� ���� WifiItem ��ü ������Ʈ
				}
			}
		}

		// ���� ����� ��� ���� ���
		if (Min != null) {
			System.out.printf("\n**[�ִ� �Ÿ�]***************\n");
			System.out.printf(" %s : %s\n", "��ġ��Ҹ�", Min.getInstallationLocationName());
			System.out.printf(" %s : %s\n", "���������ּ�", Min.getLotNumberAddress());
			System.out.printf(" %s : %s\n", "����", Min.getLatitude());
			System.out.printf(" %s : %s\n", "�浵", Min.getLongitude());
			System.out.printf(" ���������� �Ÿ� : %f\n", mindist);
		} else {
			System.out.printf("\n��� ������ �����ϴ�.\n");
		}

		// ���� �� ��� ���� ���
		if (Max != null) {
			System.out.printf("\n**[�ִ� �Ÿ�]***************\n");
			System.out.printf(" %s : %s\n", "��ġ��Ҹ�", Max.getInstallationLocationName());
			System.out.printf(" %s : %s\n", "���������ּ�", Max.getLotNumberAddress());
			System.out.printf(" %s : %s\n", "����", Max.getLatitude());
			System.out.printf(" %s : %s\n", "�浵", Max.getLongitude());
			System.out.printf(" ���������� �Ÿ� : %f\n", maxdist);
		} else {
			System.out.printf("\n��� ������ �����ϴ�.\n");
		}
	}
}
