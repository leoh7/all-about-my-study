class StringStaticEx {

	public String nonStatic = "Hello";
	public static String yesStatic = "Hello";
	public static int number = 3;
}

class StringStaticTest{
	public static void main(String[] args) {


		StringStaticEx se1 = new StringStaticEx();
		if("Hello".equals(se1.nonStatic))	{ System.out.println("���ڿ�(Hello) �� non static�Դϴ�"); }	// ��ü.�������	/ �̷��� ������
										else{ System.out.println("���ڿ�(Hello) �� static�Դϴ�");}			
		System.out.println("");
		
		if("Hello".equals(se1.yesStatic))	{ System.out.println("���ڿ�(Hello) �� static�Դϴ�");}			// Ŭ����.�������	/ �̷��� ������
										else{ System.out.println("���ڿ�(Hello) �� non static�Դϴ�"); }
		System.out.println(se1.number);
		System.out.println(StringStaticEx.number);
	}
	/*
	����ƽ�� ��ü.���
	����ƽ�� Ŭ����.���
	*/
}
