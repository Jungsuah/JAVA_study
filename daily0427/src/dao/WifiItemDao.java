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

	public List<WifiItem> selectAll() {//WifiItem ��ü���� ����Ʈ�� ��ȯ�ϴ� �޼ҵ� selectAll

		List<WifiItem> k27_wifiItems = new ArrayList<>();//WifiItem ��ü���� ���� ArrayList ��ü ����

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
				WifiItem k27_wifiItem = new WifiItem();

				// �� �ʵ� �� �Ҵ�
				k27_wifiItem.setId(Integer.parseInt(k27_field[0])); // id �ʵ忡 ù ��° �� �� �Ҵ�
				k27_wifiItem.setInstallationLocationName(k27_field[1]); // InstallationLocationName �ʵ忡 �� ��° �� �� �Ҵ�
				k27_wifiItem.setInstallationLocationDetails(k27_field[2]); // InstallationLocationDetails �ʵ忡 �� ��° �� �� �Ҵ�
				k27_wifiItem.setInstallationCityName(k27_field[3]); // InstallationCityName �ʵ忡 �� ��° �� �� �Ҵ�
				k27_wifiItem.setInstallationDistrictName(k27_field[4]); // InstallationDistrictName �ʵ忡 �ټ� ��° �� �� �Ҵ�
				k27_wifiItem.setInstallationFacilityType(k27_field[5]); // installationFacilityType �ʵ忡 ���� ��° �� �� �Ҵ�
				k27_wifiItem.setServiceProviderName(k27_field[6]); // ServiceProviderName �ʵ忡 �ϰ� ��° �� �� �Ҵ�
				k27_wifiItem.setWifiSsid(k27_field[7]); // wifiSsid �ʵ忡 ���� ��° �� �� �Ҵ�
				k27_wifiItem.setDateOfInstallation(k27_field[8]); // dateOfInstallation �ʵ忡 ��ȩ ��° �� �� �Ҵ�
				k27_wifiItem.setRoadNameAddress(k27_field[9]); // RoadNameAddress �ʵ忡 �� ��° �� �� �Ҵ�
				k27_wifiItem.setLotNumberAddress(k27_field[10]); // LotNumberAddress �ʵ忡 ���� ��° �� �� �Ҵ�
				k27_wifiItem.setManagementAgencyName(k27_field[11]); // ManagementAgencyName �ʵ忡 ���� ��° �� �� �Ҵ�
				k27_wifiItem.setManagementAgencyPhoneNumber(k27_field[12]); // ManagementAgencyPhoneNumber �ʵ忡 ���� ��° �� �� �Ҵ�
				k27_wifiItem.setLatitude(Double.parseDouble(k27_field[13])); // Latitude �ʵ忡 ���� ��° �� �� �Ҵ�
				k27_wifiItem.setLongitude(Double.parseDouble(k27_field[14])); // Longitude �ʵ忡 ���ټ� ��° �� �� �Ҵ�
				k27_wifiItem.setCreated(k27_field[15]); // createdA �ʵ忡 ������ ��° �� �� �Ҵ�
	            
				k27_wifiItems.add(k27_wifiItem);// ArrayList�� WifiItem ��ü �߰�

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

		return k27_wifiItems;// wifiItems�� ArrayList ��ȯ
	}

	public WifiItem update(WifiItem k27_wifiItem) {
		return null;
	}

	public WifiItem delete(int k27_id) {
		return null;
	}
}
