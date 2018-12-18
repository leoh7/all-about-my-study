//	클래스에서 사용		다른 클래스에서 상속받을 수 없다.					/ 이건 몰랐지만 많이 쓰였음	/ 상속 얘기가 남		/ 자바의 의도와 다른거 아닌가? 상속하지 말라는건데, 쓰지 말라는건데	/ 제일 많이 쓰는 java.lang 에 있는 것 대부분이 final이야 / String 클래스는 문자열을 관리하는데, 문자열을 관리하려면 포인터를 무진장 건들어야되. 상속이 된다? 내가 클래스를 만들어서 상속받으면 내가 만든 클래스로도 문자열 건드리고 관리가 되는데 / 오직 String 클래스로만 건들어라. System도 이걸로만 건드려라 더 확장시키지 말고. 이게 클래스에 final이 붙은 의의 /  Math는? 객체 생성하지 말고 static으로 써라, 편하니까 이런 의미에서만 final / 의미가 조금씩 다른데 어쨋든 상속 받으면 안 됨
//	메소드에서 사용		상속 관계에 있는 클래스에서 재정의 할 수 없다			/ 잘 안씀					/ final 이면  상속해다 쓰지 말아라 인데 자바의 의도와 다른 것
//	변수에서 사용		변수에 있는 값을 변경할 수 없다.						/ 인터페이스에서 많이 씀		/ (변수인데)상수화 되었다


/* 
	여태까지는 누구 앞에 붙느냐에 따라 의미가 바뀌는 애는 없었다.
	그래서 FINAL 이 되게 특이한 애.
*/
/*final*/ class FinalSuper{			/*상속할 수 없다*/
//	final int a;	FinalEx.java:11: error: variable a not initialized in the default constructor
//						a라는 변수가 초기화 되어있지 않다. 초기화 누가해? 생성자. 얘가 다 할거야
//						근데 final 붙이니깐, 왜 뜬금없이 초기화 안하녜?
//						final 변수는 변경 할 수 없다.
// 원래는 객체를 만들면 초기화를 하는데 시간차가 생겨. 사용할 때는 초기화가 되있는데 일단 실행되는 과정에서는 객체에 쓰레기 값이 들어가 있어
// 생성자가 초기화 할 꺼야 라는 약속이 되어 있으니깐 그냥 넘어가는데,
// 그런데 final 은 처음 준 값이 고정이 되니까, 쓰레기 값을 초기화 시키지 못하고, 생성자가 초기화 하지 못하고 그냥 쓰레기 값이 들어가 있는대로 고정.
// 해서 쓰레기 값이 들어가 있습니다.
	public final static int a = 10;	//그래서 초기화를 항상 직접 해주어야 한다. / 메모리는 하나만 잡게 static / static 이니까 널리 쓰게 public
	
	public int getA(){
		return a;
	}
}


class FinalEx extends FinalSuper extends FinalSuper	{
	public static void main(String[] args) {
		FinalSuper fs = new FinalSuper();
	//	fs.a = 20;		FinalEx.java:28: error: cannot assign a value to final variable a -> a라는 값은 final 이라 바꿀 수가 없다!
	//	FinalSuper.a = 20;		FinalEx.java:29: error: cannot assign a value to final variable a
	
//	public int getA(){		//재정의, 오버라이드 할 수 없다.
//		return a;
//	}
	}
}
