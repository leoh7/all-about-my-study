import java.io.*;

class FileEx {
	public static void main (String[]args) throws IOException {
		File f = new File ("c:\\jdk1.8\\work\\ch15\\FileEx1.java");
		String fileName = f.getName();
		int pos = fileName.lastIndexOf(".");

		System.out.println("��θ� ������ �����̸� - " + f.getName() );
		System.out.println("Ȯ���ڸ� ������ �����̸� - " + fileName.substring(0, pos) );
	}
}