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
			System.out.printf("**[%d번째 항목]***********\n", target.getId());// 출력하기
			System.out.printf(" %s : %s\n", "소재지번주소", target.getLotNumberAddress());
			System.out.printf(" %s : %s\n", "위도", target.getLatitude());
			System.out.printf(" %s : %s\n", "경도", target.getLongitude());
			double dist = wifiItemService.getDistance(me, target);
			System.out.printf(" 현재 지점과 거리 : %f\n", dist);
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

		// 가장 가까운 장소 정보 출력
		if (Min != null) {
			System.out.printf("\n**[최단 거리]***************\n");
			System.out.printf(" %s : %s\n", "설치장소명", Min.getInstallationLocationName());
			System.out.printf(" %s : %s\n", "소재지번주소", Min.getLotNumberAddress());
			System.out.printf(" %s : %s\n", "위도", Min.getLatitude());
			System.out.printf(" %s : %s\n", "경도", Min.getLongitude());
			System.out.printf(" 현재지점과 거리 : %f\n", mindist);
		} else {
			System.out.printf("\n장소 정보가 없습니다.\n");
		}

		// 가장 먼 장소 정보 출력
		if (Max != null) {
			System.out.printf("\n**[최단 거리]***************\n");
			System.out.printf(" %s : %s\n", "설치장소명", Max.getInstallationLocationName());
			System.out.printf(" %s : %s\n", "소재지번주소", Max.getLotNumberAddress());
			System.out.printf(" %s : %s\n", "위도", Max.getLatitude());
			System.out.printf(" %s : %s\n", "경도", Max.getLongitude());
			System.out.printf(" 현재지점과 거리 : %f\n", maxdist);
		} else {
			System.out.printf("\n장소 정보가 없습니다.\n");
		}
	}
}
