class InnerEx1 {
	//멤버 변수
	class InstanceInner {
		int iv = 100;
		final static int CONST = 100;
	}
	
	static class StaticInner {
		int iv = 200;
		static int cv = 200;
	}
	//생성자
	
	
	//멤버 메서드
	void myMethod() {
		class LocalInner {
			int iv = 300;
			final static int CONST = 300;
		}
	}
	///////////// main 시작 //////////////
	public static void main(String[] args) {
		System.out.println("인스턴스 내부 클래스(멤버 변수 자리에 선언한 class) : "+InstanceInner.CONST);
		System.out.println("static 내부 클래스(멤버 변수 자리에 선언하고 static멤버를 정의할 수 있는 class) : "+StaticInner.cv);


	}
}
