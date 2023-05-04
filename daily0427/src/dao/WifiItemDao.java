package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import domain.WifiItem;

public class WifiItemDao {

	public WifiItem create(WifiItem k27_wifiItem) {
		return null;
	}

	public WifiItem selectOne(int id) {
		return null;
	}

	public List<WifiItem> selectAll() {//WifiItem 객체들의 리스트를 반환하는 메소드 selectAll

		List<WifiItem> k27_wifiItems = new ArrayList<>();//WifiItem 객체들을 담을 ArrayList 객체 생성

		File k27_f = new File("C:\\Users\\정수아\\무료와이파이정보.txt");// 경로에 파일 객체 생성
		BufferedReader k27_br = null;// BufferedReader 객체 생성
		try {
			k27_br = new BufferedReader(new FileReader(k27_f));// BufferedReader 객체에 FileReader로 읽은 파일 객체 전달
		} catch (FileNotFoundException e) {
			//만약 파일이 존재하지 않는다면
			e.printStackTrace();
			//오류 출력
		}

		String k27_readtxt;// 출력할 문자열을 담을 변수 선언

		try {
			if ((k27_readtxt = k27_br.readLine()) == null) {// 한줄씩 읽어오기 -> 값이 null이라면
				System.out.printf("빈 파일 입니다\n");// 빈 파일 입니다 출력하고
			}
		} catch (IOException e) {
			//만약 오류가 발생하면
			e.printStackTrace();
			//오류 출력
		}

		int k27_LineCnt = 0;// 라인 번호를 나타내는 변수 초기화
		try {
			while ((k27_readtxt = k27_br.readLine()) != null) {// 파일에서 한 줄 한줄씩 읽어오기
				String[] k27_field = k27_readtxt.split("\t");// 읽어온 문자열을 탭으로 분리하여 문자열 배열에 저장


				// WifiItem 객체 생성
				WifiItem k27_wifiItem = new WifiItem();

				// 각 필드 값 할당
				k27_wifiItem.setId(Integer.parseInt(k27_field[0])); // id 필드에 첫 번째 열 값 할당
				k27_wifiItem.setInstallationLocationName(k27_field[1]); // InstallationLocationName 필드에 두 번째 열 값 할당
				k27_wifiItem.setInstallationLocationDetails(k27_field[2]); // InstallationLocationDetails 필드에 세 번째 열 값 할당
				k27_wifiItem.setInstallationCityName(k27_field[3]); // InstallationCityName 필드에 네 번째 열 값 할당
				k27_wifiItem.setInstallationDistrictName(k27_field[4]); // InstallationDistrictName 필드에 다섯 번째 열 값 할당
				k27_wifiItem.setInstallationFacilityType(k27_field[5]); // installationFacilityType 필드에 여섯 번째 열 값 할당
				k27_wifiItem.setServiceProviderName(k27_field[6]); // ServiceProviderName 필드에 일곱 번째 열 값 할당
				k27_wifiItem.setWifiSsid(k27_field[7]); // wifiSsid 필드에 여덟 번째 열 값 할당
				k27_wifiItem.setDateOfInstallation(k27_field[8]); // dateOfInstallation 필드에 아홉 번째 열 값 할당
				k27_wifiItem.setRoadNameAddress(k27_field[9]); // RoadNameAddress 필드에 열 번째 열 값 할당
				k27_wifiItem.setLotNumberAddress(k27_field[10]); // LotNumberAddress 필드에 열한 번째 열 값 할당
				k27_wifiItem.setManagementAgencyName(k27_field[11]); // ManagementAgencyName 필드에 열두 번째 열 값 할당
				k27_wifiItem.setManagementAgencyPhoneNumber(k27_field[12]); // ManagementAgencyPhoneNumber 필드에 열세 번째 열 값 할당
				k27_wifiItem.setLatitude(Double.parseDouble(k27_field[13])); // Latitude 필드에 열네 번째 열 값 할당
				k27_wifiItem.setLongitude(Double.parseDouble(k27_field[14])); // Longitude 필드에 열다섯 번째 열 값 할당
				k27_wifiItem.setCreated(k27_field[15]); // createdA 필드에 열여섯 번째 열 값 할당
	            
				k27_wifiItems.add(k27_wifiItem);// ArrayList에 WifiItem 객체 추가

				k27_LineCnt++;// 라인 번호 증가
			}
		} catch (NumberFormatException e) {
			//만약 오류가 발생하면
			e.printStackTrace();
			//오류 출력
		} catch (IOException e) {
			//만약 오류가 발생하면
			e.printStackTrace();
			//오류 출력
		}

		try {
			k27_br.close();// BufferedReader 닫기
		} catch (IOException e) {
			//만약 오류가 발생하면
			e.printStackTrace();
			//오류 출력
		}

		return k27_wifiItems;// wifiItems의 ArrayList 반환
	}

	public WifiItem update(WifiItem k27_wifiItem) {
		return null;
	}

	public WifiItem delete(int k27_id) {
		return null;
	}
}
