import java.net.*;
import java.io.*;
// ������ �а� ���� �۾��� �и��ؼ� ������ ó�� �ؾ� �Ѵ�.

class MultiClientReadThread extends Thread {
	private Socket s;
	private BufferedReader br;
	private String returnmsg;
	
	public MultiClientReadThread(Socket s) throws IOException{
		this.s = s;
		br = new BufferedReader(new InputStreamReader( s.getInputStream() ) );
		
	}
	public synchronized void run(){
		try{
			while(true){
				returnmsg = br.readLine();
				if(returnmsg.equals( "exit") ) {
					System.out.println("���� ���� ����");
					break;
				}else{
					System.out.println( returnmsg );		//������ �˾Ƽ� �����״ϱ� ���� ���´� �̷��� �Ű� �� �ʿ䰡 ����.
				}
			}

		}catch( Exception e){
			System.out.println("���� ������ ����");
		}finally{
			try{
				if(s != null)s.close();
				if(br != null)br.close();
			} catch(IOException e){
				System.out.println("�������Ť�!!");
			}
		}
	}
}

class MultiClientWriteThread extends Thread {
	private Socket s;
	private BufferedWriter bw;
	private BufferedReader brmsg;
	private String msg;

	public MultiClientWriteThread(Socket s) throws IOException {
		this.s = s;
		bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream() ) );
		brmsg = new BufferedReader(new InputStreamReader( System.in) );
	}

	public synchronized void run(){	// ���� Socket s �� �����ϱ� ������
		String name = "�׷���";	//�Է¹޴� Ÿ�̹��� �־�� �ϴµ� ������ �ٷ� ���̵� ��� �ϱ� ������
		try {	
			bw.write(name);
			bw.newLine();
			bw.flush();
		
			while(true){
				System.out.print( ">> " );
				msg = brmsg.readLine();
				for(int i=0; i<200;i++ ){
				bw.write(msg);
				}
				bw.newLine();
				bw.flush();
				if( msg.equals("exit")){	//������ �Է��� ���� ������ ���� exit ó��
					break;					//��� �۾��� ���� �д� �ʿ��� �ϴ°� ����
				}
			}
		} catch( Exception e ){
			System.out.println("���� ������ ����");
		} finally{
			try{	//������ ����ƴ� ��°� ���忡�� �� ���ٰž�
				if(bw != null)bw.close();
				if(brmsg != null)brmsg.close();
			
			} catch(IOException e){
				System.out.println("�������Ť�!!");
			}
		}
	}
}



public class MulticastingClient {
	private Socket s;
	
	//������
	public MulticastingClient(String ip, int port ) throws UnknownHostException, IOException{
		
		s = new Socket( ip, port );
		MultiClientReadThread mrt = new MultiClientReadThread( s );
		MultiClientWriteThread mwt = new MultiClientWriteThread( s );
		mrt.start();
		mwt.start();

		
	
	} //������


	public static void main(String[] args) throws UnknownHostException, IOException	{
		new MulticastingClient( "localhost", 3000 );
	}
}

// ���� 177