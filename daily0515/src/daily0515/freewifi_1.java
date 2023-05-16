package daily0515;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class freewifi_1 {
	public static void main(String[] args) throws ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		// "com.mysql.cj.jdbc.Driver" Ŭ������ �������� �ε��ϱ� ���� Java�� Class.forName �޼��带 ȣ���մϴ�.
		// �� Ŭ������ MySQL �����ͺ��̽����� ������ �����ϴ� �� ���˴ϴ�.
		// com.mysql.cj.jdbc.Driver�� MySQL Connector/J JDBC ����̹��� Ŭ���� �̸��Դϴ�.
		// �� ����̹��� Java�� MySQL �����ͺ��̽� ���� ����� �߰��ϰ� JDBC API�� �����ϴ� Ŭ�����Դϴ�.
		
		// MySQL �����ͺ��̽��� �����ϱ� ���� Connection ��ü�� �����մϴ�.
		// getConnection �޼����� ���ڷδ� JDBC URL, mysql�� ����� �̸�, mysql������� ��й�ȣ�� �Է��Ѵ�.
		// �� �ڵ忡���� jdbc:mysql://[IP �ּ�]:[mysql�� ��Ʈ��ȣ]/[mysql���� �����ϰ� ���� �����ͺ��̽� �̸�]�� ����Ͽ� �����Ѵ�.
		Connection k27_conn = null;
		try {
			k27_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// SQL���� �����ϱ� ���� Statement ��ü�� �����մϴ�.
		Statement k27_stmt= null;
		try {
			//conn��ü�� createStatement�� �޼ҵ带 ����� Statement ��ü�� �Ҵ��Ѵ�.
			k27_stmt = k27_conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();//�����߻��� ���� ������ش�
		}
		
		try {
			k27_stmt.execute("create table freewifi (" +//freewifi�� ���̺� ����
						"ROWNUM int not null primary key," + //���� ���� Ű�� �ο�
						"inst_place varchar(50)," + //��ġ��Ҹ�
						"inst_place_detail varchar(200),"+//��ġ���һ�
						"inst_city varchar(50),"+//��ġ�õ���
						"inst_country varchar(50),"+//��ġ�ñ�����
						"inst_place_flag varchar(50),"+//��ġ�ü�����
						"service_provider varchar(50),"+//�����������
						"wifi_ssid varchar(200),"+//��������SSID
						"inst_date varchar(50)," + //��ġ��� 
						"place_addr_road varchar(200),"+//���������θ��ּ�
						"place_addr_land varchar(200),"+//�����������ּ�
						"manage_office varchar(50),"+//���������
						"manage_office_phone varchar(50),"+//���������ȭ��ȣ
						"latitude double," +//����
						"longtitude double," +//�浵
						"write_date date" +//�����ͱ��س�¥
						")" + "DEFAULT CHARSET=utf8;");
		} catch (SQLException e) {
			e.printStackTrace();//�����߻��� ���� ������ش�
		}
		
		try {
			// Statement ��ü�� �ݽ��ϴ�.
			k27_stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();//�����߻��� ���� ������ش�
		}
		try {
			// Connection ��ü�� �ݽ��ϴ�.
			k27_conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
