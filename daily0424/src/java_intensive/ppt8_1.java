package java_intensive;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class ppt8_1 {
	public static void main(String[] args) {
		try {
			File k27_f = new File("C:\\Users\\정수아\\test.txt"); // 해당 경로에 test.txt라는 파일 생성
			FileWriter k27_fw = new FileWriter(k27_f);// 파일에 내용을 쓸수있는 객체 생성

			k27_fw.write("안녕 파일\n");// 객체의 내장 메소드 write를 사용하여 파일에 글 작성
			k27_fw.write("hello 헬로\n");// 객체의 내장 메소드 write를 사용하여 파일에 글 작성

			k27_fw.close();// close() 메소드로 FileWriter의 사용 중지를 알리고 GC가 메모리를 해제하게 한다.

			FileReader k27_fr = new FileReader(k27_f);// 파일의 내용을 읽어올수있는 객체 생성

			int k27_n = -1;// 파일에서 읽어온 내용이 없을때 사용하기 위한 변수 생성
			char[] k27_ch;// 파일에서 읽어온 글자를 담기위한 배열을 선언

			while (true) {// 조건이 true 동안 반복하기
				k27_ch = new char[100];// 배열의 크기를 100으로 반복문이 돌때마다 초기화
				k27_n = k27_fr.read(k27_ch);// FileReader의 내장 메소드 read를 호출하여 리턴값인 ch배열의 length를 n에 저장한다.

				if (k27_n == -1) {// n = -1이면 break를 실행하고 반복문을 빠져나온다 -> 더이상 읽어올 내용이 없을때 -1이 반환되기때문에
					break;
				}

				for (int k27_i = 0; k27_i < k27_n; k27_i++) {// 읽어올 내용이 있다면 배열의 길이만큼 for문을 돈다
					System.out.printf("%c", k27_ch[k27_i]);// 반복문을 돌면서 한글자씩 출력한다
				}
			}

			k27_fr.close();// close() 메소드로 FileReader의 사용 중지를 알리고 GC가 메모리를 해제하게 한다.

			System.out.println("\n FILE READ END");// 출력이 끝나면 알려주기 위해 사용
		} catch (Exception k27_e) {// 만일 파일이 생성되어있지 않을경우 try 영역에서 오류가 발생하고 catch에서 잡아서 오류가 발생했을시에 오류메시지를 출력해준다.
			System.out.printf("나 에러[%s]\n", k27_e);// 오류메시지 출력
		}
	}
}
