// 서버
// 서버 소켓 : 클라이언트가 들어오나 안들어오나 확인하는 용도
import java.net.*;
import java.io.*;
import java.util.*;


class EchoServerThread extends Thread {
	private Socket s;
	private BufferedReader br;
	private BufferedWriter bw;
	private	String msg;	// 받아서 저장할 메세지
	
	public EchoServerThread(Socket s){
		this.s = s;
	}


	public void run(){		// 예외를 유일하게 못 던지는게 run() 메서드
		try{
		// 4. 입출력 스트림 생성
			br = new BufferedReader(new InputStreamReader(s.getInputStream() ) );
			bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream() ));
		
		while(true){
			// 6. 메세지 수신

				msg = br.readLine();
		//		System.out.println("받은 메세지 : " + msg );	// exit 로 종료시키기 위해 위치 변경

			// 7. 메세지 송신
				bw.write( msg );
				bw.newLine();
				bw.flush();

				if(msg.equals("exit")){
					System.out.println( "클라이언트 접속 종료" );
					break;
				} else {
					System.out.println("받은 메세지 : " + msg );
				}
		}
		// 9. 소켓종료
//			if( ss != null ) s.close();	서버는 닫으면 안된다.

			if( s != null ) s.close();
			if( br != null ) br.close();
			if( bw != null ) bw.close();
		} catch( IOException e){
			e.printStackTrace();
		}
	}
}
public class EchoServer   {

//멤버변수
	//서버소켓
	private ServerSocket ss;
	private Socket s;	// 서버 이용가능여부 확인용
/*
	private BufferedReader br;
	private BufferedWriter bw;
	private	String msg;	// 받아서 저장할 메세지
run으로 이사
*/

//생성자
	public EchoServer(int port) throws IOException {
		// 1.서버 소켓 생성
		ss = new ServerSocket( port );
		// 2.서버 소켓 청취 / 청취 1번당 1번 메서드 사용
		while(true){
			System.out.println("클라이언트 접속 대기중...");
			s = ss.accept();
		// 소켓을  받는다 //
			System.out.println("접속한 클라이언트 : "
				+ s.getInetAddress().getHostName()	// 객체로 리턴함 // 접속한 클라이언트의 ip주소를 객체로 리턴하고
			);
			EchoServerThread est = new EchoServerThread( s );
			est.start();		// 소켓은 계속 생기면서 그걸 동시에 쓰레드로 계속 던져준다.
/*			
		// 4. 입출력 스트림 생성
			br = new BufferedReader(new InputStreamReader(s.getInputStream() ) );
			bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream() ));
		
		while(true){
			// 6. 메세지 수신

				msg = br.readLine();
		//		System.out.println("받은 메세지 : " + msg );	// exit 로 종료시키기 위해 위치 변경

			// 7. 메세지 송신
				bw.write( msg );
				bw.newLine();
				bw.flush();

				if(msg.equals("exit")){
					System.out.println( "클라이언트 접속 종료" );
					break;
				} else {
					System.out.println("받은 메세지 : " + msg );
				}
		}
		// 9. 소켓종료
//			if( ss != null ) s.close();	서버는 닫으면 안된다.

			if( s != null ) s.close();
			if( br != null ) br.close();
			if( bw != null ) bw.close();
run으로 이사갈 내용
*/		
		
		} // while(true)
	} // 생성자

	
	public static void main(String[] args) throws IOException {
		new EchoServer(3000);			
	}
}

//179
