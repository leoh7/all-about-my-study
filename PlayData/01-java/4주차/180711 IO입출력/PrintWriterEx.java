/*
	PrintStream을 가지고 Out을 만든 이유
	예외도 필요없었지
	auto flush가 됨.
	
	근데 PrintWriter는 예외 처리는 해줘야 함.
	출력하기 편안함. 1바이트 2바이트 다 받아줘서
	생성자를 봐볼까?
Constructors
PrintWriter(File file)	// 파일 경로로 파일 객체를 내놔라 / 경로랑 파일이름 주면 파일까지 만들고 스트림까지 만듬
PrintWriter(File file, String csn)
PrintWriter(OutputStream out)		// 1바이트 스트림을 주면 스트림 그냥 해주는 것
PrintWriter(OutputStream out, boolean autoFlush)	// 오토 플러쉬는 여기
PrintWriter(String fileName)		// 파일 객체로 할 필요도 없고 문자랑 파일경로 주면 만들어부러
PrintWriter(String fileName, String csn)
PrintWriter(Writer out)				// 심지어 2바이트 스트림도 주면 그냥 만들어 줌
PrintWriter(Writer out, boolean autoFlush)			// 오토 플러쉬는 여기

오토 플러쉬 없는 거는 해주면 됨
JSP 가면 오토 플러쉬 있는 애를 쓰게 될거임


*/


// 바이트(1byte) / 문자(2byte) 출력 스트림 모두를 가지고 객체를 생성

import java.io.*;
public class PrintWriterEx{
	public static void main(String[]args){		// 출력 특화 스트림임 / 입력 특화 스트림 같은건 없다.
		
		
		
		// 파일생성					c1.txt
		PrintWriter pw1 = null;
			// 1Byte 
		FileOutputStream fos = null;
		PrintWriter pw2 = null;			// fos 를 받을 PrintWriter 객체
			// 2Byte
		FileWriter fw = null;
		PrintWriter pw3 = null;


		try{
			pw1 = new PrintWriter( "c1.txt" );		// PrintWriter(String fileName) / PrintWriter(OutputStream out) 스트림 이용하는 애들만 오토플러쉬가 된다
			pw1.println( 10 );
			pw1.println( "ABC" );
			pw1.println( "가나다" );

			pw1.flush();

		// 1Byte 스트림 받아서 생성		c2.txt		// PrintWriter(OutputStream out)
			fos = new FileOutputStream( "c2.txt" );
			pw2 = new PrintWriter (fos, true);
			pw2.println(10.5);
			pw2.println( '월' );
			pw2.println("가나다");


		// 2Byte 스트림 받아서 생성		c3.txt
			fw = new FileWriter( "c3.txt" );
			pw3 = new PrintWriter (fw, true);
			pw3.println(10.58);
			pw3.println( '호' );
			pw3.println("호오오오오옹이");

		} catch( FileNotFoundException e ){
			e.printStackTrace();
		} catch( IOException e ){
			e.printStackTrace();
		} finally{
			try{
				if(	pw1 != null) pw1.close();
				if(	fos != null) fos.close();
				if(	pw2 != null) pw2.close();
				if(	fw != null) fw.close();
				if(	pw3 != null) pw3.close();
			} catch( IOException e){
				e.printStackTrace();
			}
		}
	
	}
}











