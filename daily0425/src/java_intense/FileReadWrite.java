package java_intense;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReadWrite {

	public static void k27_FileWrite() throws IOException {//파일에 글 쓸수있는 메소드 생성 => 오류가 생기면 throws 선언을 통해 해당 예외를 상위 메소드로 전달
		File k27_f = new File("C:\\Users\\정수아\\test.txt");//해당 경로에 새로운 파일 만들기
		BufferedWriter k27_bw = new BufferedWriter(new FileWriter(k27_f));//BufferedWriter에 FileWriter 객체 전달
		k27_bw.write("안녕 파일");//BufferedWriter의 write 메소드를 통해 파일에 내용 작성
		k27_bw.newLine();//BufferedWriter의 newLine 메소드를 통해 줄넘김
		k27_bw.write("hello 헬로");//BufferedWriter의 write 메소드를 통해 파일에 내용 작성
		k27_bw.newLine();//BufferedWriter의 newLine 메소드를 통해 줄넘김
		k27_bw.close();// close() 메소드로 BufferedWriter의 사용 중지를 알리고 GC가 메모리를 해제
	}

	public static void k27_FileRead() throws IOException {//파일에 있는 글을 읽을수있는 메소드 생성 => 오류가 생기면 throws 선언을 통해 해당 예외를 상위 메소드로 전달
		File k27_f = new File("C:\\Users\\정수아\\test.txt");//해당 경로에 파일 찾아오기
		BufferedReader k27_br = new BufferedReader(new FileReader(k27_f));//BufferedReader에 FileReader로 읽은 파일 객체 전달
		String k27_readtxt;//출력할 문자열을 담을 변수 선언
		while ((k27_readtxt = k27_br.readLine()) != null) {//읽어온 한줄이 내용이 없지 않으면
			System.out.printf("%s\n", k27_readtxt);//출력하기
		}
		k27_br.close();// close() 메소드로 BufferedWriter의 사용 중지를 알리고 GC가 메모리를 해제
	}

	public static void main(String[] args) throws IOException {//main 메소드에서 IOException을 throws하면, 해당 예외는 JVM으로 전달되어 출력되고 프로그램이 종료
		k27_FileWrite();//파일에 글쓰는 메소드 호출
		k27_FileRead();//파일을 읽어오는 메소드 호출
	}
}
