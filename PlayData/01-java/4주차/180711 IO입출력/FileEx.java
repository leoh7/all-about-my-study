/*
	Class File
		java.lang.Object
			java.io.File
	������ IO�� ���� File �Ⱦ��� ���ڷ� �൵ ����� ��

*/

import java.io.File;
import java.io.IOException;

class FileEx {
	public static void main(String[] args) throws IOException	{	// ������� ���δ� ���ܰ� ����� ������ Ʈ���� ĳġ �������� �׳� ����
		// C ����̺� ���ϸ�� ���
		String path = "c:\\";	// \ �� �������� ���ڷ� �ν��� �ȵȴ�. �׷��� \\�̷��� �ΰ��� �� ��. �ظ��ϸ� �̷��� ���� ���ѵ�, ������������ c:/ �̰ž� �� �ù�	// �ڹٴ� \ �� \\ �� �� �ȴٰ� ���� �ȴ�. ���߿� �� ����
		File cdrive = new File( path );	// String �� �޴� ��ü�� ����

		String files[] = cdrive.list();	// �ݺ����� ������ ���빮�� Ȯ�� �Ұ���
		for(int i=0; i<files.length; i++){
			File file = new File( cdrive, files[i] );// ���� ��ü ���� �޼��带 ���� ���ؼ� ���� ��ü�� �� ����...	File(String parent, String child)
			if( file.isFile() ){
				//����
	//			System.out.println( files[i] );	// file �� �ٳ����� �ϰų� files[i] �̷������� �ϰų�<-String 
				System.out.println( file.getName() + " ���� �뷮 : (" +file.length()+ ")");

			} else {
				// ���丮
				System.out.println( " + " + file.getName() );
			}
		}

		// ���� ����
		File f1 = new File("a.txt");		// ���� ������ ������ ���ܾ� �ϴµ� ������ �Ȼ����?
											// �츮�� �����ִ°� �޸�, ��ü������, ������ �����ض� �ϴ°� �޸� / ���ݺ��� �ǵ�� �ϵ��ũ 
											// ��������� cpu�� �ְ� �޸𸮵� �ְ� �ϵ��ũ�� �־� / �ϵ��ũ�� �� �ֹ߼��̴�.
											// ��������� �̰Ŵ� ���α׷��� ���� ���ư��� �ǵ�, ���� �Ѱ� �޸𸮿��� File ��ü�� ������, ��� �Ѱ��� �ϵ��ũ�� ��������� ����
											// �׷��� createNewFile �� �ݵ�� �ؾ� �ϵ��ũ�� ����

//		System.out.println("���� : " + f1.createNewFile() );		// ���� ���� �̸��� ���� �� ������ �ȵȴ�.
		if( !f1.exists() )System.out.println("���� : " + f1.createNewFile() );
		
		// ���� ����
		System.out.println("������ : " + f1.getAbsolutePath() );	// ��� ������
		System.out.println("���԰�� : " + f1.getCanonicalPath() );	// ����� �Ȱ��� ��.
		System.out.println("�θ����� : " + f1.getParent() );	// null �� ������? �θ� ���� �� ����. �̰� �޼����� ������. ��� ����η� ������� �� �׳� null ����. �����η� �־���� ��
		System.out.println("����� : " + f1.getPath() );
		
		System.out.println("��ü�뷮 : " + f1.getTotalSpace()/1024/1024/1024 + "GB" );	// ��ü �뷮 / Long ������ ����Ʈ�� ���� / /1024 �ؼ� KB-> MB -> GB �̷������� �� �� �ִ�.
		System.out.println("����뷮 : " + f1.getFreeSpace()/1024/1024/1024 + "GB" );	// ��밡�ɿ뷮
		
		// �̸� ����
			// ������ ������ a.txt �� b.txt�� / boolean renameTo(File dest)	
			// �Ű������� ���ϰ�ü�� �޷�
			File b = new File( "b.txt" );
			if( !b.exists() )System.out.println("�̸� ���� : "+ f1.renameTo(b) );	// �̰͵� ������ ������ �� �ٲ۴�.

		// ���� ����
		f1.delete();
		b.delete();
	}
}


/*
File ��ü�� ���� ���� ����Ʈ�� ������ ���ƶ�
File(File parent, String child)		// ������ ���� ���(���丮)=�θ� , ���� �̸�=�ڽ�
File(String pathname)				// ���ڿ��� ��ο� �����̸��� �� �ָ� ��
File(String parent, String child)	// ���ڿ��� �θ� �ְ� ���ڿ��� �����̸��� ���
File(URI uri)						// URL�� ����� �����ε�, �̹��� ����� �� URL ����? �׷� ���ͳ� �ּ�(����)�� ��ü�� ������ ��� ��.


// ������ �������� ���� �޼���
boolean	canExecute()			// �� �� �ִ� �����̳�
boolean	canWrite()				// �����쿡���� ���� �� ���� �� �ִµ�, ������������ Ȯ���ڶ�� �ǹ̰� ���� ���ٰ� ����. �׷��� �������� ���� ���� ���� �� �ִ� �����̳İ� �߿�

// �ӽ� ���� ���� ����
boolean	createNewFile()
static File	createTempFile(String prefix, String suffix)
static File	createTempFile(String prefix, String suffix, File directory)
boolean	delete()
void	deleteOnExit()


String	getPath()	// �����
String	getCanonicalPath()	// ������
File	getParentFile()	// ������ ���� ���丮�� �θ���, �θ������̶��� ���丮, ���� �ü������ ���丮�� �����̳ĸ� ���� ����. �� ���� ���丮/������ ���ϰ�ü�� ���� �� �־�


�뷮
long	getTotalSpace()	//�ϵ� ��ü �뷮
long	getUsableSpace()	// ��� ���� �뷮

������ ũ��
long	length()

� ������ �ָ� �� �������� ���� �̸��� ���ڿ� �迭�� ������ / Ư�� ���� �̸� ���� ��������
String[]	list()

���� ��ü�� ����Ʈ�� ������ ��
File[]	listFiles()

�ֻ��� ��θ� ����
static File[]	listRoots()

���� �����
boolean	mkdir()
boolean	mkdirs()

�̸� �ٲٱ�
boolean	renameTo(File dest)


������ ���� �� ���� ����
boolean	setExecutable(boolean executable)
boolean	setExecutable(boolean executable, boolean ownerOnly)
boolean	setLastModified(long time)
boolean	setReadable(boolean readable)
boolean	setReadable(boolean readable, boolean ownerOnly)
boolean	setReadOnly()
boolean	setWritable(boolean writable)
boolean	setWritable(boolean writable, boolean ownerOnly)




*/