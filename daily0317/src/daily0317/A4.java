package daily0317;

public class A4 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final int Month = 3;
		final int Hour;
		Hour = 24;
		//Month = 13;
		System.out.println(Hour);
		System.out.println(Month);
		   
		int age1 = 30;
		double weight = 68.5;
		String name = "John";
		        
		System.out.println(name + "�� ���̴� " + age1 + "���̰�, ü���� " + weight + "kg�Դϴ�.");
		
		  byte b = 127;
	      short s = 32767;
	      int i = 2147483647;
	      long l = 9223372036854775807L;
	        
	      // �Ǽ���
	      float f = 3.141592F;
	      double d = 3.141592653589793;
	        
	       // ������
	      char c = 'A';
	      String str = "Hello, world!";
	        
	      System.out.println("byte: " + b);
	      System.out.println("short: " + s);
	      System.out.println("int: " + i);
	      System.out.println("long: " + l);
	      System.out.println("float: " + f);
	      System.out.println("double: " + d);
	      System.out.println("char: " + c);
	      System.out.println("String: " + str);
	      
	      int age2 = 30;
	        
	        // if ����
	        if (age2 >= 20) {
	            System.out.println("�����Դϴ�.");
	        } else {
	            System.out.println("�̼������Դϴ�.");
	        }
	        
	        // switch ����
	        int score = 85;
	        switch (score / 10) {
	            case 10:
	            case 9:
	                System.out.println("A�����Դϴ�.");
	                break;
	            case 8:
	                System.out.println("B�����Դϴ�.");
	                break;
	            case 7:
	                System.out.println("C�����Դϴ�.");
	                break;
	            case 6:
	                System.out.println("D�����Դϴ�.");
	                break;
	            default:
	                System.out.println("F�����Դϴ�.");
	                break;
	        }
	}
}
