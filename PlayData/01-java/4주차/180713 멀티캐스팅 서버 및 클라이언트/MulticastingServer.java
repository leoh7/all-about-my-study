
/*
	���ڿ��� ������ ����
	
	MulticastingServer�� ��� ���ڸ� ������ �ڱ� �ڽ����׸� ���ڸ� ������µ�
	�̹��� �濡 ������ �ִ� ��ο��� �����ٰ���
	��½�Ʈ�� ��ü�� ��̸���Ʈ�� ���� ����
*/

import java.net.*;
import java.io.*;
import java.util.*;

class MultiServerThread extends Thread {
	private Socket s;
	private BufferedReader br;
	private BufferedWriter bw;
	private static ArrayList <BufferedWriter> list		//����Ʈ�� static�� �÷��� ������ �ؾ��� ��ο��� �� �Ѹ��Բ� �� �� �ִ�. �ٵ� �̷��� �Ǹ� �����ڿ��� new�� ���ϱ� ������(�����ڴ� ����ƽ �ƴ�) ���⼭ new�� ���ٰ���
			= new ArrayList <BufferedWriter>();
		//�������� ���� ���̵� �Ѿ���� �� ��
	private String name;
	private String msg;

	// ������
	public MultiServerThread(Socket s) throws IOException{
		this.s = s;
		br = new BufferedReader( new InputStreamReader(s.getInputStream()));
		bw = new BufferedWriter( new OutputStreamWriter(s.getOutputStream()));
		// �ϳ��� ������ ��ü�� �����, ���� �޾ƾ� �Ұ� �Ƴ�?
		list.add(bw); // �׷��� ���� �ްԲ� list�� �־��ش�.
	}
	

	public synchronized void run() {
		try {
			name = br.readLine();
			sendAll( "[[ " + name+ "]] ���� �����߽��ϴ�");
			while(true){
				msg = br.readLine();	// �޼��� �ޱ�
				// �޼����� ���ο��� �ѷ��� ��. exit��� ������ �ָ� �����°ɷ� �ߴµ�, ������ ���ϸ� ���δ� �������� �Ǵ� ���� ����
				if(msg.equals("exit") ){
					//�ش� Ŭ���̾�Ʈ�� ����
					bw.write(msg);
					bw.newLine();
					bw.flush();
					break;
				} else {
					//��ü�� ��ε�ĳ����
					Thread.sleep( 100 );
					sendAll( "["+ name +"] : " + msg);
				}
				
			}
			System.out.println("["+name+"]" + " Ŭ���̾�Ʈ ��������");

		} catch( Exception e){ 
			System.out.println("'exit'�� �����ϼ���");
		} finally { 
			
			try{
				sendAll("[[" +name+"]] ���� �����ϼ̽��ϴ�");
				list.remove(bw);	
				if(s != null) s.close();
				if(br!= null) br.close();
				if(bw!= null) bw.close();

			} catch( IOException e ){
				System.out.println("Ŭ���̾�Ʈ ����������");
			}
		}
	}

	public void sendAll(String msg) throws IOException{
		for(int i = 0; i<list.size(); i++){
			BufferedWriter sbw = list.get(i);
			sbw.write( msg );
			sbw.newLine();
			sbw.flush();
		}
	}

} // MultiServerThread












public class MulticastingServer {
	//�������
	private ServerSocket ss;
	private Socket s;



	
	//������
	public MulticastingServer(int port) throws IOException{
		ss = new ServerSocket( port );
		while(true) {
			System.out.println("Ŭ���̾�Ʈ ���� �����...");
			s = ss.accept();
			System.out.println("Ŭ���̾�Ʈ : " + s.getInetAddress().getHostName());
			MultiServerThread mst = new MultiServerThread(s);	//������� ���� �Ѱ��ֱ�
			mst.start();
		}
	}
	




	public static void main(String[]args) throws IOException {
		new MulticastingServer( 3000 );
	}
} //MulticastingServer


