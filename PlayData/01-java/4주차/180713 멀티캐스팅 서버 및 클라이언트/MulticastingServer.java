
/*
	문자열로 보내는 서버
	
	MulticastingServer의 경우 문자를 보내고 자기 자신한테만 문자를 돌려줬는데
	이번엔 방에 입장해 있는 모두에게 돌려줄거임
	출력스트림 객체만 어레이리스트에 넣을 것임
*/

import java.net.*;
import java.io.*;
import java.util.*;

class MultiServerThread extends Thread {
	private Socket s;
	private BufferedReader br;
	private BufferedWriter bw;
	private static ArrayList <BufferedWriter> list		//리스트는 static에 올려서 공유를 해야지 모두에게 다 뿌리게끔 쓸 수 있다. 근데 이렇게 되면 생성자에서 new를 못하기 때문ㅇ(생성자는 스테틱 아님) 여기서 new를 해줄거임
			= new ArrayList <BufferedWriter>();
		//시작하자 마자 아이디가 넘어오게 할 것
	private String name;
	private String msg;

	// 생성자
	public MultiServerThread(Socket s) throws IOException{
		this.s = s;
		br = new BufferedReader( new InputStreamReader(s.getInputStream()));
		bw = new BufferedWriter( new OutputStreamWriter(s.getOutputStream()));
		// 하나의 쓰레드 객체가 생겼어, 나도 받아야 할것 아냐?
		list.add(bw); // 그래서 나도 받게끔 list에 넣어준다.
	}
	

	public synchronized void run() {
		try {
			name = br.readLine();
			sendAll( "[[ " + name+ "]] 님이 입장했습니다");
			while(true){
				msg = br.readLine();	// 메세지 받기
				// 메세지를 전부에게 뿌려야 함. exit라고 서버가 주면 끝내는걸로 했는데, 구분을 안하면 전부다 나가지게 되는 수가 있음
				if(msg.equals("exit") ){
					//해당 클라이언트만 종료
					bw.write(msg);
					bw.newLine();
					bw.flush();
					break;
				} else {
					//전체에 브로드캐스팅
					Thread.sleep( 100 );
					sendAll( "["+ name +"] : " + msg);
				}
				
			}
			System.out.println("["+name+"]" + " 클라이언트 정상종료");

		} catch( Exception e){ 
			System.out.println("'exit'로 종료하세요");
		} finally { 
			
			try{
				sendAll("[[" +name+"]] 님이 퇴장하셨습니다");
				list.remove(bw);	
				if(s != null) s.close();
				if(br!= null) br.close();
				if(bw!= null) bw.close();

			} catch( IOException e ){
				System.out.println("클라이언트 비정상종료");
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
	//멤버변수
	private ServerSocket ss;
	private Socket s;



	
	//생성자
	public MulticastingServer(int port) throws IOException{
		ss = new ServerSocket( port );
		while(true) {
			System.out.println("클라이언트 접속 대기중...");
			s = ss.accept();
			System.out.println("클라이언트 : " + s.getInetAddress().getHostName());
			MultiServerThread mst = new MultiServerThread(s);	//쓰레드로 소켓 넘겨주기
			mst.start();
		}
	}
	




	public static void main(String[]args) throws IOException {
		new MulticastingServer( 3000 );
	}
} //MulticastingServer


