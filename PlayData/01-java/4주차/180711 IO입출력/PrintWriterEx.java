/*
	PrintStream�� ������ Out�� ���� ����
	���ܵ� �ʿ������
	auto flush�� ��.
	
	�ٵ� PrintWriter�� ���� ó���� ����� ��.
	����ϱ� �����. 1����Ʈ 2����Ʈ �� �޾��༭
	�����ڸ� ������?
Constructors
PrintWriter(File file)	// ���� ��η� ���� ��ü�� ������ / ��ζ� �����̸� �ָ� ���ϱ��� ����� ��Ʈ������ ����
PrintWriter(File file, String csn)
PrintWriter(OutputStream out)		// 1����Ʈ ��Ʈ���� �ָ� ��Ʈ�� �׳� ���ִ� ��
PrintWriter(OutputStream out, boolean autoFlush)	// ���� �÷����� ����
PrintWriter(String fileName)		// ���� ��ü�� �� �ʿ䵵 ���� ���ڶ� ���ϰ�� �ָ� �����η�
PrintWriter(String fileName, String csn)
PrintWriter(Writer out)				// ������ 2����Ʈ ��Ʈ���� �ָ� �׳� ����� ��
PrintWriter(Writer out, boolean autoFlush)			// ���� �÷����� ����

���� �÷��� ���� �Ŵ� ���ָ� ��
JSP ���� ���� �÷��� �ִ� �ָ� ���� �ɰ���


*/


// ����Ʈ(1byte) / ����(2byte) ��� ��Ʈ�� ��θ� ������ ��ü�� ����

import java.io.*;
public class PrintWriterEx{
	public static void main(String[]args){		// ��� Ưȭ ��Ʈ���� / �Է� Ưȭ ��Ʈ�� ������ ����.
		
		
		
		// ���ϻ���					c1.txt
		PrintWriter pw1 = null;
			// 1Byte 
		FileOutputStream fos = null;
		PrintWriter pw2 = null;			// fos �� ���� PrintWriter ��ü
			// 2Byte
		FileWriter fw = null;
		PrintWriter pw3 = null;


		try{
			pw1 = new PrintWriter( "c1.txt" );		// PrintWriter(String fileName) / PrintWriter(OutputStream out) ��Ʈ�� �̿��ϴ� �ֵ鸸 �����÷����� �ȴ�
			pw1.println( 10 );
			pw1.println( "ABC" );
			pw1.println( "������" );

			pw1.flush();

		// 1Byte ��Ʈ�� �޾Ƽ� ����		c2.txt		// PrintWriter(OutputStream out)
			fos = new FileOutputStream( "c2.txt" );
			pw2 = new PrintWriter (fos, true);
			pw2.println(10.5);
			pw2.println( '��' );
			pw2.println("������");


		// 2Byte ��Ʈ�� �޾Ƽ� ����		c3.txt
			fw = new FileWriter( "c3.txt" );
			pw3 = new PrintWriter (fw, true);
			pw3.println(10.58);
			pw3.println( 'ȣ' );
			pw3.println("ȣ������������");

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











