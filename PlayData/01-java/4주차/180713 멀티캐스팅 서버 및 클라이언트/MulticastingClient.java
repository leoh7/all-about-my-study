import java.net.*;
import java.io.*;
// 소켓은 읽고 쓰는 작업을 분리해서 쓰레드 처리 해야 한다.

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
					System.out.println("서버 접속 종료");
					break;
				}else{
					System.out.println( returnmsg );		//서버가 알아서 해줄테니까 누가 보냈니 이런거 신경 쓸 필요가 없다.
				}
			}

		}catch( Exception e){
			System.out.println("서버 비정상 종료");
		}finally{
			try{
				if(s != null)s.close();
				if(br != null)br.close();
			} catch(IOException e){
				System.out.println("가ㅂ러ㅕㅅ!!");
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

	public synchronized void run(){	// 변수 Socket s 를 공유하기 때문에
		String name = "테러범";	//입력받는 타이밍이 있어야 하는데 지금은 바로 아이디를 줘야 하기 때문에
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
				if( msg.equals("exit")){	//서버에 입력한 값을 보내고 나서 exit 처리
					break;					//모든 작업의 끝은 읽는 쪽에서 하는게 좋다
				}
			}
		} catch( Exception e ){
			System.out.println("서버 비정상 종료");
		} finally{
			try{	//서버가 종료됐다 라는건 리드에서 다 해줄거야
				if(bw != null)bw.close();
				if(brmsg != null)brmsg.close();
			
			} catch(IOException e){
				System.out.println("가ㅂ러ㅕㅅ!!");
			}
		}
	}
}



public class MulticastingClient {
	private Socket s;
	
	//생성자
	public MulticastingClient(String ip, int port ) throws UnknownHostException, IOException{
		
		s = new Socket( ip, port );
		MultiClientReadThread mrt = new MultiClientReadThread( s );
		MultiClientWriteThread mwt = new MultiClientWriteThread( s );
		mrt.start();
		mwt.start();

		
	
	} //생성자


	public static void main(String[] args) throws UnknownHostException, IOException	{
		new MulticastingClient( "localhost", 3000 );
	}
}

// 상혁 177