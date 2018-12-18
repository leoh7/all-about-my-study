// String 클래스 연습

class StringEx {
	public static void main(String[] args)	{

		//객체 생성

		String s1 = "Hello";	// new가 없네, new가 있어야 생성자도 만드는데 / 이대로도 객체 생성이 되버렸다.
		String s2 = "Hello";	// 묵시적 객체 cf)<-> 명시적 객체	/	이렇게 쓰는게 더 좋다
		
		if( s1 == s2)System.out.println("s1은 s2와"+"같다");
		else System.out.println("s1은 s2와"+"다르다");
		if( s1.equals(s2) )System.out.println("s1은 s2와"+"같다");
		else System.out.println("s1은 s2와"+"다르다");

		String s3 = new String("Hello");	//명시적 객체	/ 나중에 또 쓸라고 하는 방법
		String s4 = new String("Hello");

		if( s3 == s4)System.out.println("s3은 s4와"+"같다");
		else System.out.println("s3은 s4와"+"다르다");
		if( s3.equals(s4) )System.out.println("s3은 s4와"+"같다");
		else System.out.println("s3은 s4와"+"다르다");

		if( s1.equals(s3) )System.out.println("s3은 s4와"+"같다");
		else System.out.println("s3은 s4와"+"다르다");

		if( "Hello".equals(s3) )System.out.println("s3은 s4와"+"같다");	//문자열에 . 찍었다는 소리는 앞에있는게 객체라는 소리	/ 객체.메서드	/스트링 클래스로 잡아야 메서드를 쓸수 있잖아	/	저게 된다는건 일단 헬로가 객체고, 스트링클래스 객체라는 소리.
		else System.out.println("s3은 s4와"+"다르다");
	
	// String 과 StringBuffer
	System.out.println();
	s1 += " Java!!!";
	if( s1 == s2)System.out.println("s1은 s2와"+"같다");
	else System.out.println("s1은 s2와"+"다르다");		//s1 에다가 추가하란 소린데 만약에 지금 hello 에다가 추가했다면 주소값이 달라질 일이 없지	/ 근데 비교값이 달라졌다는 건 문자열을 추가했을 때 주소가 달라진다는 소리	// 기존거에다가 추가하는게 아니라 새로 공간을 확보한다는 얘기다.	//	그럼 s1 만 있을 때 hello 에서 hello Java!!! 로 주소가 바뀌면 남는 Hello는 ? / 이렇게 연결이 끊긴 애들이 Garbage / JVM이 돌아다니다 메모리가 부족하면 저런걸 가져다 버림 / Garbage Collection / 저런 Garbage 가 생기는건 가상머신이 바빠지니 좋은거 아님
				//문자열에다 문자열을 추가하면, Garbage가 무조건 생긴다. 그래서 만든게 StringBuffer 클래스
				//String은 "Hello" 라고 입력하면 딱 저것만 생성함
				//StringBuffer는 뒤에 공간을 더 잡아. 뒤에 추가할 공간을 충분히 두기때문에 

				//그래서 문자열의 길이가 변한다면 StringBuffer
				//문자열의 길이에 가변이 없으면 String으로 잡는게 좋다.
				//게다가 String과 StringBuffer는 호환성이 있어서 쓰는데 있어 구별해 썼다 바꿨다 할 수 있다.

				//String 과 StringBuffer의 차이를 설명할 수 있다는건 기본적인 메모리와 프로그램 구동의 방식을 어느정도 알고 있다는 것.
	
	// 메서드 
// char charAt(int index))
//	0 1 2 3 4 5 6 7 8 9 10 11 12 13	/<-index
//  H e l l o   J a v a  !  !  ! \0

	System.out.println("charAt : " + s1.charAt(6) );		// 왜 에러나냐 왜

// compareToIgnoreCase?(String str)	
// 대소문자 무시해서 비교해라

// String concat?(String str)	
	System.out.println("concat : " + s1.concat("!!") );
	// s1에 추가해서 보여주는 건데 한번 출력시키고 주소를 담아놓지 않기에 가비지 대상이 된다. 없어짐 나중에
	System.out.println("concat을 붙여도 사실 s1의 상태는 : " + s1);
//startsWith?(String prefix)	
//	나중에 웹 프로그램 같은거 만들 때 (게시판 같은거) / 검색 달려있는거. 제목으로 검색, 내용으로 검색 등 만들잖아 / 자바 라고 검색하면 정확하게 자바를 찾는게 아니라 자바라는 문자열이 있는걸 찾는것.
//	자바라는 문자열로 시작하는걸 다 찾아주는 것. endsWith로 하면 자바라고 끝나는 건 다 찾아주는 것.

//boolean	equals?(Object anObject)
//저기 Object 에 String 쓰지 않았어? / 활용중에 컬렉션이라는 걸 배워야 되는데 컬렉션을 배우기 위해선 제네릭을 배워야되. / 그게 Object와 연관이 있고 / Object를 받는 메서드들. / 객체는 다 받아준다. 객체 '만' / 문자열도 객체지? 스트링 클래스 객체 / 그래서 equals 에 다 들어간것 / 나중에 상속 배우면 더 쓸거

//static String	format?(String format, Object... args)
//... 뭐냐 씨바 / 이따 배열할 때 볼꺼야. / 다른 언어엔 .. 도 있어

//byte[]	getBytes()
//캐릭터셋 바꿀 때 쓰는건데 다음달에 JSP 할 때 존나 많이 볼거임 / getBytes 오버로딩 많이 되있네

//int indexOf?(int ch)	
	System.out.println("indexOf J : " + s1.indexOf('J'));	//int ch 

//	indexOf?(int ch)
	System.out.println("indexOf a : " + s1.indexOf('a', 8/*시작위치*/));	//int ch 

//	lastIndexOf?(int ch)	
	System.out.println("LastIndexOf : " + s1.indexOf('j'));	// 못 찾는 값은 -1이 나온다. 자바스크립트에서도 쓸 거임.
	System.out.println("LastIndexOf : " + s1.indexOf('a'));
	
// boolean	isEmpty() 비어있으면 true, 차 있으면 false
// is 가 중요해서 본 것. 

// int	length()
	System.out.println("length : "+ s1.length() );	//13이 나온다. / null 값은 문자갯수로 계산을 안한다. / null은 위치값
//	System.out.println("length : "+ s1.length() );

// 매개변수 4개 5개 있는건 존나 복잡하니깐 잘 안 쓴다고 생각을 하면 되

// String[]	split?(String regex) / regex 를 기준으로 해서 문자를 잘라주는것.

// String	substring?(int beginIndex)
	System.out.println( "substring : " + s1.substring(6));	//맨 끝에 \0이 잘림
// String	substring?(int beginIndex, int endIndex)			//endIndex 는 -1 만큼 나온다. \0이 필요해서 맨 마지막 자르고 \0을 넣기 때문에 
	System.out.println( "substring : " + s1.substring(6, 12));	//12만큼 뽑으랬는데 11만큼 뽑힌다
// char[]	toCharArray() 내일 숙제 할 때 쓸 수도 있음 // 문자 배열로 쓰는것

// String	toString()	클래스마다 있는 클래스가 있는데, 다형성이 적용된 상태이다
// 다형성이 나오면 그 때 다시 볼건데, 무척 조심해서 써야할 독특한 애. 나중에 다시 얘기할거임

// String	trim()	/	이건 트림기능이라고 언어마다 다 있는 기능

	String str = "                            a             3           3          44   ";
	System.out.println("str : "+ str);
	System.out.println("trim : "+ str.trim());	//앞 뒤로 쓸데없는 공백을 없애줌. 가운데에 있는건 못 없앰
	//id : _____ 이런 부분. 실수로 띄어쓰기를 입력하고 아이디를 입력했다, 이걸 데이터베이스에 넣으면 로그인을 못하지. 뒤에다 띄어쓰기하면? 이거를 받아올 때는 id.trim 해서 데이터 베이스에 넣어라, 혹은 등등 띄어쓰기 없앨 때

// static String	valueOf?(boolean b) / 오버로드 무척 많음
//	int a = (int)5.5;
//	char b = (char)70000;	//캐릭터 방은 
//	int c = (int)"ABC";	// 이러면 안되이러면 / 스트링으로 만든건 객체야 객체 / 
//	String d = 100;		// 이것도 안들어가. 기본 자료형과 스트링클래스는 호환해서 넣으면 안되
//	String d = (String)100;	//이것도 안되	/ 형변환은 기본 자료형들 끼리만 하는 거야
//	그래서 쓰는게 valueOf

//	String d = String.valueOf(100);
//	int e = "100"; / 이거 맨날 쓰던 거지. 이건 어떻게 됐다?
//	int e = Integer.parseInt("100");
//	int f = Integer.valueOf("100");	

//	int f = Integer.valueOf("ABC");	//이건 에러는 없는데, 예외 생김. 이건 하면 안되 parseInt 라는애가 문자열을 숫자로 바꿔주는 거잖아? 문자열 형태로 되있는 건 못 바꿔줘	

	}
}
/*
String 의 Constructors 중 ascii 같은 것들
-문자셋 웹 프로그래밍 할 때 볼거임

Deprecated. 옛날 버전이다 라는 뜻 / 더 좋은게 나왔으니깐 그거 써라
	스프링 까지는 안 쓸 건데
	다른 애들까지 가면 버전 때문에 쓸 수도 있음
	안돌아가는건 아니고

String?(String original)	
	매개변수에 클래스아녀?
	이쪽으로 객체 달라는 것. 특이하게도
	스트링 클래스를 만드는 객체인데 스트링클래스 객체를 만든대
	근데 생성자 중에는 이걸 제일 많이 씀

String?(StringBuffer buffer)	
	이건 나중에 볼거임




*/

