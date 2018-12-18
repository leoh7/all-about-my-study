/*
	���ݱ��� �ߴ� ���� ǥ�������
	ǥ��������� ������ ��ġ���� �ۿ� �Է�, ����� ���Ѵ�.
	(���ϴ� ��ġ ex>���ϳ��� �� �Է� ���� �� ����.)

	��Ʈ��(= ���, InputStream, OutputStream)
		��Ʈ���� FIFO �����̴�.
		��Ʈ���� �ܹ����̴�.
		��Ʈ���� ������ �� �ִ�. ( �տ��� ���� ������ �� )
		�������� �ݵ�� �ݾƾ� �Ѵ�. close()
		��Ʈ��ũ�� �ᱹ IO��. ��� ������ �����α׷��ֵ� IO��. ���ķδ� �⺻�� IO�� �� ��.
		


*/



// 1 Byte ���� ��Ʈ������ 2 Byte ��� ���ڸ� ������ �������´�.
//			1Byte		2Byte		1Byte -> 2Byte
// �Է�	InputStream		Reader		InputStreamReader
// ���	OutputStream	Writer		OutputStreamWriter

// ����, Object �����, cf) Scanner �� Data�� ����ȯ�ؼ� �޴´�, �̰� ���� ���� ��. ���ؼ� ���°���(Util ��Ű��)



// 1 Byte ���� ���� ����� + Buffer
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileNotFoundException;

class ByteStreamEx { 
	public static void main(String[]args){
		// a.txt �� �о => a1.txt �� ������
		// a.txt ���� => 1234 \n %^&* \n ABCD
/*		try{
		FileInputStream fis = new FileInputStream( "a.txt" );	
		FileOutputStream fos = new FileOutputStream( "a1.txt" );	// ���ڿ� �ִ� ���� ���ڿ��� �����ϱ� ������ ������ �ƴϾ� / ���� ���� �̸��� �ָ�, �޸��ʿ� ������ ���� ��. / �̰� ����´�.
		} catch() {													// �׷��� ������ ������ ������ ���ٰ� �˷���� �ϴϱ�, �˷��ִ� ��.
		}	// �̷��� ����� ���������� �ǹ����ϱ�, �����Ѵ�.														
*/
		int data = 0;
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try{
			fis = new FileInputStream( "a.txt" );	// �Է��� �� ���� ������ �ڵ����� �� ����
			fos = new FileOutputStream( "a1.txt" );	// ����� �� ���� ������ �ڵ����� ����
			
			bis = new BufferedInputStream( fis );
			bos = new BufferedOutputStream( fos );

	//		while( ( data = fis.read() ) != -1){	// -1�� �Ǹ� ��	// ���⿡ fis.read() �ڸ��� return ���� ���ƿ���? �׷��� �޾ƿ��� ������ �ϳ� ������ ��.
	//			System.out.print( (char) data );			// 49505152 1310 37943842 1310 65666768
	//			fos.write( data );	// ��״� ����ȯ���� �ڵ����� �ϱ� ������ ���� ���� / �׷��� a1.txt �� ���� �� �ִ�.
	//			// fis-> fos ���� bis -> bos �� �ٲ��.			
	//		}
			while( ( data = bis.read() ) != -1){
				System.out.print( (char) data );
				bos.write( data );
				}
			bos.flush();	// RAM(�޸� �����)�� ����Ǿ� �ִ� ������ HDD �� ������ -> a1.txt �� ���°� �̷�� ����.

		} catch( FileNotFoundException e) {
			e.printStackTrace();					// ��������� �ص� a1.txt �� ����� = ����) ��ü �����ϴ� ���� ������ �����Ǿ� �ִ� ��.	
		} catch( IOException e) {
			e.printStackTrace();
		} finally {
			try{
			// FileNotFoundException �� �߻��ؼ� fis �� null �� ���µ� close() ��Ű�� ������ ��
			if ( fis != null ) fis.close();		// �ݴµ��� ������ �ִ�.
			if ( fos != null ) fos.close();		// IOException �� ���.
			if ( bis != null ) bis.close();
			if ( bos != null ) bos.close();
			}catch( IOException e){ e.printStackTrace(); } 
		}
	}
}


/*
Class System
	�ʵ�
	static PrintStream	err
	static InputStream	in
	static PrintStream	out
	
	PrintStream �ε� ��� �ѱ� ����� �����ߴ���.
	PrintStream Ŭ������ ������ print() �޼���� ���ǵǾ� �ִ�.
	���� ������ 
		����ó���� ���ص� �ȴ� -> ǥ������� 
		���۸� ������ �ʿ䵵 ����

2Byte ��� PrintWriter�� �ִ� 
	��� ������ �� �ٸ�.



Filter ��� �ֵ�.
	Ư¡-	�� �ʿ��� �ֵ��� �ƴ� / �ݵ�� �ٸ� ��Ʈ���� �־�� �� �� ����
		ī�޶�� ����� �Ϸ��� �ϴµ�(DSLR) �ٵ� �տ��� ��� �ȴ°� �ƴ϶� ���͵� ����?
		���Ͷ�°� �ٵ� �ְ� ��� �ְ� �� �տ� ���Ͱ� �ִ°�.
		�ٵ𿡴� ���͸� �ٷ� �� �� ����, '��� �־��' �� �� �ִ� ��. / �׷��ٰ� �� ���Ͱ� ���ٰ� ���� �� ��°� �ƴ���?

abstract class InputStream 
���� ���� ���� ���ε� �갡 �߻�޼����.
abstract int	read()
Reads the next byte of data from the input stream.
�׷��� �긦 ������ ���� Ŭ������ ���� �ȴ�.
	
class FileInputStream
	// ������
	FileInputStream(File file)
	FileInputStream(FileDescriptor fdObj)
	FileInputStream(String name)
	�ڹٴ� short, int�� �ص� int�� ������.
	int	read()
	int	read(byte[] b)
	int	read(byte[] b, int off, int len)


Class FileOutputStream
	// ������
	FileOutputStream(File file)
	FileOutputStream(File file, boolean append)	// ������ ������ �̸��� �߰��� �ؼ� ��������
	FileOutputStream(FileDescriptor fdObj)
	FileOutputStream(String name)
	FileOutputStream(String name, boolean append)
	
	// �޼��� �����߳� ���߳��� ���� Ȯ���ؾ���
	void	write(byte[] b)
	void	write(byte[] b, int off, int len)
	void	write(int b)





BufferedInputStream
Constructors
BufferedInputStream(InputStream in)	// InputStream �� ��ӹ��� �ֵ��� �� �ްڴٴ� �Ҹ�
BufferedInputStream(InputStream in, int size)



*/
