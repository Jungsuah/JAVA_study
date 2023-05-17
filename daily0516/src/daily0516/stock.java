package daily0516;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class stock {
    public static void main(String[] args) throws IOException {
    	// 입력 파일 경로 지정
    	File k27_f = new File("C:\\test\\day_data\\THTSKS010H00.dat");
    	//BufferedReader 객체를 생성하고 입력 파일을 파라미터로 넘겨준다.
        BufferedReader k27_br = new BufferedReader(new FileReader(k27_f));
        
        //지정 경로에 해당 파일을 가져오기 -> 없으면 새로 생성
        File k27_f1 = new File("C:\\test\\day_data\\A005930.csv");
        //BufferedWriter 객체를 생성하고 파일을 파라미터로 넘겨 파일안에 내용 작성하게 한다.
        BufferedWriter k27_bw1 = new BufferedWriter(new FileWriter(k27_f1));
        
        String k27_readtxt;//한줄을 받아올 문자열 객체 선언
        int k27_cnt = 0;//파일을 읽은 횟수
        int k27_wcnt = 0;//StringBuffer에 데이터를 담은 횟수

        while ((k27_readtxt = k27_br.readLine()) != null) {// 읽어온 라인이 null이 아니면 계속 읽어들인다.
            StringBuffer k27_s = new StringBuffer();//StringBuffer 객체를 선언하고 초기화한다.
            String[] k27_field = k27_readtxt.split("%_%");//split()메소드로 _를 구분자로 필드값을 나눠서 저장한다.

            if (k27_field.length > 2 && k27_field[2].replace("^", "").trim().substring(0, 1).equals("A")) {
            	//k27_field의 길이가 2이상이고 두번째 필드 값에 1번째 글자가 A이면
                k27_s.append(k27_field[2].replace("^", "").trim());//유가증권 단축 종목코드를 StringBuffer에 담기
                k27_s.append("," + k27_field[1].replace("^", "").trim());//주식 영업 일자를 StringBuffer에 담기
                k27_s.append("," + k27_field[4].replace("^", "").trim());//주식 종가를 StringBuffer에 담기
                k27_s.append("," + k27_field[5].replace("^", "").trim());//주식 시가를 StringBuffer에 담기
                k27_s.append("," + k27_field[6].replace("^", "").trim());//주식 최고가를 StringBuffer에 담기
                k27_s.append("," + k27_field[3].replace("^", "").trim());//주식 최저가를 StringBuffer에 담기
                k27_s.append("," + k27_field[11].replace("^", "").trim());//누적 거래량을 StringBuffer에 담기 
                k27_s.append("," + k27_field[12].replace("^", "").trim());//누적 거래 대금을 StringBuffer에 담기

                k27_bw1.write(k27_s.toString());//append로 담은 문자열을 write 메소드로 파일에 작성
                k27_bw1.newLine();//한줄쓰고 줄넘김하기

                k27_wcnt++;//한번 파일을 담았음으로 +1하기
                System.out.printf("write [%d] [%d] [%s]\n", k27_cnt, k27_wcnt, k27_s.toString());
            }
            k27_cnt++;//파일의 한줄을 읽었음으로 +1하기
        }
        k27_br.close();//BufferedReader 객체 닫기
        k27_bw1.close();//BufferedWriter 객체 닫기

        //전부 담으면 마지막으로 출력하기
        System.out.printf("Program End [%d] [%d] records\n", k27_cnt, k27_wcnt);
    }
}