package service;

import domain.WifiItem;

public class WifiItemService {

	public double getDistance(WifiItem wifiItem1,WifiItem wifiItem2) {
		
		double dist = Math.sqrt(Math.pow(wifiItem2.getLatitude() - wifiItem1.getLatitude(), 2)
				+ Math.pow(wifiItem2.getLongitude() - wifiItem1.getLongitude(), 2));
		System.out.printf(" 현재 지점과 거리 : %f\n", dist);
		System.out.println("*************************");

		return dist;
	}
}
