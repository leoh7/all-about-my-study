import java.net.*;
import java.io.*;

class MultiClientReadThread extends Thread {
	private Socket s;
	private BufferedReader br;
	private String returnmsg;
	public MultiClientReadThread( Socket s ) throws IOException {
		this.s = s;
		br = new BufferedReader( new InputStreamReader( s.getInputStream() ) );
	}
	public synchronized void run() {
		try {
			while( true ) {
				returnmsg = br.readLine();
				if( returnmsg.equals( "exit" ) ) {
					System.out.println( "서버 접속 종료" );
					break;
				} else {
					System.out.println( returnmsg );
				}			
			}
		} catch( Exception e ) {
			System.out.println( "서버 비정상 종료" );
		} finally {
			try {
				if( s != null ) s.close();
				if( br != null ) br.close();
			} catch( IOException e ) {
				e.printStackTrace();
			}
		}
	}
}

class MultiClientWriteThread extends Thread {
	private Socket s;
	private BufferedWriter bw;
	private BufferedReader brmsg;
	private String msg;
	public MultiClientWriteThread( Socket s ) throws IOException {
		this.s = s;
		bw = new BufferedWriter( new OutputStreamWriter( s.getOutputStream() ) );
		brmsg = new BufferedReader( new InputStreamReader( System.in ) );
	}
	public synchronized void run() {
		String name = "강사";
		try {
			bw.write( name );
			bw.newLine();
			bw.flush();

			while( true ) {
				System.out.print( ">> " );
				msg = brmsg.readLine();
				bw.write( msg );
				bw.newLine();
				bw.flush();
				if( msg.equals( "exit" ) ) {
					break;
				}
			}
		} catch( Exception e ) {
			System.out.println( "서버 비정상 종료" );
		} finally {
			try {
				if( bw != null ) bw.close();
				if( brmsg != null ) brmsg.close();
			} catch( IOException e ) {
				e.printStackTrace();
			}
		}
	}
}

public class MulticastingClient {	
	private Socket s;
	public MulticastingClient( String ip, int port ) 
		throws UnknownHostException, IOException {
		s = new Socket( ip, port );
	
		MultiClientReadThread mrt = new MultiClientReadThread( s );
		MultiClientWriteThread mwt = new MultiClientWriteThread( s );
		mrt.start();
		mwt.start();
	} // 생성자

	public static void main( String[] args ) 
		throws UnknownHostException, IOException {
		new MulticastingClient( "192.168.0.61", 3000 );
	}
}















