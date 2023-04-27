package daily0328;

import java.io.FileWriter;
import java.io.IOException;

public class File_Handling {
	public static void main(String[] args) throws IOException {
//			처음부터 다시 쓰기 -> 해당 파일이 없어야함
//			FileOutputStream output = new FileOutputStream("C:\\test\\out.txt");
//			for (int i = 1; i < 11; i++) {
//				String data = "Line #" + i + "\n";
//					output.write(data.getBytes());
//			}
//			output.close();
		
// 		밑에 누적해서 쓰기
		FileWriter fw = new FileWriter("C:\\test\\out.csv",true);
		for (int i = 11; i < 16; i++) {
			String data = "Line #" + i + "\n";
			fw.write(data);
		}
		fw.close();
		
//		파일 삭제		
//		File file = new File("C:\\test\\out.txt");
//		System.out.println(file.exists());
//		if (file.exists()) {
//			file.delete();
//		}
//		System.out.println(file.exists());
	}
}
