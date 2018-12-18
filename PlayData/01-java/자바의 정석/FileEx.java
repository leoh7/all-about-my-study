import java.io.*;

class FileEx {
	public static void main (String[]args) throws IOException {
		File f = new File ("c:\\jdk1.8\\work\\ch15\\FileEx1.java");
		String fileName = f.getName();
		int pos = fileName.lastIndexOf(".");

		System.out.println("경로를 제외한 파일이름 - " + f.getName() );
		System.out.println("확장자를 제외한 파일이름 - " + fileName.substring(0, pos) );
	}
}