// String Ŭ���� ����

class StringEx {
	public static void main(String[] args)	{

		//��ü ����

		String s1 = "Hello";	// new�� ����, new�� �־�� �����ڵ� ����µ� / �̴�ε� ��ü ������ �ǹ��ȴ�.
		String s2 = "Hello";	// ������ ��ü cf)<-> ����� ��ü	/	�̷��� ���°� �� ����
		
		if( s1 == s2)System.out.println("s1�� s2��"+"����");
		else System.out.println("s1�� s2��"+"�ٸ���");
		if( s1.equals(s2) )System.out.println("s1�� s2��"+"����");
		else System.out.println("s1�� s2��"+"�ٸ���");

		String s3 = new String("Hello");	//����� ��ü	/ ���߿� �� ����� �ϴ� ���
		String s4 = new String("Hello");

		if( s3 == s4)System.out.println("s3�� s4��"+"����");
		else System.out.println("s3�� s4��"+"�ٸ���");
		if( s3.equals(s4) )System.out.println("s3�� s4��"+"����");
		else System.out.println("s3�� s4��"+"�ٸ���");

		if( s1.equals(s3) )System.out.println("s3�� s4��"+"����");
		else System.out.println("s3�� s4��"+"�ٸ���");

		if( "Hello".equals(s3) )System.out.println("s3�� s4��"+"����");	//���ڿ��� . ����ٴ� �Ҹ��� �տ��ִ°� ��ü��� �Ҹ�	/ ��ü.�޼���	/��Ʈ�� Ŭ������ ��ƾ� �޼��带 ���� ���ݾ�	/	���� �ȴٴ°� �ϴ� ��ΰ� ��ü��, ��Ʈ��Ŭ���� ��ü��� �Ҹ�.
		else System.out.println("s3�� s4��"+"�ٸ���");
	
	// String �� StringBuffer
	System.out.println();
	s1 += " Java!!!";
	if( s1 == s2)System.out.println("s1�� s2��"+"����");
	else System.out.println("s1�� s2��"+"�ٸ���");		//s1 ���ٰ� �߰��϶� �Ҹ��� ���࿡ ���� hello ���ٰ� �߰��ߴٸ� �ּҰ��� �޶��� ���� ����	/ �ٵ� �񱳰��� �޶����ٴ� �� ���ڿ��� �߰����� �� �ּҰ� �޶����ٴ� �Ҹ�	// �����ſ��ٰ� �߰��ϴ°� �ƴ϶� ���� ������ Ȯ���Ѵٴ� ����.	//	�׷� s1 �� ���� �� hello ���� hello Java!!! �� �ּҰ� �ٲ�� ���� Hello�� ? / �̷��� ������ ���� �ֵ��� Garbage / JVM�� ���ƴٴϴ� �޸𸮰� �����ϸ� ������ ������ ���� / Garbage Collection / ���� Garbage �� ����°� ����ӽ��� �ٺ����� ������ �ƴ�
				//���ڿ����� ���ڿ��� �߰��ϸ�, Garbage�� ������ �����. �׷��� ����� StringBuffer Ŭ����
				//String�� "Hello" ��� �Է��ϸ� �� ���͸� ������
				//StringBuffer�� �ڿ� ������ �� ���. �ڿ� �߰��� ������ ����� �α⶧���� 

				//�׷��� ���ڿ��� ���̰� ���Ѵٸ� StringBuffer
				//���ڿ��� ���̿� ������ ������ String���� ��°� ����.
				//�Դٰ� String�� StringBuffer�� ȣȯ���� �־ ���µ� �־� ������ ��� �ٲ�� �� �� �ִ�.

				//String �� StringBuffer�� ���̸� ������ �� �ִٴ°� �⺻���� �޸𸮿� ���α׷� ������ ����� ������� �˰� �ִٴ� ��.
	
	// �޼��� 
// char charAt(int index))
//	0 1 2 3 4 5 6 7 8 9 10 11 12 13	/<-index
//  H e l l o   J a v a  !  !  ! \0

	System.out.println("charAt : " + s1.charAt(6) );		// �� �������� ��

// compareToIgnoreCase?(String str)	
// ��ҹ��� �����ؼ� ���ض�

// String concat?(String str)	
	System.out.println("concat : " + s1.concat("!!") );
	// s1�� �߰��ؼ� �����ִ� �ǵ� �ѹ� ��½�Ű�� �ּҸ� ��Ƴ��� �ʱ⿡ ������ ����� �ȴ�. ������ ���߿�
	System.out.println("concat�� �ٿ��� ��� s1�� ���´� : " + s1);
//startsWith?(String prefix)	
//	���߿� �� ���α׷� ������ ���� �� (�Խ��� ������) / �˻� �޷��ִ°�. �������� �˻�, �������� �˻� �� �����ݾ� / �ڹ� ��� �˻��ϸ� ��Ȯ�ϰ� �ڹٸ� ã�°� �ƴ϶� �ڹٶ�� ���ڿ��� �ִ°� ã�°�.
//	�ڹٶ�� ���ڿ��� �����ϴ°� �� ã���ִ� ��. endsWith�� �ϸ� �ڹٶ�� ������ �� �� ã���ִ� ��.

//boolean	equals?(Object anObject)
//���� Object �� String ���� �ʾҾ�? / Ȱ���߿� �÷����̶�� �� ����� �Ǵµ� �÷����� ���� ���ؼ� ���׸��� ����ߵ�. / �װ� Object�� ������ �ְ� / Object�� �޴� �޼����. / ��ü�� �� �޾��ش�. ��ü '��' / ���ڿ��� ��ü��? ��Ʈ�� Ŭ���� ��ü / �׷��� equals �� �� ���� / ���߿� ��� ���� �� ����

//static String	format?(String format, Object... args)
//... ���� ���� / �̵� �迭�� �� ������. / �ٸ� �� .. �� �־�

//byte[]	getBytes()
//ĳ���ͼ� �ٲ� �� ���°ǵ� �����޿� JSP �� �� ���� ���� ������ / getBytes �����ε� ���� ���ֳ�

//int indexOf?(int ch)	
	System.out.println("indexOf J : " + s1.indexOf('J'));	//int ch 

//	indexOf?(int ch)
	System.out.println("indexOf a : " + s1.indexOf('a', 8/*������ġ*/));	//int ch 

//	lastIndexOf?(int ch)	
	System.out.println("LastIndexOf : " + s1.indexOf('j'));	// �� ã�� ���� -1�� ���´�. �ڹٽ�ũ��Ʈ������ �� ����.
	System.out.println("LastIndexOf : " + s1.indexOf('a'));
	
// boolean	isEmpty() ��������� true, �� ������ false
// is �� �߿��ؼ� �� ��. 

// int	length()
	System.out.println("length : "+ s1.length() );	//13�� ���´�. / null ���� ���ڰ����� ����� ���Ѵ�. / null�� ��ġ��
//	System.out.println("length : "+ s1.length() );

// �Ű����� 4�� 5�� �ִ°� ���� �����ϴϱ� �� �� ���ٰ� ������ �ϸ� ��

// String[]	split?(String regex) / regex �� �������� �ؼ� ���ڸ� �߶��ִ°�.

// String	substring?(int beginIndex)
	System.out.println( "substring : " + s1.substring(6));	//�� ���� \0�� �߸�
// String	substring?(int beginIndex, int endIndex)			//endIndex �� -1 ��ŭ ���´�. \0�� �ʿ��ؼ� �� ������ �ڸ��� \0�� �ֱ� ������ 
	System.out.println( "substring : " + s1.substring(6, 12));	//12��ŭ �������µ� 11��ŭ ������
// char[]	toCharArray() ���� ���� �� �� �� ���� ���� // ���� �迭�� ���°�

// String	toString()	Ŭ�������� �ִ� Ŭ������ �ִµ�, �������� ����� �����̴�
// �������� ������ �� �� �ٽ� ���ǵ�, ��ô �����ؼ� ����� ��Ư�� ��. ���߿� �ٽ� ����Ұ���

// String	trim()	/	�̰� Ʈ������̶�� ���� �� �ִ� ���

	String str = "                            a             3           3          44   ";
	System.out.println("str : "+ str);
	System.out.println("trim : "+ str.trim());	//�� �ڷ� �������� ������ ������. ����� �ִ°� �� ����
	//id : _____ �̷� �κ�. �Ǽ��� ���⸦ �Է��ϰ� ���̵� �Է��ߴ�, �̰� �����ͺ��̽��� ������ �α����� ������. �ڿ��� �����ϸ�? �̰Ÿ� �޾ƿ� ���� id.trim �ؼ� ������ ���̽��� �־��, Ȥ�� ��� ���� ���� ��

// static String	valueOf?(boolean b) / �����ε� ��ô ����
//	int a = (int)5.5;
//	char b = (char)70000;	//ĳ���� ���� 
//	int c = (int)"ABC";	// �̷��� �ȵ��̷��� / ��Ʈ������ ����� ��ü�� ��ü / 
//	String d = 100;		// �̰͵� �ȵ�. �⺻ �ڷ����� ��Ʈ��Ŭ������ ȣȯ�ؼ� ������ �ȵ�
//	String d = (String)100;	//�̰͵� �ȵ�	/ ����ȯ�� �⺻ �ڷ����� ������ �ϴ� �ž�
//	�׷��� ���°� valueOf

//	String d = String.valueOf(100);
//	int e = "100"; / �̰� �ǳ� ���� ����. �̰� ��� �ƴ�?
//	int e = Integer.parseInt("100");
//	int f = Integer.valueOf("100");	

//	int f = Integer.valueOf("ABC");	//�̰� ������ ���µ�, ���� ����. �̰� �ϸ� �ȵ� parseInt ��¾ְ� ���ڿ��� ���ڷ� �ٲ��ִ� ���ݾ�? ���ڿ� ���·� ���ִ� �� �� �ٲ���	

	}
}
/*
String �� Constructors �� ascii ���� �͵�
-���ڼ� �� ���α׷��� �� �� ������

Deprecated. ���� �����̴� ��� �� / �� ������ �������ϱ� �װ� ���
	������ ������ �� �� �ǵ�
	�ٸ� �ֵ���� ���� ���� ������ �� ���� ����
	�ȵ��ư��°� �ƴϰ�

String?(String original)	
	�Ű������� Ŭ�����Ƴ�?
	�������� ��ü �޶�� ��. Ư���ϰԵ�
	��Ʈ�� Ŭ������ ����� ��ü�ε� ��Ʈ��Ŭ���� ��ü�� �����
	�ٵ� ������ �߿��� �̰� ���� ���� ��

String?(StringBuffer buffer)	
	�̰� ���߿� ������




*/

