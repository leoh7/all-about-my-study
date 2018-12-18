class StringStaticEx {

	public String nonStatic = "Hello";
	public static String yesStatic = "Hello";
	public static int number = 3;
}

class StringStaticTest{
	public static void main(String[] args) {


		StringStaticEx se1 = new StringStaticEx();
		if("Hello".equals(se1.nonStatic))	{ System.out.println("문자열(Hello) 는 non static입니다"); }	// 객체.멤버변수	/ 이렇게 쓰였다
										else{ System.out.println("문자열(Hello) 는 static입니다");}			
		System.out.println("");
		
		if("Hello".equals(se1.yesStatic))	{ System.out.println("문자열(Hello) 는 static입니다");}			// 클래스.멤버변수	/ 이렇게 쓰였다
										else{ System.out.println("문자열(Hello) 는 non static입니다"); }
		System.out.println(se1.number);
		System.out.println(StringStaticEx.number);
	}
	/*
	논스테틱은 객체.멤버
	스테틱은 클래스.멤버
	*/
}
