package service;

import domain.WifiItem;

public class WifiItemService {

	// �� WifiItem ��ü ���� �Ÿ��� ����Ͽ� ��ȯ�ϴ� �޼ҵ��̴�.
	public double getDistance(WifiItem k27_wifiItem1, WifiItem k27_wifiItem2) {

		// �� WifiItem ��ü�� ������ �浵�� �̿��Ͽ� �Ÿ��� ����Ѵ�.
		double k27_dist = Math.sqrt(Math.pow(k27_wifiItem2.getLatitude() - k27_wifiItem1.getLatitude(), 2)
				+ Math.pow(k27_wifiItem2.getLongitude() - k27_wifiItem1.getLongitude(), 2));

		// ���� �Ÿ��� ��ȯ�Ѵ�.
		return k27_dist;
	}
}
