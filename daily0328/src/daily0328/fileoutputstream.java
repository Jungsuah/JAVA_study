package daily0328;

import java.io.FileOutputStream;
import java.io.IOException;

public class fileoutputstream {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileOutputStream output = new FileOutputStream("C:\\Users\\nahyun\\Desktop\\out.txt");
		for(int i = 1; i < 11; i++) {
			String data = "Line #" + i + "\n";
			output.write(data.getBytes());
		}
		output.close();
	

	}

}
