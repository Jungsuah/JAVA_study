package daily0515;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class freewifi_2 {
	public static void main(String[] args) throws Exception {
		// "com.mysql.cj.jdbc.Driver" Ŭ������ �������� �ε��ϱ� ���� Java�� Class.forName �޼��带 ȣ���մϴ�.
		// �� Ŭ������ MySQL �����ͺ��̽����� ������ �����ϴ� �� ���˴ϴ�.
		// com.mysql.cj.jdbc.Driver�� MySQL Connector/J JDBC ����̹��� Ŭ���� �̸��Դϴ�.
		// �� ����̹��� Java�� MySQL �����ͺ��̽� ���� ����� �߰��ϰ� JDBC API�� �����ϴ� Ŭ�����Դϴ�.
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// MySQL �����ͺ��̽��� �����ϱ� ���� Connection ��ü�� �����մϴ�.
		// getConnection �޼����� ���ڷδ� JDBC URL, mysql�� ����� �̸�, mysql������� ��й�ȣ�� �Է��Ѵ�.
		// �� �ڵ忡���� jdbc:mysql://[IP �ּ�]:[mysql�� ��Ʈ��ȣ]/[mysql���� �����ϰ� ���� �����ͺ��̽� �̸�]�� ����Ͽ� �����Ѵ�.
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

		// SQL���� �����ϱ� ���� Statement ��ü�� �����մϴ�.
		Statement stmt = conn.createStatement();

		// main �޼ҵ忡�� IOException�� throws�ϸ�, �ش� ���ܴ� JVM���� ���޵Ǿ� ��µǰ� ���α׷��� ����
		File k27_f = new File("C:\\Users\\������\\Desktop\\beforedata\\���������������ǥ�ص�����b.txt");// �ش� ��ο� ���� ã�ƿ���
		BufferedReader k27_br = new BufferedReader(new FileReader(k27_f));// BufferedReader�� FileReader�� ���� ���� ��ü ����

		String k27_readtxt;// ����� ���ڿ��� ���� ���� ����

		if ((k27_readtxt = k27_br.readLine()) == null) {// �о�� ������ ������ ���� ������
			System.out.printf("�� ���� �Դϴ�\n");// ����ϱ�
			return;// ȣ���Ѱ����� ���ư���
		}
		String[] k27_field_name = k27_readtxt.split("\t");// csv ������ tab�� �������� �����͸� �ڸ����ֱ⶧���� �߶� �迭�� �ֱ�
		
		int k27_LineCnt = 0;// �ٰ����� �����ִ� ������ ���� ����
		while ((k27_readtxt = k27_br.readLine()) != null) {// �о�� ������ ������ ������
			String[] k27_field = k27_readtxt.split("\t");// ,�� �������� �ڸ������� �迭�� ��´�
			
			String k27_QueryTxt;//������ ����� ������ ���� ����
			
			//�����ϴ� insert���� �ۼ��ؼ� Į���� ���缭 ������ �����Ѵ�. ->�ϼ���
			k27_QueryTxt = String.format("insert into freewifi ("
					+ "ROWNUM, inst_place ,inst_place_detail ,inst_city,inst_country ,inst_place_flag ,"
					+ "service_provider ,wifi_ssid ,inst_date ,place_addr_road ,place_addr_land,"
					+ "manage_office ,manage_office_phone ,latitude ,longtitude ,write_date )"
					+ "values ("
					+ " '%s', '%s','%s','%s','%s','%s',"
					+ " '%s','%s','%s','%s','%s',"
					+ " '%s','%s','%s','%s','%s');", 
					k27_field[0],k27_field[1],k27_field[2],k27_field[3],k27_field[4],
					k27_field[5],k27_field[6],k27_field[7],k27_field[8],k27_field[9],
					k27_field[10],k27_field[11],k27_field[12],k27_field[13],k27_field[14], k27_field[15]);
			
			//�����ϴ� insert���� �ۼ��ؼ� Į���� ���缭 ������ �����Ѵ�.
//			k27_QueryTxt = String.format("insert into freewifi ("
//					+ "inst_place ,inst_place_detail ,inst_city,inst_country ,inst_place_flag ,"
//					+ "service_provider ,wifi_ssid ,inst_date ,place_addr_road ,place_addr_land,"
//					+ "manage_office ,manage_office_phone ,latitude ,longtitude ,write_date )"
//					+ "values ("
//					+ " '%s','%s','%s','%s','%s',"
//					+ " '%s','%s','%s','%s','%s',"
//					+ " '%s','%s','%s','%s','%s');", 
//					k27_field[0],k27_field[1],k27_field[2],k27_field[3],k27_field[4],
//					k27_field[5],k27_field[6],k27_field[7],k27_field[8],k27_field[9],
//					k27_field[10],k27_field[11],k27_field[12],k27_field[13],k27_field[14]);
			
			stmt.execute(k27_QueryTxt);//Statement��ü�� execute �޼ҵ带 ���� ������� �������� �����Ѵ�.
			//���� �ִ� �׸��� ���° �׸����� ������ش�.
			System.out.printf("%d��° �׸� Insert OK [%s]\n" , k27_LineCnt, k27_QueryTxt);
			
			
			k27_LineCnt++;//������ �о���� ��Ƚ���� �߰��Ѵ�.
			
		}
		k27_br.close();// close() �޼ҵ�� BufferedWriter�� ��� ������ �˸��� GC�� �޸𸮸� ����

		stmt.close();// Statement ��ü�� �ݽ��ϴ�.
		conn.close();// Connection ��ü�� �ݽ��ϴ�.
	}
}
