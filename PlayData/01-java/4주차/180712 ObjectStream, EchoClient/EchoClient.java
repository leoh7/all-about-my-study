// 클라이언트
import java.net.*;
import java.io.*;

public class EchoClient {
//멤버변수
	//소켓
	private Socket s;

	private BufferedReader br;
	private BufferedWriter bw;

	private BufferedReader brmsg;	// 타이핑 입력용 버퍼
	private String msg;				// 입력받을 메세지
	private String returnmsg;		// 갔다가 돌아오는 메세지

//생성자
	public EchoClient(String ip, int port) throws UnknownHostException, IOException {
		//3. 소켓 생성
		s = new Socket(ip, port);	// UnknownHostException, IOException 을 발생시킴
									// 소켓에다가는 따로 스트림을 붙일 순 없다.
									// 제공해주는 것을 써야함.

		//4. 입출력 스트림 생성
		br = new BufferedReader(new InputStreamReader(s.getInputStream() ) );
		bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream() ));
	
		while(true){
			// 5. 메세지 송신
				brmsg = new BufferedReader( new InputStreamReader(System.in) );
				System.out.print( "보낼 메세지 : ");
				msg = brmsg.readLine();
				bw.write( msg );
				bw.newLine();
				bw.flush();		// 플러쉬를 해줘야 소켓에 쓴다.

			// 8. 메세지 수신
				returnmsg = br.readLine();	//
				if( returnmsg.equals( "exit") ) {
					System.out.println( "서버 접속 종료" );
					break;
				} else {
				System.out.println("돌아온 메세지 : " + returnmsg );
				}
		}
		
		// 9. 소켓 종료
			if( s != null ) s.close();
			if( br != null ) br.close();
			if( bw != null ) bw.close();
			if( brmsg != null ) brmsg.close();

	} // 생성자
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		new EchoClient("localhost", 3000 );	//(IP, 포트번호)	
	}
}

// 자기 ip를 가져다 주는 값 -> localhost 혹은 127.0.0.1


// 유니캐스팅 -> 멀티캐스팅! (전체에게 똑같은 데이터들을 계속 뿌리는 브로드캐스팅을 해줘야 함. 소켓들을 한 바퀴 다 돌아야 해서 한데 묶을 필요가 있다(컬렉션으로). ArrayList를 쓸 것.)  