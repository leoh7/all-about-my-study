class OperatorEx2 {
	public static void main(String[] args) {
	 //��Ʈ������ �̴�.
	 //2���� ���� ������ ������ �ϴ� ��. 
	int a = 12, b = 20;
	System.out.println( "a&b : " + (a&b));	//4
	System.out.println( "a|b : " + (a|b));	//28
	System.out.println( "a^b : " + (a^b));	//24


	System.out.println( true && true );
	System.out.println( true && false );
	System.out.println( false && true );
	System.out.println( false && false );

	//System.out.println( true && false || true );	//true
	
	System.out.println( true || true );
	System.out.println( true || false );
	System.out.println( false || true );
	System.out.println( false || false );

/*
��Ʈ������(��Ʈ�� �ϴ°� �Ⱦ� |�� �� �ѹ� ����)
    & | ^ ~         ~(1�� ���� ������ / bit not) �� 1�� �켱����(�̵� ���� �ֱ��Ұ���)
    ��Ʈ �� ������(�ΰ����� ��������) ������ �ִ°� �ƴ϶� ���ڸ� ��

    short a = 5;
    0000 0000 0000 0101     5
~a 1111 1111 1111 1010     -6 (����� ������ ���� ��� ���ļ� ��� 5�� ���Ǵ� ������ -6, -5�� �� ��������)
-a 1111 1111 1111 1011     -5 (�̰� 2�� ���� ������/ �̰� ���迡 ����->)
���� �����ϱ� 0�� ���Ѵ��� -1�� �ѹ� �����ָ� ��

9�� ���� ������ -> �E���� ���� ������/ �ʿ����

bool ����? boolean ����?
(�̰ɷ� ���� �� ����)
and	or	Xor
x	y	x&y	x|y	x^y
0	0	0	0	0
0	1	0	1	1
1	0	0	1	1
1	1	1	1	0


��Ʈ �������� ���� OperatorEx2.java 
������ ���� �״�� ���� �ʴ� ��?
int a = 12;
    ...     0000 1100
int b = 20;
    ...     0001 0100

a & b     0000 0100        4
a | b      0001 1100          28
a ^ b     0001 1000         24
*/
	}
}
