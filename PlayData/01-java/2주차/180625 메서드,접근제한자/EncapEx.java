/*
캡슐화( Encapsulation )	접근제한자에 따른 멤버 접근
접근제한자 / 접근지정자 / 접근수정자
클래스					default public
멤버변수 / 멤버메서드		private default protected public

C에서는 변수 앞에다 private을 넣어서 변수에 함부로 접근하지 말아라 하는 의미로 사용을 했는데
Java에서는 캡슐화가 큰 의미가 없어서...
*/

class Encap	{			// class 앞에도 접근제한이 있고, 멤버들 앞에도 접근제한이 있네?? 어떻게 다른가?		//class 앞에 접근제한은 객체를 생성할 수 있겠냐 없겠냐 까지만 영향을 미친다.
	private int a=10;
	int b=20;			// default
	protected int c=30;
	public int d=40;

	public int getA()	{ return a; }
}

class EncapEx {
	private int aa=1;
	int bb=2;
	protected int cc=3;
	public int dd=4;

	public static void main(String [] args){
		Encap ec = new Encap();		
	//	System.out.println(" a : " + ec.a);	// private	같은 멤버만 접근
		System.out.println(" b : " + ec.b);	// default	같은 폴더만 접근
		System.out.println(" c : " + ec.c);	// protected 같은 폴더이거나(패키지가 우선), 상속받았을 때
		System.out.println(" d : " + ec.d);	// public	아무나 접근 

		System.out.println("");
		System.out.println("Encap 클래스 내의 private한 a를 메소드를 사용하여 꺼내기 : " + ec.getA() );
	
		EncapEx ec2 = new EncapEx();
		System.out.println("같은 클래스 안에 선언한 변수의 접근 제한을 살펴보자");
		System.out.println("a :" + ec2.aa);
		System.out.println("b :" + ec2.bb);
		System.out.println("c :" + ec2.cc);
		System.out.println("d :" + ec2.dd);
		System.out.println("막힘이 없구나!");
	}


}