import java.net.*;
import java.io.*;
import java.util.*;
class MultiServerThread extends Thread {
	private Socket s;
	private BufferedReader br;
	private BufferedWriter bw;
	private static ArrayList <BufferedWriter> list
		= new ArrayList<BufferedWriter>();
	private String name;
	private String msg;
	public MultiServerThread( Socket s ) throws IOException {
		this.s = s;
		br = new BufferedReader( new InputStreamReader( s.getInputStream() ) );
		bw = new BufferedWriter( new OutputStreamWriter( s.getOutputStream() ) );
		list.add( bw );
	}
	public synchronized void run() {
		try {
			name = br.readLine();
			sendAll( "[[ " + name + " ]] 님이 입장했습니다" ); 
			while( true ) {
				msg = br.readLine();
				if( msg.equals( "exit" ) ) {
					// 해당 클라이언트만 전송
					bw.write( msg );
					bw.newLine();
					bw.flush();
					break;
				} else {
					// 전체에 브로드캐스팅
					Thread.sleep( 100 );
					sendAll( "[" + name + "] : " + msg );
				}
			}
			System.out.println( "클라이언트 정상종료" );
		} catch( Exception e ) {
			System.out.println( "'exit'로 종료하세요" );
		} finally {
			try {
				list.remove( bw );
				sendAll( "[[ " + name + " ]] 님이 퇴장했습니다" );
							
				if( s != null ) s.close();
				if( br != null ) br.close();
				if( bw != null ) bw.close();
			} catch( IOException e ) {
				System.out.println( "클라이언트 비정상종료" );
			}
		}
	}

	public void sendAll( String msg ) throws IOException {
		for( int i=0; i<list.size(); i++ ) {
			BufferedWriter sbw = list.get(i);
			sbw.write( msg );
			sbw.newLine();
			sbw.flush();
		}
	}	
}
public class MulticastingServer {	
	private ServerSocket ss;
	private Socket s;
	public MulticastingServer( int port ) throws IOException {
		ss = new ServerSocket( port );
		while( true ) {
			System.out.println( "클라이언트 접속 대기중..." );
			s = ss.accept();
			System.out.println( "클라이언트 : " + s.getInetAddress().getHostName() );
			MultiServerThread mst = new MultiServerThread( s );
			mst.start();
		}
	} // 생성자
	public static void main( String[] args ) throws IOException {
		new MulticastingServer( 3000 );
	}
}















