class Outer{
	class InstanceInner {	// 인스턴스 내부 클래스
		int iv = 100;
	}

	static class StaticInner {	// static 내부 클래스
		int iv = 200;
		static int cv = 300;
	}

	void myMethod(){
		class LocalInner{
			int iv = 400;
		}
	}
}	// class Outer 끝

class InnerEx4 {
	public static void main (String []args){
		// 인스턴스 클래스의 인스턴스를 생성하려면
		// 외부 클래스의 인스턴스를 먼저 생성해야 한다.
		Outer oc = new Outer();
		Outer.InstanceInner ii = oc.new InstanceInner();
		
		System.out.println("ii.iv(인스턴스 클래스(ii)의 변수 iv) : " + ii.iv);
		// static 내부 클래스 안의 변수 이용방법
		System.out.println("Outer.StaticInner.cv(static 내부 클래스의 static 변수 cv) : " + Outer.StaticInner.cv);

		// static 내부 클래스의 인스턴스는 외부 클래스를 먼저 생성하지 않아도 된다.
		Outer.StaticInner si = new Outer.StaticInner();
		System.out.println("si.iv(static 내부 클래스의 일반 변수 iv) : "+ si.iv);
	}	//main 끝
}	// class InnerEx4 끝