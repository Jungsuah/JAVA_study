package daily0615_CSV;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

public class P1 {
	public static void main(String[] args) {
		String readFileName = "C:\\Users\\a\\Desktop\\국민 해외관광객 주요 목적지별 통계(202303).csv";
		String writeFileName = "C:\\Users\\a\\Desktop\\국민 해외관광객 주요 목적지별 통계(202303)_new.csv";
		try {
			int sum = 0;
			double avg = 0;
			CSVReader csvReader;
			csvReader = new CSVReader(new InputStreamReader(new FileInputStream(readFileName), "CP949"));
			CSVWriter cw = new CSVWriter(new OutputStreamWriter(new FileOutputStream(writeFileName), "CP949"));
			String[] nextLine;
			int count = 0;
			List<String[]> one = new ArrayList<>();
			try {
				while ((nextLine = csvReader.readNext()) != null) {
					if (count == 0) {
						String str = String.join(",", nextLine) + ",rowsum,rowavg";
						System.out.println("!!" + str);
						one.add(str.split(","));
					} else {
						String ar = String.join(",", nextLine);
						String[] array = ar.split(",");
						sum = 0;
						for (int i = 1; i < array.length; i++) {
							sum += Integer.parseInt(array[i]);
						}
						avg = (double) sum / (array.length - 1);
						String snextLine = String.join(",", nextLine) + "," + sum + "," + avg;
						System.out.println("!!" + snextLine);
						one.add(snextLine.split(","));
					}
					count++;
				}
			} catch (CsvValidationException e) {
				e.printStackTrace();
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}

			int col = 0;
			List<String> colsum = new ArrayList<>();
			List<String> colavg = new ArrayList<>();
			colsum.add("colsum");
			colavg.add("colavg");
			col = one.get(0).length;
			
			String[][] arr = new String[count][col];

			for (int i = 0; i < one.size(); i++) {
				arr[i] = one.get(i);
			}

			for (int i = 1; i < arr[0].length; i++) {
				for (int j = 1; j < count - 1; j++) {
					sum += (int) Double.parseDouble(arr[j][i]);
				}
				colsum.add(String.valueOf(sum));
				colavg.add(String.valueOf(sum / count));
			}

			System.out.println(colsum.toString());
			System.out.println(colavg.toString());

			one.add(colsum.toArray(new String[colsum.size()]));
			one.add(colavg.toArray(new String[colavg.size()]));
			
			for (String[] array : one) {
			    cw.writeNext(array);
			}
			
			cw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}