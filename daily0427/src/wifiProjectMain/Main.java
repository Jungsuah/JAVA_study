package wifiProjectMain;

import java.util.List;

import dao.WifiItemDao;
import domain.WifiItem;
import service.WifiItemService;

public class Main {
	public static void main(String[] args) {
		System.out.println("wifi project");

		WifiItemService wifiItemService = new WifiItemService();
		WifiItemDao wifiItemDao = new WifiItemDao();
		List<WifiItem> wifiItems = null;

		wifiItems = wifiItemDao.selectAll();

		WifiItem me = new WifiItem();
		double k27_lat = 37.3860521;
		double k27_lng = 127.1214038;
		me.setLatitude(k27_lat);
		me.setLongitude(k27_lng);

		double maxdist = 0;
		double mindist = 0;

		WifiItem Max = null;
		WifiItem Min = null;

		for (WifiItem target : wifiItems) {
			System.out.printf("**[%d��° �׸�]***********\n", target.getId());// ����ϱ�
			System.out.printf(" %s : %s\n", "���������ּ�", target.getLotNumberAddress());
			System.out.printf(" %s : %s\n", "����", target.getLatitude());
			System.out.printf(" %s : %s\n", "�浵", target.getLongitude());
			double dist = wifiItemService.getDistance(me, target);
			System.out.printf(" ���� ������ �Ÿ� : %f\n", dist);
			System.out.println("*************************");

			if (target.getId() == 1) {
				maxdist = dist;
				mindist = dist;
			} else {
				if (maxdist < dist) {
					maxdist = dist;
					Max = target;
				}
				if (mindist > dist) {
					mindist = dist;
					Min = target;
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
