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

	public WifiItem create(WifiItem wifiItem) {
		return null;
	}

	public WifiItem selectOne(int id) {
		return null;
	}

	public List<WifiItem> selectAll() {
		List<WifiItem> wifiItems = new ArrayList<>();

		// 출력되고 프로그램이 종료
		File k27_f = new File("C:\\Users\\정수아\\무료와이파이정보.txt");// 해당 경로에 새로운 파일 만들기
		BufferedReader k27_br = null;
		try {
			k27_br = new BufferedReader(new FileReader(k27_f));// BufferedReader에 FileReader로 읽은 파일 객체 전달
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		String k27_readtxt;// 출력할 문자열을 담을 변수 선언

		try {
			if ((k27_readtxt = k27_br.readLine()) == null) {// 읽어온 한줄이 내용이 없지 않으면
				System.out.printf("빈 파일 입니다\n");// 출력하기
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		int k27_LineCnt = 0;
		try {
			while ((k27_readtxt = k27_br.readLine()) != null) {// 읽어온 한줄이 내용이 없지 않으면
				String[] k27_field = k27_readtxt.split("\t");

				// 객체에 값 넣어주기
				WifiItem wifiItem = new WifiItem();
				wifiItem.setInstallationLocationName(k27_field[1]);
				wifiItem.setId(k27_LineCnt);
				wifiItem.setLotNumberAddress(k27_field[10]);
				wifiItem.setLatitude(Double.parseDouble(k27_field[13]));
				wifiItem.setLongitude(Double.parseDouble(k27_field[14]));
				wifiItems.add(wifiItem);

				k27_LineCnt++;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			k27_br.close();// close() 메소드로 BufferedWriter의 사용 중지를 알리고 GC가 메모리를 해제
		} catch (IOException e) {
			e.printStackTrace();
		}

		return wifiItems;
	}

	public WifiItem update(WifiItem wifiItem) {
		return null;
	}

	public WifiItem delete(int id) {
		return null;
	}

}
