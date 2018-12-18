/*	Wrapper Class
	boolean			Boolean
	byte			Byte
	char			Character
	double			Double
	float			Float
	int				Integer
	short			Short
	long			Long
	void			Void
*/

class  WrapperEx {
	public static void main(String[] args) {
		Integer in = new Integer( 20 );
		System.out.println( "BYTES : " + Integer.BYTES );	//필드여서 클래스.메서드
		System.out.println( "MAX_VALUE : " + Integer.MAX_VALUE );
		System.out.println( "MIN_VALUE : " + Integer.MIN_VALUE );
		
		// parseInt 문자열을 정수로 반환해준다

	//	int a = Integer.parseInt( "ABC" );		/ ABC 는 정수포맷으로 바꿀 수가 없다
		int a = Integer.parseInt( "123" );
	//	Integer b = Integer.parseInt( "ABC" );	/ 이것도 
		Integer b = Integer.valueOf( "456" );
		System.out.println( "2진수 : " + Integer.toBinaryString( 20 ) );
		System.out.println( "8진수 : " + Integer.toOctalString( 20 ) );
		System.out.println( "16진수 : " + Integer.toHexString( 20 ) );	// 0000 0000 0000 0000  2바이트를 쓰는데 8개 8개 그려야되는데 왜 끊어그리냐 / 이것도 16진수 표기 때문에 그래 / 0000 0000 0001 0100 :20 이걸 사람이 보기 편하게 할 수 없겠냐 / 그게 8진수 / 이 2진수 값을 3자리씩 끊으면 8진수가 되. / 000	2진수 3자리가 표현할 수 있는게 0~7 / 000 000 000 / 16진수는 0000 4자리 단위로 끊어서 / 10=a, 11=b, 12=c, 13=d, 14=e, 15=f, / 07 숫자 앞에 0을 붙이면 8진수, 0x14 숫자 앞에 0x를 붙이면 16진수
	
		System.out.println( 010 );	// 8
		System.out.println( 0x10 );	// 16
		System.out.println( 0xFF );	// 256

		// 오토박싱 / 언박싱 / 1.5버전부터
		int c = new Integer( 10 );
		Integer d = 10;				// int c 일반적인 변수방에 참조값을 넣으면 안들어가는게 맞아
									// Integer d 여기는 주소값이 들어가는 방에 변수를 넣으면 안들어가는게 맞아
									// 그래서 int와 Integer를 구분해서 썼어야 했어
									// 크기 저장방식 다 다르기 때문에. 불편하니까 되게 만들어 놓은게 1.5 버전 이후
									// int 값에 참조값을 넣게 된거냐. 그게 아니라 알아서 Integer( 10 ) 을 복사해서 갖다 넣나?
									// Integer d = 10; 이건 new Integer( 10 ) 해서 넣는다.
									// 그래서 parseInt랑 valueOf 를 쓸 일이 많이 없어진 것. (자료형)
									// 근데 뒤에 꼭 int 와 Integer를 구분해야 되는 곳이 있댔지 (표시하는 자리) 여기엔 반드시 Integer라고 표시해야 해



	}
}

/*
	기본 자료형에 대비되는 클래스가 하나씩 다 만들어져 있다.
	이걸 래퍼 클래스
	클래스는 첫 글자가 대문자니깐 첫글자를 대문자로 바꿔주면 되
	int는 Integer
	char는 Character 이것 두개만 다르다


	void라는 것도 있는데 void 자료형
	근데 void 자료형이라고 하기에는 좀 애매해
	void라고 하면 리턴은 하는데 값은 없다.
	'비어있는' 이런 뜻. 그래서 void 자료형이라는건 자료형이 정해지지 않은 상태, 라고 생각하면 되
	C에서는 void 포인터라는게 있어. 많이 쓰는 개념, 우리는 잘 안 써

	이런 클래스는 왜 만들어놨냐
	int a; 라고 방을 잡으면 기본 자료형으로 메모리 할당 받으라는 소리잖아?
	방만 잡으라는 소리 a방
	클래스는 Integer b; 
	이건 b방 에다가 메서드, 필드값 들이 같이 들어가
	이런 데이터들을 사용할 수 있는거지

		진짜로 래퍼클래스를 써야하는 이유는 뒤에가면 컬렉션이란걸 배우는데()활용에서 배우는 첫번째
		컬렉션 자리에는 int 라고 쓰면 에러나고 반드시 Integer 라고 써야되
		표기를 하는 자리에는 반드시 래퍼클래스로 써야 함.
		클래스니까 멤버들이 있고 멤버메서들을 사용할 수 있는데
		우리가 쓰는건 사실 Integer.parseInt() 밖에 안써
		우리한테 중요한건 래퍼클래스로만 표기하는 자리가 있다 / 요것만 기억하자

	그래서 Integer만 봐보자
	int로 방을 잡으면 그건 변수, Integer로 방을 잡으면 객체야
	이건 주의해서 볼 필요가 있어. 

	//	int	intValue() 현재 객체에서 값만 뽑아서 int 로 출력한다는 것
		원래는 int랑 Integer 는 호환이 안되. 변수랑 객체여서

	static int	parseInt(String s)  / +++++Integer 메서드 중에서 사실 이것만 쓴다고 생각하면되.+++++ 문자열을 정수로 바꿔주는 / 문자열 자리에 숫자로 된 것만 던져줘야되. /
	throws NumberFormatException	/ 숫자로 된것만 예외로 던진다는 것.

	static Integer	valueOf(int i)	/ String을 주면 Integer 객체로 돌려주는것
	String	toString()				/ 다형성 배울 때 보자

		static String	toBinaryString(int i)
		static String	toHexString(int i)
		static String	toOctalString(int i)
		(C얘기)이런 것들은 2진수를 8진수나 16진수로 바꿔서 표기하면 편한데 / 몇가지 확인하고 갈거임
			
			왜 하필 8진수나 16진수로 표기하는게 편할까?
			뒤로가면 색상같은걸 먹여야 할 때가 많아 GUI / 다음주에 배웁니다
			지금하는건 TUI / TextUserInterface
			스윙 같은 라이브러리를 사용하면 윈도우 띄울 수 있고 버튼 누를 수 있고 이벤트 처리도 할 수 있어짐
			GUI 같은걸 하면 색깔을 먹여야하는데 색깔이 
			1바이트로 3자리 0~255 RGB 이게 3개
			0~255를 10진수로 표기하면 되게 불편해서 16진수 두자리로 표시해
			하얀색을 표시하고 싶다 - 255, 255, 255 => 16진수로 하면 FF FF FF 이렇게 표기를 할 수 있어. 컴퓨터 색깔은 RGB 로 다 이렇게 밖에 못해
			256의 3승만큼. 이건 바뀔 수가 없음. 전 세계가 다 바껴야되서
			00 00 00 이건 까만색
			00 FF 00 이건 초록색
			R  G  B

			

*/