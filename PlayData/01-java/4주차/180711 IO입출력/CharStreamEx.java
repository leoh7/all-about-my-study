// 2Byte ������ ��������� + ����

/*
			1Byte		2Byte		1Byte -> 2Byte
 �Է�	InputStream		Reader		InputStreamReader
 ���	OutputStream	Writer		OutputStreamWriter

*/

import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;

class CharStreamEx {
	public static void main(String[]args){
		// 2Byte ��� b.txt -> b1.txt

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

//			while( (data = br.read() ) != -1){		// read() �� �� ���ھ� �ۿ� �� �б� ������ �����ϴ�. -> readLine() �� ���� �� �� ��(���ͱ���) ���� �� �ִ� / ��� ���ϰ��� String��
//				System.out.print((char) data );		// Ȯ�ο�
//				bw.write( data );
//			}
			while( (msg = br.readLine() ) != null){		// read() �� �� ���ھ� �ۿ� �� �б� ������ �����ϴ�. -> readLine() �� ���� �� �� ��(���ͱ���) ���� �� �ִ� / ��� ���ϰ��� String�� // �Դٰ� ���͸� �߶������, ���ʹ� �����Ͱ� �ƴѰɷ� �ν��� �ϴ� ��.
				System.out.println( msg );				// ���Ͽ� �� ����??? println�� �ȵ��ݾ�?
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