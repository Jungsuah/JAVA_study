package Basic_Traning_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Basic_Traning_1 {
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
			//cctv ���̺� �����ϴ� ����
			k27_stmt.execute("create table cctv(" +//freewifi�� ���̺� ����
						"ROWNUM int not null primary key," + //���� ���� Ű�� �ο�
						"manage_place varchar(200)," + //���������
						"place_addr_road varchar(200),"+//���������θ��ּ�
						"place_addr_land varchar(500),"+//�����������ּ�
						"inst_purpose varchar(50),"+//��ġ��������
						"inst_camera int,"+//ī�޶���
						"inst_camera_pixel int,"+//ī�޶�ȭ�Ҽ�
						"inst_camera_detail varchar(500),"+//�Կ��������
						"storage_days varchar(50),"+//�����ϼ�
						"inst_date varchar(50)," + //��ġ��� 
						"manage_office_phone varchar(50),"+//���������ȭ��ȣ
						"latitude double," +//����
						"longtitude double," +//�浵
						"write_date date" +//�����ͱ��س�¥
						")" + "DEFAULT CHARSET=utf8;");
			
			//cctv ���̺� �����ϴ� ����
			//stmt.execute("drop table cctv;");
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
