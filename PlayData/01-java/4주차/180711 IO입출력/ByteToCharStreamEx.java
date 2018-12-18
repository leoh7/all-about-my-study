/*
	2Byte 스트림을 단독으로 쓰는건 거의 없다!
	거의 대부분 1Byte. 네트워크 역시.
	개발이 된 것 자체가 1Byte 기반으로 되었기 때문 (32비트 체제)

	기본 입출력 스트림 x2
	2바이트로 교환 스트림 x2
	버퍼 스트림 x2
	뭘 한다고 하면 이렇게 6개씩 필요함

	
*/

// InputStream -> Reader 
// OutputStream -> Writer
// 키보드 데이터 입력(여러번) -> 파일로 출력(한번에 모았다가 여러번)

import java.io.*;

class ByteToCharStreamEx {	// throws 는 예외가 뜨는 메서드에서 던진다!

	
	public String input (String msg) throws IOException {
		System.out.print(msg);
		// 표준 입출력 = System 의 필드를 쓰는(in, out, err)
//		InputStreamReader ir = new InputStreamReader( System.in );	// InputStream + Reader = 1Byte -> 2Byte
//		BufferedReader br = new BufferedReader( ir );				// 고로 2Byte 버퍼를 준 것
		BufferedReader br 
			= new BufferedReader( new InputStreamReader( System.in ));	// close 안하나? / 못한다 return 할 br.readLine(); 이 없으니까 NullPointerErr / 그리고 메서드 닫히면서 자동으로 닫힘
		return br.readLine();	// 입출력받을 때마다 IOException 이 생긴다.
	}

	public static void main(String[] args) throws IOException{
		ByteToCharStreamEx btc = new ByteToCharStreamEx();
		String id = btc.input( "아이디 : " );
		String passwd = btc.input( "비밀번호 : " );
		
//		FileOutputStream fos = new FileOutputStream( "d1.txt" );	// throws IOException 으로 던져버려서 try catch 할 필요 없다.
//		OutputStreamWriter osw = new OutputStreamWriter( fos );
//		BufferedWriter bw = new BufferedWriter( osw );				// 1번 방법

		BufferedWriter bw = new BufferedWriter(						// 2번 방법
			new OutputStreamWriter(						// 매개변수로 OutputStream 을 달랜다
				new FileOutputStream( "d1.txt" ) ) );	// 매개변수로 이름을 달랜다

		bw.write( "아이디 : " );
		bw.write( id );
		bw.newLine();

		bw.write( "비밀번호 : " );
		bw.write( passwd );
		bw.newLine();

		bw.flush();
	}
}


// 유일하게 main 에서 throws 안한 예외가 있다고 함... 시험문제 나올 것. 예외는 던지려면 끝까지 던지던가 중간에 한번 잡아서 던져줘야되.













