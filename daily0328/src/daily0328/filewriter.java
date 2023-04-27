package daily0328;

import java.io.FileWriter;
import java.io.IOException;

public class filewriter {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileWriter fw = new FileWriter ("C:\\Users\\nahyun\\Desktop\\out.txt",true);
		for(int i = 11; i <16; i++) {
			String data = "# Line" + i + "\n";
			fw.write(data);
		}
		fw.close();
	}

}
