/*
	Class File
		java.lang.Object
			java.io.File
	실제로 IO할 때는 File 안쓰고 문자로 줘도 입출력 됨

*/

import java.io.File;
import java.io.IOException;

class FileEx {
	public static void main(String[] args) throws IOException	{	// 입출력은 전부다 예외가 생기기 때문에 트라이 캐치 하지말고 그냥 던져
		// C 드라이브 파일목록 출력
		String path = "c:\\";	// \ 역 슬래쉬는 문자로 인식이 안된다. 그래서 \\이렇게 두개를 준 것. 왠만하면 이렇게 쓴게 편한데, 리눅스에서는 c:/ 이거야 또 시발	// 자바는 \ 나 \\ 나 다 된다고 보면 된다. 나중에 볼 것임
		File cdrive = new File( path );	// String 을 받는 객체를 생성

		String files[] = cdrive.list();	// 반복문을 돌려서 내용문을 확인 할거임
		for(int i=0; i<files.length; i++){
			File file = new File( cdrive, files[i] );// 파일 객체 안의 메서드를 쓰기 위해서 파일 객체를 또 생성...	File(String parent, String child)
			if( file.isFile() ){
				//파일
	//			System.out.println( files[i] );	// file 에 겟네임을 하거나 files[i] 이런식으로 하거나<-String 
				System.out.println( file.getName() + " 파일 용량 : (" +file.length()+ ")");

			} else {
				// 디렉토리
				System.out.println( " + " + file.getName() );
			}
		}

		// 파일 생성
		File f1 = new File("a.txt");		// 본인 폴더에 파일이 생겨야 하는데 파일이 안생기네?
											// 우리가 쓰고있는건 메모리, 객체만들어라, 변수를 생성해라 하는건 메모리 / 지금부터 건들건 하드디스크 
											// 저장공간은 cpu도 있고 메모리도 있고 하드디스크도 있어 / 하드디스크는 비 휘발성이다.
											// 결과적으로 이거는 프로그램을 끄면 날아가는 건데, 지금 한건 메모리에다 File 객체를 만들어라, 라고 한거지 하드디스크에 만들으라곤 안함
											// 그래서 createNewFile 을 반드시 해야 하드디스크에 생김

//		System.out.println("생성 : " + f1.createNewFile() );		// 같은 파일 이름이 있을 땐 생성이 안된다.
		if( !f1.exists() )System.out.println("생성 : " + f1.createNewFile() );
		
		// 파일 정보
		System.out.println("절대경로 : " + f1.getAbsolutePath() );	// 경로 얻어오기
		System.out.println("정규경로 : " + f1.getCanonicalPath() );	// 결과는 똑같다 함.
		System.out.println("부모폴더 : " + f1.getParent() );	// null 이 나오지? 부모가 없는 건 없어. 이건 메서드의 버그임. 얘는 상대경로로 만들었을 땐 그냥 null 나옴. 절대경로로 주어줘야 함
		System.out.println("상대경로 : " + f1.getPath() );
		
		System.out.println("전체용량 : " + f1.getTotalSpace()/1024/1024/1024 + "GB" );	// 전체 용량 / Long 값으로 바이트로 나옴 / /1024 해서 KB-> MB -> GB 이런식으로 할 수 있다.
		System.out.println("가용용량 : " + f1.getFreeSpace()/1024/1024/1024 + "GB" );	// 사용가능용량
		
		// 이름 변경
			// 위에서 생성한 a.txt 를 b.txt로 / boolean renameTo(File dest)	
			// 매개변수로 파일객체를 달래
			File b = new File( "b.txt" );
			if( !b.exists() )System.out.println("이름 변경 : "+ f1.renameTo(b) );	// 이것도 파일이 있으면 못 바꾼다.

		// 파일 삭제
		f1.delete();
		b.delete();
	}
}


/*
File 객체를 만들 때는 디폴트로 만들지 말아라
File(File parent, String child)		// 파일이 속한 경로(디렉토리)=부모 , 파일 이름=자식
File(String pathname)				// 문자열로 경로와 파일이름을 다 주면 됨
File(String parent, String child)	// 문자열로 부모를 주고 문자열로 파일이름도 줘라
File(URI uri)						// URL과 비슷한 개념인데, 이미지 출력할 땐 URL 썼지? 그런 인터넷 주소(파일)로 객체를 만들어라 라는 것.


// 파일의 접근제한 관련 메서드
boolean	canExecute()			// 쓸 수 있는 파일이냐
boolean	canWrite()				// 윈도우에서는 거의 다 읽을 수 있는데, 리눅스에서는 확장자라는 의미가 거의 없다고 본다. 그래서 리눅스에 가면 내가 읽을 수 있는 파일이냐가 중요

// 임시 파일 생성 삭제
boolean	createNewFile()
static File	createTempFile(String prefix, String suffix)
static File	createTempFile(String prefix, String suffix, File directory)
boolean	delete()
void	deleteOnExit()


String	getPath()	// 상대경로
String	getCanonicalPath()	// 절대경로
File	getParentFile()	// 파일이 속한 디렉토리가 부모랬지, 부모파일이란건 디렉토리, 원래 운영체제들은 디렉토리냐 파일이냐를 구분 못함. 즉 속한 디렉토리/폴더로 파일객체를 만들 수 있어


용량
long	getTotalSpace()	//하드 전체 용량
long	getUsableSpace()	// 사용 중인 용량

파일의 크기
long	length()

어떤 폴더를 주면 그 폴더안의 파일 이름을 문자열 배열로 돌려줌 / 특정 폴더 이름 전부 가져오기
String[]	list()

파일 객체를 리스트로 가져다 줌
File[]	listFiles()

최상위 경로를 얻어옴
static File[]	listRoots()

폴더 만들기
boolean	mkdir()
boolean	mkdirs()

이름 바꾸기
boolean	renameTo(File dest)


파일의 권한 및 정보 설정
boolean	setExecutable(boolean executable)
boolean	setExecutable(boolean executable, boolean ownerOnly)
boolean	setLastModified(long time)
boolean	setReadable(boolean readable)
boolean	setReadable(boolean readable, boolean ownerOnly)
boolean	setReadOnly()
boolean	setWritable(boolean writable)
boolean	setWritable(boolean writable, boolean ownerOnly)




*/