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

	public List<WifiItem> selectAll() {//WifiItem ��ü���� ����Ʈ�� ��ȯ�ϴ� �޼ҵ� selectAll

		List<WifiItem> wifiItems = new ArrayList<>();//WifiItem ��ü���� ���� ArrayList ��ü ����

		File k27_f = new File("C:\\Users\\������\\���������������.txt");// ��ο� ���� ��ü ����
		BufferedReader k27_br = null;// BufferedReader ��ü ����
		try {
			k27_br = new BufferedReader(new FileReader(k27_f));// BufferedReader ��ü�� FileReader�� ���� ���� ��ü ����
		} catch (FileNotFoundException e) {
			//���� ������ �������� �ʴ´ٸ�
			e.printStackTrace();
			//���� ���
		}

		String k27_readtxt;// ����� ���ڿ��� ���� ���� ����

		try {
			if ((k27_readtxt = k27_br.readLine()) == null) {// ���پ� �о���� -> ���� null�̶��
				System.out.printf("�� ���� �Դϴ�\n");// �� ���� �Դϴ� ����ϰ�
			}
		} catch (IOException e) {
			//���� ������ �߻��ϸ�
			e.printStackTrace();
			//���� ���
		}

		int k27_LineCnt = 0;// ���� ��ȣ�� ��Ÿ���� ���� �ʱ�ȭ
		try {
			while ((k27_readtxt = k27_br.readLine()) != null) {// ���Ͽ��� �� �� ���پ� �о����
				String[] k27_field = k27_readtxt.split("\t");// �о�� ���ڿ��� ������ �и��Ͽ� ���ڿ� �迭�� ����


				// WifiItem ��ü ����
				WifiItem wifiItem = new WifiItem();

				// �� �ʵ� �� �Ҵ�
				wifiItem.setId(Integer.parseInt(k27_field[0])); // id �ʵ忡 ù ��° �� �� �Ҵ�
				wifiItem.setInstallationLocationName(k27_field[1]); // InstallationLocationName �ʵ忡 �� ��° �� �� �Ҵ�
				wifiItem.setInstallationLocationDetails(k27_field[2]); // InstallationLocationDetails �ʵ忡 �� ��° �� �� �Ҵ�
				wifiItem.setInstallationCityName(k27_field[3]); // InstallationCityName �ʵ忡 �� ��° �� �� �Ҵ�
				wifiItem.setInstallationDistrictName(k27_field[4]); // InstallationDistrictName �ʵ忡 �ټ� ��° �� �� �Ҵ�
				wifiItem.setInstallationFacilityType(k27_field[5]); // installationFacilityType �ʵ忡 ���� ��° �� �� �Ҵ�
				wifiItem.setServiceProviderName(k27_field[6]); // ServiceProviderName �ʵ忡 �ϰ� ��° �� �� �Ҵ�
				wifiItem.setWifiSsid(k27_field[7]); // wifiSsid �ʵ忡 ���� ��° �� �� �Ҵ�
				wifiItem.setDateOfInstallation(k27_field[8]); // dateOfInstallation �ʵ忡 ��ȩ ��° �� �� �Ҵ�
				wifiItem.setRoadNameAddress(k27_field[9]); // RoadNameAddress �ʵ忡 �� ��° �� �� �Ҵ�
				wifiItem.setLotNumberAddress(k27_field[10]); // LotNumberAddress �ʵ忡 ���� ��° �� �� �Ҵ�
				wifiItem.setManagementAgencyName(k27_field[11]); // ManagementAgencyName �ʵ忡 ���� ��° �� �� �Ҵ�
				wifiItem.setManagementAgencyPhoneNumber(k27_field[12]); // ManagementAgencyPhoneNumber �ʵ忡 ���� ��° �� �� �Ҵ�
				wifiItem.setLatitude(Double.parseDouble(k27_field[13])); // Latitude �ʵ忡 ���� ��° �� �� �Ҵ�
				wifiItem.setLongitude(Double.parseDouble(k27_field[14])); // Longitude �ʵ忡 ���ټ� ��° �� �� �Ҵ�
				wifiItem.setCreated(k27_field[15]); // createdA �ʵ忡 ������ ��° �� �� �Ҵ�
	            
				wifiItems.add(wifiItem);// ArrayList�� WifiItem ��ü �߰�

				k27_LineCnt++;// ���� ��ȣ ����
			}
		} catch (NumberFormatException e) {
			//���� ������ �߻��ϸ�
			e.printStackTrace();
			//���� ���
		} catch (IOException e) {
			//���� ������ �߻��ϸ�
			e.printStackTrace();
			//���� ���
		}

		try {
			k27_br.close();// BufferedReader �ݱ�
		} catch (IOException e) {
			//���� ������ �߻��ϸ�
			e.printStackTrace();
			//���� ���
		}

		return wifiItems;// wifiItems�� ArrayList ��ȯ
	}

	public WifiItem update(WifiItem wifiItem) {
		return null;
	}

	public WifiItem delete(int id) {
		return null;
	}
}
