package daily0621_IQR;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P2 {
    public static void main(String[] args) {
        String csvFile = "C:/Users/a/Desktop/aa.csv"; // 파일 경로
        String outputCsvFile = "C:/Users/a/Desktop/processed_aa.csv"; // Output file path
        String line;
        String csvSplitBy = ","; // CSV 파일의 열 구분자

        List<Integer> stressLevelData = new ArrayList<>(); // List to store Stress Level data
        List<Integer> heartRateData = new ArrayList<>(); // List to store Heart Rate data
        List<Integer> dailyStepsData = new ArrayList<>(); // List to store Daily Steps data

        boolean firstRow = true; // Flag to skip the first row

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                if (firstRow) {
                    firstRow = false;
                    continue; // Skip the first row
                }

                String[] columns = line.split(csvSplitBy);

                int stressLevel = Integer.parseInt(columns[1]);
                stressLevelData.add(stressLevel);

                int heartRate = Integer.parseInt(columns[2]);
                heartRateData.add(heartRate);

                int dailySteps = Integer.parseInt(columns[3]);
                dailyStepsData.add(dailySteps);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<int[]> dataList = new ArrayList<>();
        dataList.add(stressLevelData.stream().mapToInt(Integer::intValue).toArray());
        dataList.add(heartRateData.stream().mapToInt(Integer::intValue).toArray());
        dataList.add(dailyStepsData.stream().mapToInt(Integer::intValue).toArray());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputCsvFile))) {
            for (int[] row : dataList) {
                Arrays.sort(row);

                double q1 = percentile(row, 25);
                double q2 = percentile(row, 50);
                double q3 = percentile(row, 75);
                double iqr = q3 - q1;
                double min = q1 - 1.5 * iqr;
                double max = q3 + 1.5 * iqr;

                StringBuilder filteredRow = new StringBuilder();
                for (int value : row) {
                    if (value >= min && value <= max) {
                        filteredRow.append(value).append(",");
                    }
                }
                if (filteredRow.length() > 0) {
                    filteredRow.deleteCharAt(filteredRow.length() - 1); // Remove the trailing comma
                    writer.write(filteredRow.toString());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double percentile(int[] array, double percentile) {
        int n = array.length;
        double index = (percentile / 100.0) * (n - 1); // 백분위수에 해당하는 인덱스 계산
        int floor = (int) Math.floor(index); // 내림하여 하한값 인덱스 계산
        int ceil = (int) Math.ceil(index); // 올림하여 상한값 인덱스 계산

        if (floor == ceil) {
            return array[floor]; // 하한값과 상한값이 같으면 해당 인덱스의 요소 반환
        }

        double lowerValue = array[floor]; // 하한값의 요소
        double upperValue = array[ceil]; // 상한값의 요소

        // 하한값과 상한값 사이에 비례하여 값 보기
        return lowerValue + (index - floor) * (upperValue - lowerValue);
    }
}
