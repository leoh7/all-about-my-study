/*
	지금까지 했던 것은 표준입출력
	표준입출력은 정해진 위치에서 밖에 입력, 출력을 못한다.
	(원하는 위치 ex>파일내부 에 입력 같은 걸 못함.)

	스트림(= 통로, InputStream, OutputStream)
		스트림은 FIFO 구조이다.
		스트림은 단방향이다.
		스트림은 지연될 수 있다. ( 앞에가 먼저 나가야 함 )
		열었으면 반드시 닫아야 한다. close()
		네트워크도 결국 IO다. 고로 다음달 웹프로그래밍도 IO다. 추후로는 기본이 IO가 될 것.
		


*/



// 1 Byte 단위 스트림으로 2 Byte 기반 문자를 보내면 깨져나온다.
//			1Byte		2Byte		1Byte -> 2Byte
// 입력	InputStream		Reader		InputStreamReader
// 출력	OutputStream	Writer		OutputStreamWriter

// 버퍼, Object 입출력, cf) Scanner 는 Data를 형변환해서 받는다, 이건 좋지 않은 것. 편해서 쓰는거지(Util 패키지)



// 1 Byte 단위 파일 입출력 + Buffer
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileNotFoundException;

class ByteStreamEx { 
	public static void main(String[]args){
		// a.txt 를 읽어서 => a1.txt 로 쓸거임
		// a.txt 내용 => 1234 \n %^&* \n ABCD
/*		try{
		FileInputStream fis = new FileInputStream( "a.txt" );	
		FileOutputStream fos = new FileOutputStream( "a1.txt" );	// 문자열 주는 곳에 문자열을 줬으니까 문법상 에러는 아니야 / 없는 파일 이름을 주면, 메모리쪽에 에러가 나는 것. / 이게 못잡는다.
		} catch() {													// 그래서 파일이 없으면 파일이 없다고 알려줘야 하니까, 알려주는 것.
		}	// 이렇게 만들면 지역변수가 되버리니까, 빼야한다.														
*/
		int data = 0;
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try{
			fis = new FileInputStream( "a.txt" );	// 입력할 때 쓰는 파일은 자동으로 안 만듬
			fos = new FileOutputStream( "a1.txt" );	// 출력할 때 쓰는 파일은 자동으로 만듬
			
			bis = new BufferedInputStream( fis );
			bos = new BufferedOutputStream( fos );

	//		while( ( data = fis.read() ) != -1){	// -1이 되면 끝	// 여기에 fis.read() 자리로 return 값이 돌아오지? 그래서 받아오는 변수를 하나 만들어야 함.
	//			System.out.print( (char) data );			// 49505152 1310 37943842 1310 65666768
	//			fos.write( data );	// 얘네는 형변환까지 자동으로 하기 때문에 걱정 없음 / 그러면 a1.txt 에 값이 들어가 있다.
	//			// fis-> fos 에서 bis -> bos 로 바꿨다.			
	//		}
			while( ( data = bis.read() ) != -1){
				System.out.print( (char) data );
				bos.write( data );
				}
			bos.flush();	// RAM(메모리 저장소)에 저장되어 있는 정보를 HDD 로 내보냄 -> a1.txt 에 쓰는게 이루어 졌다.

		} catch( FileNotFoundException e) {
			e.printStackTrace();					// 여기까지만 해도 a1.txt 가 생긴다 = 주의) 객체 생성하는 순간 파일이 생성되어 있는 것.	
		} catch( IOException e) {
			e.printStackTrace();
		} finally {
			try{
			// FileNotFoundException 가 발생해서 fis 에 null 이 들어갔는데 close() 시키면 에러가 나
			if ( fis != null ) fis.close();		// 닫는데도 순서가 있다.
			if ( fos != null ) fos.close();		// IOException 이 뜬다.
			if ( bis != null ) bis.close();
			if ( bos != null ) bos.close();
			}catch( IOException e){ e.printStackTrace(); } 
		}
	}
}


/*
Class System
	필드
	static PrintStream	err
	static InputStream	in
	static PrintStream	out
	
	PrintStream 인데 어떻게 한글 출력이 가능했느냐.
	PrintStream 클래스에 가보면 print() 메서드로 정의되어 있다.
	얘의 장점은 
		예외처리를 안해도 된다 -> 표준입출력 
		버퍼를 내보낼 필요도 없다

2Byte 기반 PrintWriter가 있다 
	얘는 장점이 좀 다름.



Filter 라는 애들.
	특징-	꼭 필요한 애들은 아님 / 반드시 다른 스트림이 있어야 쓸 수 있음
		카메라로 출력을 하려고 하는데(DSLR) 바디 앞에다 렌즈도 꽂는게 아니라 필터도 꽂지?
		필터라는게 바디가 있고 렌즈가 있고 그 앞에 필터가 있는것.
		바디에다 필터를 바로 낄 순 없고, '렌즈가 있어야' 쓸 수 있는 것. / 그렇다고 꼭 필터가 없다고 사진 못 찍는건 아니지?

abstract class InputStream 
제일 많이 쓰는 놈인데 얘가 추상메서드야.
abstract int	read()
Reads the next byte of data from the input stream.
그래서 얘를 구현해 놓은 클래스를 쓰면 된다.
	
class FileInputStream
	// 생성자
	FileInputStream(File file)
	FileInputStream(FileDescriptor fdObj)
	FileInputStream(String name)
	자바는 short, int나 해도 int로 돌려줌.
	int	read()
	int	read(byte[] b)
	int	read(byte[] b, int off, int len)


Class FileOutputStream
	// 생성자
	FileOutputStream(File file)
	FileOutputStream(File file, boolean append)	// 파일이 있으면 이름에 추가를 해서 생성해줌
	FileOutputStream(FileDescriptor fdObj)
	FileOutputStream(String name)
	FileOutputStream(String name, boolean append)
	
	// 메서드 저장했나 못했나는 직접 확인해야함
	void	write(byte[] b)
	void	write(byte[] b, int off, int len)
	void	write(int b)





BufferedInputStream
Constructors
BufferedInputStream(InputStream in)	// InputStream 을 상속받은 애들은 다 받겠다는 소리
BufferedInputStream(InputStream in, int size)



*/
