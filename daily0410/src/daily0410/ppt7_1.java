package daily0410;

public class ppt7_1 {
	public static void main(String[] args) {
		System.out.printf("HanBlackForeword[%s]\n", HanBlackForeword("한글abcd", 15));
		System.out.printf("HanBlackForeword[%s]\n", HanBlackForeword("한글abcd", 15));
		System.out.printf("HanBlackBackword[%s]\n", HanBlackBackword("한글abcd", 15));
		System.out.printf("HanBlackBackword[%s]\n", HanBlackBackword("한글abcd", 15));
		System.out.printf("한글은 [%d]개\n", HanCount("한글한a"));
	}

	private static int HanCount(String string) {
		int count = 0;// 바이트수
		byte[] k27_by = string.getBytes();
		for (int i = 0; i < k27_by.length; i++) {//문자의 한칸이 2바이트면
			if ((k27_by[i] & 0x80) == 0x80) { // by[i]가 한글이면
				count++;
			}
		}
		return count / 2;
	}

	private static String HanBlackBackword(String string, int i) {
		for (int j = 0; j < i; j++) {
			string = " " + string;
		}
		return string;
	}

	private static Object HanBlackForeword(String string, int i) {
		for (int j = 0; j < i; j++) {
			string = string + " ";
		}
		return string;
	}
}
