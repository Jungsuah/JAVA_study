package daily0619_Encryption;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LottoAnalysis {
    public static void main(String[] args) {
        // CSV 파일 경로
        String csvFile = "C:\\Users\\a\\Desktop\\로또.csv";
        // 결과를 저장할 CSV 파일 경로
        String resultFile = "C:\\Users\\a\\Desktop\\lotto.csv";

        // 보너스 번호 출현 빈도를 저장할 Map
        Map<String, Integer> bonusNumberFrequency = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(resultFile))) {

            // 첫 번째 줄(헤더)을 읽어올 필요 없으므로 무시
            br.readLine();

            // 보너스 번호 출현 빈도 계산
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(","); // CSV 데이터 구분 기호에 따라 수정

                String bonusNumber = data[7]; // 보너스 번호 위치에 따라 수정
                System.out.println("bonusNumber : " + bonusNumber);

                // 보너스 번호 출현 빈도 업데이트
                bonusNumberFrequency.put(bonusNumber, bonusNumberFrequency.getOrDefault(bonusNumber, 0) + 1);
            }

            // 결과 파일에 보너스 번호 출현 빈도 쓰기
            bw.write("Bonus Number,Frequency");
            bw.newLine();
            for (Map.Entry<String, Integer> entry : bonusNumberFrequency.entrySet()) {
                String bonusNumber = entry.getKey();
                int frequency = entry.getValue();

                String resultLine = bonusNumber + "," + frequency;
                bw.write(resultLine);
                bw.newLine();
            }

            System.out.println("분석이 완료되었습니다. 결과가 " + resultFile + "에 저장되었습니다.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
