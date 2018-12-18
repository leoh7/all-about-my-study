import java.io.*;
import java.util.*;

class PropertiesEx2 {
	public static void main(String[] args) {
		// commandline 에서 inputfile을 지정해주지 않으면 프로그램을 종료한다.
		if(args.length != 1){
			System.out.println("USAGE: java PropertiesEx2 INPUTFILENAME");
			System.exit(0);
		}

		Properties prop = new Properties();
		String inputFile = args[0];

		try{
			prop.load(new FileInputStream("input.txt"));
		}catch(IOException e){
			System.out.println("지정된 파일을 찾을 수 없습니다.");
			System.exit(0);
		}

		String name = prop.getProperty("name");

		try{
			name = new String(name.getBytes("8859_1"), "EUC-KR");	// ("8859_1")라틴문자집합 에서 한글완성형 EUC-KR 으로 변환		
		}catch(Exception e){}

			String[] data = prop.getProperty("data").split(",");

		
	}
}
