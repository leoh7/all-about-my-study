//JDK 1.7부터는 switch () 안에 문자열도 가능합니다.

class SwitchEx3 {
	public static void main(String[] args) {	

	switch( args[0]) {
	case "일" : System.out.println("하나");break;
	case "이" : System.out.println("둘");break;
	case "삼" : System.out.println("셋");break;
	default : System.out.println("넷");
	}
	}
}
/*
	parseInt 에서 꺼내면 "문자열"
	args[0] 이걸 switch~case 에 바로 넣었다.
	그렇지만 보통 정수로 많이 쓰지 잘 안씀.
	
	cf)case에도 자료형을 맞춰줘야한다.
*/
