// 2Byte 단위로 파일입출력 + 버퍼

/*
			1Byte		2Byte		1Byte -> 2Byte
 입력	InputStream		Reader		InputStreamReader
 출력	OutputStream	Writer		OutputStreamWriter

*/

import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;

class CharStreamEx {
	public static void main(String[]args){
		// 2Byte 기반 b.txt -> b1.txt

		//int data = 0;
		String msg = null;
		FileReader fr = null;
		FileWriter fw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;

		try{
			fr = new FileReader( "b.txt" );
			fw = new FileWriter( "b1.txt" );
			br = new BufferedReader( fr );
			bw = new BufferedWriter( fw );

//			while( (data = br.read() ) != -1){		// read() 가 한 글자씩 밖에 못 읽기 때문에 불편하다. -> readLine() 을 쓰면 한 줄 씩(엔터기준) 받을 수 있다 / 대신 리턴값이 String임
//				System.out.print((char) data );		// 확인용
//				bw.write( data );
//			}
			while( (msg = br.readLine() ) != null){		// read() 가 한 글자씩 밖에 못 읽기 때문에 불편하다. -> readLine() 을 쓰면 한 줄 씩(엔터기준) 받을 수 있다 / 대신 리턴값이 String임 // 게다가 엔터를 잘라버린다, 엔터는 데이터가 아닌걸로 인식을 하는 것.
				System.out.println( msg );				// 파일에 쓸 때는??? println이 안되잖아?
				bw.write( msg );
				bw.newLine();
			}

			bw.flush();
	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		} finally {
			try{
				if( fr != null ) fr.close();
				if( fw != null ) fw.close();
				if( br != null ) br.close();
				if( bw != null ) bw.close();
			} catch (IOException e){
				e.printStackTrace();
			}
		}
	
	}

}