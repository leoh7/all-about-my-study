// ����
// ���� ���� : Ŭ���̾�Ʈ�� ������ �ȵ����� Ȯ���ϴ� �뵵
import java.net.*;
import java.io.*;
import java.util.*;


class EchoServerThread extends Thread {
	private Socket s;
	private BufferedReader br;
	private BufferedWriter bw;
	private	String msg;	// �޾Ƽ� ������ �޼���
	
	public EchoServerThread(Socket s){
		this.s = s;
	}


	public void run(){		// ���ܸ� �����ϰ� �� �����°� run() �޼���
		try{
		// 4. ����� ��Ʈ�� ����
			br = new BufferedReader(new InputStreamReader(s.getInputStream() ) );
			bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream() ));
		
		while(true){
			// 6. �޼��� ����

				msg = br.readLine();
		//		System.out.println("���� �޼��� : " + msg );	// exit �� �����Ű�� ���� ��ġ ����

			// 7. �޼��� �۽�
				bw.write( msg );
				bw.newLine();
				bw.flush();

				if(msg.equals("exit")){
					System.out.println( "Ŭ���̾�Ʈ ���� ����" );
					break;
				} else {
					System.out.println("���� �޼��� : " + msg );
				}
		}
		// 9. ��������
//			if( ss != null ) s.close();	������ ������ �ȵȴ�.

			if( s != null ) s.close();
			if( br != null ) br.close();
			if( bw != null ) bw.close();
		} catch( IOException e){
			e.printStackTrace();
		}
	}
}
public class EchoServer   {

//�������
	//��������
	private ServerSocket ss;
	private Socket s;	// ���� �̿밡�ɿ��� Ȯ�ο�
/*
	private BufferedReader br;
	private BufferedWriter bw;
	private	String msg;	// �޾Ƽ� ������ �޼���
run���� �̻�
*/

//������
	public EchoServer(int port) throws IOException {
		// 1.���� ���� ����
		ss = new ServerSocket( port );
		// 2.���� ���� û�� / û�� 1���� 1�� �޼��� ���
		while(true){
			System.out.println("Ŭ���̾�Ʈ ���� �����...");
			s = ss.accept();
		// ������  �޴´� //
			System.out.println("������ Ŭ���̾�Ʈ : "
				+ s.getInetAddress().getHostName()	// ��ü�� ������ // ������ Ŭ���̾�Ʈ�� ip�ּҸ� ��ü�� �����ϰ�
			);
			EchoServerThread est = new EchoServerThread( s );
			est.start();		// ������ ��� ����鼭 �װ� ���ÿ� ������� ��� �����ش�.
/*			
		// 4. ����� ��Ʈ�� ����
			br = new BufferedReader(new InputStreamReader(s.getInputStream() ) );
			bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream() ));
		
		while(true){
			// 6. �޼��� ����

				msg = br.readLine();
		//		System.out.println("���� �޼��� : " + msg );	// exit �� �����Ű�� ���� ��ġ ����

			// 7. �޼��� �۽�
				bw.write( msg );
				bw.newLine();
				bw.flush();

				if(msg.equals("exit")){
					System.out.println( "Ŭ���̾�Ʈ ���� ����" );
					break;
				} else {
					System.out.println("���� �޼��� : " + msg );
				}
		}
		// 9. ��������
//			if( ss != null ) s.close();	������ ������ �ȵȴ�.

			if( s != null ) s.close();
			if( br != null ) br.close();
			if( bw != null ) bw.close();
run���� �̻簥 ����
*/		
		
		} // while(true)
	} // ������

	
	public static void main(String[] args) throws IOException {
		new EchoServer(3000);			
	}
}

//179
