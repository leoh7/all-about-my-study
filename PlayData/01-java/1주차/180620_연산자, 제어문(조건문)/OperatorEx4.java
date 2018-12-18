class OperatorEx4 {
	public static void main(String[] args) {
		
	int a = 10;
	System.out.println("원래 int a 의 값 : " + a);
	System.out.println("+= 10한 : " + (a+=10) + "\n");	// 20


	System.out.println("-= 10 :" + (a-=10));	// 10
	System.out.println("-= 10한 int a 의 값 : " + a + "\n");

	System.out.println("*= 10 :" + (a*=10));	// 100
	System.out.println("*= 10한 int a 의 값 : " + a + "\n");

	System.out.println("/= 10 :" + (a/=10));	// 10
	System.out.println("/= 10한 int a 의 값 : " + a + "\n");

	System.out.println("%= 10 :" + (a%=10));	// 0
	System.out.println("%= 10한 int a 의 값 : " + a);

		
	}
}