/*
원래 문자열을 저장하면 문자방을 만들어서 저장한댔지
'a''b''c''null'
C는 char * 캐릭터 포인터 로 관리하는데
자바에서는 String 으로 관리한다.

자바에서의 문자열은 'String 클래스'이다.
자바에서는 문자열을 쓰면 그건 'String 클래스 객체'가 된다 이미
	String s1 = "Hello";
	이렇게 쓰면 힙 영역에 이미 저장이 됨
	스택 s1 이라는 방에 힙에있는 헬로의 시작주소를 갖다 준것

s2는?
문자열은 메모리가 커. 메모리관리가 필요해서 기본적으로 똑같은 문자열을 또 사용할 때는 메모리를 또 잡지 않아
그냥 그 주소만 가져다 쓸 뿐.
	String s2 = "Hello";
	현재 힙 영역에 Hello 라고 저장된 것은 한 개

명시적 객체란?
new를 해서 만들어 낸 것.
String?(String original)	
스트링 클래스 객체를 내놔라, 라는건 문자열을 내놔라 라는 것.
	"Hello" 가 스트링 클래스 객체




	String s3 = new String("Hello");	//명시적 객체	/ 나중에 또 쓸라고 하는 방법
	힙 영역에 메모리를 새로 할당 받아서 저장했어
	이게 s3 이고
	String s4 = new String("Hello");
	이렇게 하면 메모리 할당이 또 생긴거야

현재 힙 영역에 저장된 "Hello"는 s1,s2가 참조하는 거 하나.
s3 하나, s4 하나 해서 총 3개가 저장되어있다.

	s1 == s2 스택에 저장된 참조 값(시작주소)이 같으냐
	s1.equals(s2) 가리키는 값이 같냐
	s3 == s4 스택에 있는 참조 값(시작주소)이 같으냐
	s3.equals(s4) 가리키는 값이 같냐 -> 같지 어쨋든 문자 값이 같으니깐

*/