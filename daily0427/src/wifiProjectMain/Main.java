package wifiProjectMain;

import java.util.List;

import dao.WifiItemDao;
import domain.WifiItem;
import service.WifiItemService;

public class Main {
	public static void main(String[] args) {
		System.out.println("wifi project"); // 화면에 "wifi project" 출력

		WifiItemService wifiItemService = new WifiItemService(); // WifiItemService 인스턴스 생성
		WifiItemDao wifiItemDao = new WifiItemDao(); // WifiItemDao 인스턴스 생성
		List<WifiItem> wifiItems = null; // WifiItem 객체 리스트 생성 후 초기화

		wifiItems = wifiItemDao.selectAll(); // DB에서 모든 WifiItem 객체 가져오기

		WifiItem me = new WifiItem(); // 현재 위치 정보를 나타내는 WifiItem 객체 생성
		double k27_lat = 37.3860521; // 위도 값 설정
		double k27_lng = 127.1214038; // 경도 값 설정
		me.setLatitude(k27_lat); // 현재 위치 위도 설정
		me.setLongitude(k27_lng); // 현재 위치 경도 설정

		double maxdist = 0; // 최대 거리 변수 초기화
		double mindist = 0; // 최소 거리 변수 초기화

		WifiItem Max = null; // 최대 거리를 가진 WifiItem 객체 초기화
		WifiItem Min = null; // 최소 거리를 가진 WifiItem 객체 초기화

		for (WifiItem target : wifiItems) { // wifiItems 리스트에 있는 모든 WifiItem 객체에 대해 반복문 실행
		    System.out.printf("**[%d번째 항목]***********\n", target.getId()); // 해당 객체가 몇 번째 항목인지 출력
		    System.out.printf(" %s : %s\n", "소재지번주소", target.getLotNumberAddress()); // 해당 WifiItem 객체의 소재지번주소 출력
		    System.out.printf(" %s : %s\n", "위도", target.getLatitude()); // 해당 WifiItem 객체의 위도 출력
		    System.out.printf(" %s : %s\n", "경도", target.getLongitude()); // 해당 WifiItem 객체의 경도 출력
		    double dist = wifiItemService.getDistance(me, target); // 현재 위치와 해당 WifiItem 객체의 거리 계산
		    System.out.printf(" 현재 지점과 거리 : %f\n", dist); // 계산된 거리 출력
		    System.out.println("*************************");

		    if (target.getId() == 1) { // 첫번째 항목일 경우
		        maxdist = dist; // 최대 거리 값 초기화
		        mindist = dist; // 최소 거리 값 초기화
		    } else { // 첫번째 항목이 아닐 경우
		        if (maxdist < dist) { // 최대 거리보다 현재 거리가 더 클 경우
		            maxdist = dist; // 최대 거리 값 업데이트
		            Max = target; // 최대 거리를 가진 WifiItem 객체 업데이트
		        }
		        if (mindist > dist) { // 최소 거리보다 현재 거리가 더 작을 경우
		            mindist = dist; // 최소 거리 값 업데이트
		            Min = target;// 최소 거리를 가진 WifiItem 객체 업데이트
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
