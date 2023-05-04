package service;

import domain.WifiItem;

public class WifiItemService {

	// 두 WifiItem 객체 간의 거리를 계산하여 반환하는 메소드이다.
	public double getDistance(WifiItem k27_wifiItem1, WifiItem k27_wifiItem2) {

		// 두 WifiItem 객체의 위도와 경도를 이용하여 거리를 계산한다.
		double k27_dist = Math.sqrt(Math.pow(k27_wifiItem2.getLatitude() - k27_wifiItem1.getLatitude(), 2)
				+ Math.pow(k27_wifiItem2.getLongitude() - k27_wifiItem1.getLongitude(), 2));

		// 계산된 거리를 반환한다.
		return k27_dist;
	}
}
