import java.io.*;
import java.util.*;

class PropertiesEx2 {
	public static void main(String[] args) {
		// commandline ���� inputfile�� ���������� ������ ���α׷��� �����Ѵ�.
		if(args.length != 1){
			System.out.println("USAGE: java PropertiesEx2 INPUTFILENAME");
			System.exit(0);
		}

		Properties prop = new Properties();
		String inputFile = args[0];

		try{
			prop.load(new FileInputStream("input.txt"));
		}catch(IOException e){
			System.out.println("������ ������ ã�� �� �����ϴ�.");
			System.exit(0);
		}

		String name = prop.getProperty("name");

		try{
			name = new String(name.getBytes("8859_1"), "EUC-KR");	// ("8859_1")��ƾ�������� ���� �ѱۿϼ��� EUC-KR ���� ��ȯ		
		}catch(Exception e){}

			String[] data = prop.getProperty("data").split(",");

		
	}
}
