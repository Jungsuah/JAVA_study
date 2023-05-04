package java_intense;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class L08_2 {
    // 파일 정제....
    public static void main(String[] args) throws IOException {
        // 입력 파일 경로 설정
        File k27_f = new File("C:\\test\\day_data\\THTSKS010H00.dat");
        // 입력 버퍼드 리더 생성
        BufferedReader k27_br = new BufferedReader(new FileReader(k27_f));
        // 출력 파일 경로 설정
        File k27_f1 = new File("C:\\test\\day_data\\20070112.csv");
        // 출력 버퍼드 라이터 생성
        BufferedWriter k27_bw1 = new BufferedWriter(new FileWriter(k27_f1));
        // 한 줄씩 읽기 위한 변수 선언
        String k27_readtxt;
        // 전체 라인 수
        int k27_cnt = 0;
        // 출력 라인 수
        int k27_wcnt = 0;

        // 입력 파일을 한 줄씩 읽어들임
        while ((k27_readtxt = k27_br.readLine()) != null) {
            // StringBuffer 생성
            StringBuffer k27_s = new StringBuffer();
            // %_% 기준으로 필드 구분
            String[] k27_field = k27_readtxt.split("%_%");
            // 필드가 2개 이상이면서 두 번째 필드에서 8자리의 문자열이 "20070112"인 경우
            if (k27_field.length > 2 && k27_field[1].replace("^", "").trim().substring(0, 8).contains("20070112")) {
                // 첫 번째 필드를 StringBuffer에 추가
                k27_s.append(k27_field[0].replace("^", "").trim());

                // 두 번째 필드부터는 ','를 추가하면서 StringBuffer에 추가
                for (int j = 1; j < k27_field.length; j++) {
                    k27_s.append("," + k27_field[j].replace("^", "").trim());
                }
                // StringBuffer를 String으로 변환하여 출력 파일에 쓰기
                k27_bw1.write(k27_s.toString());
                // 새로운 라인으로 이동
                k27_bw1.newLine();
                // 출력 라인 수 증가
                k27_wcnt++;
                // 출력 확인을 위한 출력문
                System.out.printf("write [%d] [%d] [%s]\n", k27_cnt, k27_wcnt, k27_s.toString());
            }
            // 전체 라인 수 증가
            k27_cnt++;
        }
        // 입력 버퍼드 리더 종료
        k27_br.close();
        // 출력 버퍼드 라이터 종료
        k27_bw1.close();

        // 프로그램 종료 출력문
        System.out.printf("Program End [%d] [%d] records\n", k27_cnt, k27_wcnt);
    }
}

