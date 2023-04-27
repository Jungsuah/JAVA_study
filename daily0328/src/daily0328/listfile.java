package daily0328;

import java.io.File;

public class listfile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("C:\\Users\\nahyun\\Desktop\\out.txt");
		System.out.println(file.exists());
		if(file.exists()) {
			file.delete();
		}
		System.out.println(file.exists());
	}

}