/*
���� ���ڿ��� �����ϸ� ���ڹ��� ���� �����Ѵ���
'a''b''c''null'
C�� char * ĳ���� ������ �� �����ϴµ�
�ڹٿ����� String ���� �����Ѵ�.

�ڹٿ����� ���ڿ��� 'String Ŭ����'�̴�.
�ڹٿ����� ���ڿ��� ���� �װ� 'String Ŭ���� ��ü'�� �ȴ� �̹�
	String s1 = "Hello";
	�̷��� ���� �� ������ �̹� ������ ��
	���� s1 �̶�� �濡 �����ִ� ����� �����ּҸ� ���� �ذ�

s2��?
���ڿ��� �޸𸮰� Ŀ. �޸𸮰����� �ʿ��ؼ� �⺻������ �Ȱ��� ���ڿ��� �� ����� ���� �޸𸮸� �� ���� �ʾ�
�׳� �� �ּҸ� ������ �� ��.
	String s2 = "Hello";
	���� �� ������ Hello ��� ����� ���� �� ��

����� ��ü��?
new�� �ؼ� ����� �� ��.
String?(String original)	
��Ʈ�� Ŭ���� ��ü�� ������, ��°� ���ڿ��� ������ ��� ��.
	"Hello" �� ��Ʈ�� Ŭ���� ��ü




	String s3 = new String("Hello");	//����� ��ü	/ ���߿� �� ����� �ϴ� ���
	�� ������ �޸𸮸� ���� �Ҵ� �޾Ƽ� �����߾�
	�̰� s3 �̰�
	String s4 = new String("Hello");
	�̷��� �ϸ� �޸� �Ҵ��� �� ����ž�

���� �� ������ ����� "Hello"�� s1,s2�� �����ϴ� �� �ϳ�.
s3 �ϳ�, s4 �ϳ� �ؼ� �� 3���� ����Ǿ��ִ�.

	s1 == s2 ���ÿ� ����� ���� ��(�����ּ�)�� ������
	s1.equals(s2) ����Ű�� ���� ����
	s3 == s4 ���ÿ� �ִ� ���� ��(�����ּ�)�� ������
	s3.equals(s4) ����Ű�� ���� ���� -> ���� ��¶�� ���� ���� �����ϱ�

*/