class OperatorEx4 {
	public static void main(String[] args) {
		
	int a = 10;
	System.out.println("���� int a �� �� : " + a);
	System.out.println("+= 10�� : " + (a+=10) + "\n");	// 20


	System.out.println("-= 10 :" + (a-=10));	// 10
	System.out.println("-= 10�� int a �� �� : " + a + "\n");

	System.out.println("*= 10 :" + (a*=10));	// 100
	System.out.println("*= 10�� int a �� �� : " + a + "\n");

	System.out.println("/= 10 :" + (a/=10));	// 10
	System.out.println("/= 10�� int a �� �� : " + a + "\n");

	System.out.println("%= 10 :" + (a%=10));	// 0
	System.out.println("%= 10�� int a �� �� : " + a);

		
	}
}
