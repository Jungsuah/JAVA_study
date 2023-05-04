package wifiProjectMain;

import java.util.List;

import dao.WifiItemDao;
import domain.WifiItem;
import service.WifiItemService;

public class Main {
	public static void main(String[] args) {
		System.out.println("wifi project"); // 화면에 "wifi project" 출력

		WifiItemService k27_wifiItemService = new WifiItemService(); // WifiItemService 인스턴스 생성
		WifiItemDao k27_wifiItemDao = new WifiItemDao(); // WifiItemDao 인스턴스 생성
		List<WifiItem> k27_wifiItems = null; // WifiItem 객체 리스트 생성 후 초기화

		k27_wifiItems = k27_wifiItemDao.selectAll(); // DB에서 모든 WifiItem 객체 가져오기

		WifiItem k27_me = new WifiItem(); // 현재 위치 정보를 나타내는 WifiItem 객체 생성
		double k27_lat = 37.3860521; // 위도 값 설정
		double k27_lng = 127.1214038; // 경도 값 설정
		k27_me.setLatitude(k27_lat); // 현재 위치 위도 설정
		k27_me.setLongitude(k27_lng); // 현재 위치 경도 설정

		double k27_maxdist = 0; // 최대 거리 변수 초기화
		double k27_mindist = 0; // 최소 거리 변수 초기화

		WifiItem k27_Max = null; // 최대 거리를 가진 WifiItem 객체 초기화
		WifiItem k27_Min = null; // 최소 거리를 가진 WifiItem 객체 초기화

		for (WifiItem k27_target : k27_wifiItems) { // wifiItems 리스트에 있는 모든 WifiItem 객체에 대해 반복문 실행
		    System.out.printf("**[%d번째 항목]***********\n", k27_target.getId()); // 해당 객체가 몇 번째 항목인지 출력
		    System.out.printf(" %s : %s\n", "소재지번주소", k27_target.getLotNumberAddress()); // 해당 WifiItem 객체의 소재지번주소 출력
		    System.out.printf(" %s : %s\n", "위도", k27_target.getLatitude()); // 해당 WifiItem 객체의 위도 출력
		    System.out.printf(" %s : %s\n", "경도", k27_target.getLongitude()); // 해당 WifiItem 객체의 경도 출력
		    double k27_dist = k27_wifiItemService.getDistance(k27_me, k27_target); // 현재 위치와 해당 WifiItem 객체의 거리 계산
		    System.out.printf(" 현재 지점과 거리 : %f\n", k27_dist); // 계산된 거리 출력
		    System.out.println("*************************");

		    if (k27_target.getId() == 1) { // 첫번째 항목일 경우
		        k27_maxdist = k27_dist; // 최대 거리 값 초기화
		        k27_mindist = k27_dist; // 최소 거리 값 초기화
		    } else { // 첫번째 항목이 아닐 경우
		        if (k27_maxdist < k27_dist) { // 최대 거리보다 현재 거리가 더 클 경우
		            k27_maxdist = k27_dist; // 최대 거리 값 업데이트
		            k27_Max = k27_target; // 최대 거리를 가진 WifiItem 객체 업데이트
		        }
		        if (k27_mindist > k27_dist) { // 최소 거리보다 현재 거리가 더 작을 경우
		            k27_mindist = k27_dist; // 최소 거리 값 업데이트
		            k27_Min = k27_target;// 최소 거리를 가진 WifiItem 객체 업데이트
				}
			}
		}

		// 가장 가까운 장소 정보 출력
		if (k27_Min != null) {// 최소 거리를 가진 WifiItem 객체가 null이 아니면
			System.out.printf("\n**[최단 거리]***************\n");
			System.out.printf(" %s : %s\n", "설치장소명", k27_Min.getInstallationLocationName());// 최소 거리를 가진 WifiItem 객체의 설치 장소명 
			System.out.printf(" %s : %s\n", "소재지번주소", k27_Min.getLotNumberAddress());// 최소 거리를 가진 WifiItem 객체의 설치 도로명 주소
			System.out.printf(" %s : %s\n", "위도", k27_Min.getLatitude());// 최소 거리를 가진 WifiItem 객체의 위도
			System.out.printf(" %s : %s\n", "경도", k27_Min.getLongitude());// 최소 거리를 가진 WifiItem 객체의 경도
			System.out.printf(" 현재지점과 거리 : %f\n", k27_mindist);// 최소 거리를 가진 WifiItem 객체와 현재지점과의 거리 출력
		} else {// 최소 거리를 가진 WifiItem 객체가 null이면
			System.out.printf("\n장소 정보가 없습니다.\n");//출력
		}

		// 가장 먼 장소 정보 출력
		if (k27_Max != null) {// 최대 거리를 가진 WifiItem 객체가 null이 아니면
			System.out.printf("\n**[최단 거리]***************\n");
			System.out.printf(" %s : %s\n", "설치장소명", k27_Max.getInstallationLocationName());// 최대 거리를 가진 WifiItem 객체의 설치 장소명 
			System.out.printf(" %s : %s\n", "소재지번주소", k27_Max.getLotNumberAddress());// 최대 거리를 가진 WifiItem 객체의 설치 도로명 주소
			System.out.printf(" %s : %s\n", "위도", k27_Max.getLatitude());// 최대 거리를 가진 WifiItem 객체의 위도
			System.out.printf(" %s : %s\n", "경도", k27_Max.getLongitude());// 최대 거리를 가진 WifiItem 객체의 경도
			System.out.printf(" 현재지점과 거리 : %f\n", k27_maxdist);// 최대 거리를 가진 WifiItem 객체와 현재지점과의 거리 출력
		} else {// 최대 거리를 가진 WifiItem 객체가 null이면
			System.out.printf("\n장소 정보가 없습니다.\n");//출력
		}
	}
}
