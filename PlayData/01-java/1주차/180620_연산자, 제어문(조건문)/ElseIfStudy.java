// ���� ������ �Է¹޾� else if �� �� ��
// ���� ū �� �ϳ��� ���
// else if �� Ǫ����
// ������ �ּ������� ���̴°� ���� (�ִ� 3��)
// ������ ���� �������!
import java.util.Random;
public class ElseIfStudy {
	public static void main(String[] args) {
	
	/*
	int a = Integer.parseInt( args[0] );
	int b = Integer.parseInt( args[1] );
	int c = Integer.parseInt( args[2] );
	�� ���� �ֱ� �ʹ��ʹ� ������....
	
	*/
	Random random = new Random();
	int a = random.nextInt(10);
	int b = random.nextInt(10);
	int c = random.nextInt(10);
	int d = random.nextInt(10);

	System.out.println("ù ��° �Է°� : " + a);
	System.out.println("�� ��° �Է°� : " + b);
	System.out.println("�� ��° �Է°� : " + c);
	System.out.println("�� ��° �Է°� : " + c);

	if( a >= b && a >= c )System.out.println(a);	//���� ��ȣ�� �ʿ����� �ʾҴ�
	else if( b >= c )System.out.println(b);
	else System.out.println(c);

	System.out.println("\n");
	System.out.println("\n");
	
	if( a > b && a > c && a > d )System.out.println(a);	
	else if( b > c && b > d )System.out.println(b);
	else if( c > d )System.out.println(c);
	else System.out.println(d);
/*
a Ż�� b Ż�� c Ż�� =>d
�̷��� �ϴ°� �ƴ϶�
	if( d>a && d>b && d>c) System.outprintln(d);	//�̷��� �� �ٸ� �߰� �ؼ� ������ �����ϴ°� �ξ� ����.
	if( a>b && a>c )System.out.println(a);	
	else if( b>c )System.out.println(b);
	else System.out.println(c);
*/

/*	�̰ɷ� �ȵ�
	a > b �ΰ�?
	b > c �ΰ�?
	c > a �ΰ�?
		3 4 5
		�ƴϿ�
		�ƴϿ�
		�� -> ���

		5 4 9		//����
		�� -> ���

		3 5 4
		�ƴϿ�
		�� -> ���

		4 5 3
		�ƴϿ�
		�� -> ���
*/

	}
}
