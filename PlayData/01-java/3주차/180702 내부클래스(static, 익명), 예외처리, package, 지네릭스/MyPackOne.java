package mypack;
import static java.lang.System.out;

public class  MyPackOne{
	public void one(){
		out.println("MyPackOne 메서드");
	}

	
}

/*
import -> 해당 클래스와 폴더가 다르면 무조건 해야된다. 상위든 하위든 무조건

class 파일의 위치!(java파일의 위치는 어디있든 상관 없음.)
	package mypack;	//////////////////// 패키지는 무조건 소문자로 쓴다. 약속이여 약속 ///////////////////////
	mypack 이라는 폴더를 만들고 거기다 넣어줘라
		main에서 사용할 떄는 내 폴더 밑에 있어도 무조건 import 해야된다 그랬잖아
		import mypack.MypackOne; 이렇게

	컴파일할 때 패키지 컴파일 옵션을 줘야 함.
	javac -d. MyPackOne
	도스에서 현재폴더 .
	도스에서 상위폴더 ..
	-d		directory


*/