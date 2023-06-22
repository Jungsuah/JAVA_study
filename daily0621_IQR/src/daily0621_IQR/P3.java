package daily0621_IQR;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class P3 {
    public static void main(String[] args) {
        String inputFile = "C:\\Users\\a\\Desktop\\aa.csv";
        String outputFile = "C:\\Users\\a\\Desktop\\processed_aa.csv";

        try {
            List<String[]> data = readCSV(inputFile);
            List<String[]> filteredData = removeOutliers(data);

            writeCSV(outputFile, filteredData);
            System.out.println("Success");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String[]> readCSV(String fileName) throws IOException {
        List<String[]> data = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;

        // Skip the header row
        br.readLine();

        while ((line = br.readLine()) != null) {
            String[] row = line.split(",");
            String[] trimmedRow = new String[row.length - 1]; // Create a new array without the first column

            // Copy the row values starting from the second column
            for (int i = 1; i < row.length; i++) {
                trimmedRow[i - 1] = row[i];
            }

            data.add(trimmedRow);
        }

        br.close();
        return data;
    }

    private static List<String[]> removeOutliers(List<String[]> data) {
        List<String[]> filteredData = new ArrayList<>();

        int genderColumnIndex = 0;
        int educationColumnIndex = 1;

        double genderQ1 = getQuartile(data, genderColumnIndex, 1);
        double genderQ3 = getQuartile(data, genderColumnIndex, 3);
        double educationQ1 = getQuartile(data, educationColumnIndex, 1);
        double educationQ3 = getQuartile(data, educationColumnIndex, 3);

        double genderIQR = genderQ3 - genderQ1;
        double educationIQR = educationQ3 - educationQ1;

        for (String[] row : data) {
            int gender = Integer.parseInt(row[genderColumnIndex]);
            int education = Integer.parseInt(row[educationColumnIndex]);

            if (gender >= genderQ1 - 1.5 * genderIQR && gender <= genderQ3 + 1.5 * genderIQR &&
                education >= educationQ1 - 1.5 * educationIQR && education <= educationQ3 + 1.5 * educationIQR) {
                filteredData.add(row);
            }
        }

        return filteredData;
    }

    private static double getQuartile(List<String[]> data, int columnIndex, int quartile) {
        List<Integer> columnValues = new ArrayList<>();
        for (String[] row : data) {
            columnValues.add(Integer.parseInt(row[columnIndex]));
        }

        columnValues.sort(Integer::compare);

        int n = columnValues.size();
        double index = (n + 1) * quartile / 4.0;

        if (index == Math.floor(index)) {
            return columnValues.get((int) index - 1);
        } else {
            int lowerIndex = (int) Math.floor(index);
            int upperIndex = (int) Math.ceil(index);

            double lowerValue = columnValues.get(lowerIndex - 1);
            double upperValue = columnValues.get(upperIndex - 1);

            return lowerValue + (index - lowerIndex) * (upperValue - lowerValue);
        }
    }

    private static void writeCSV(String fileName, List<String[]> data) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));

        for (String[] row : data) {
            String line = String.join(",", row);
            bw.write(line);
            bw.newLine();
        }

        bw.close();
    }
}
