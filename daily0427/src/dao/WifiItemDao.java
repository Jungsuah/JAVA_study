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

		// ��µǰ� ���α׷��� ����
		File k27_f = new File("C:\\Users\\������\\���������������.txt");// �ش� ��ο� ���ο� ���� �����
		BufferedReader k27_br = null;
		try {
			k27_br = new BufferedReader(new FileReader(k27_f));// BufferedReader�� FileReader�� ���� ���� ��ü ����
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		String k27_readtxt;// ����� ���ڿ��� ���� ���� ����

		try {
			if ((k27_readtxt = k27_br.readLine()) == null) {// �о�� ������ ������ ���� ������
				System.out.printf("�� ���� �Դϴ�\n");// ����ϱ�
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		int k27_LineCnt = 0;
		try {
			while ((k27_readtxt = k27_br.readLine()) != null) {// �о�� ������ ������ ���� ������
				String[] k27_field = k27_readtxt.split("\t");

				// ��ü�� �� �־��ֱ�
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
			k27_br.close();// close() �޼ҵ�� BufferedWriter�� ��� ������ �˸��� GC�� �޸𸮸� ����
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
