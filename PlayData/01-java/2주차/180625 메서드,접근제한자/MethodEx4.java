/*
�����ε� Overload
�޼ҵ���� ������ �Ű������� �ڷ����� �ٸ��ų�
������ �ٸ� ��
������ �ٸ� �� �ٸ� �޼���� ����Ѵ�.
*/

class MethodEx4 {
	public void hap( int a, int b ){		//�Ű������� �ް� //int a = 5, b = 2 �䷱������ ���� ��.
											//int a = 2.5, b = 4.7 �̷��� ���� ��.		
		System.out.println("�� : "+ (a+b));
	}
	public void hap( double a, double b ){
		System.out.println("�� : "+ (a+b));

	}
	public void hap(int a, int b, int c){
		System.out.println("�� : "+ (a+b+c));
	}

	public static void main (String [] args){

		MethodEx4 me = new MethodEx4();
		me.hap( 5 , 2 );					//���ڸ� ������
		me.hap( 3 , 7 );
	//	me.hap( 2.5, 4.7 );		// �����ε� ���� �� ��� ������ ����. / 8����Ʈ�ݾ�(double)	/ int �� 4����Ʈ�� // �׳� �ܼ��� �ڷ����� �޶󼭰� �ƴ϶�, ũ���� ������
		me.hap( 2.5, 4.7 );		// �����ε� ���� �� ������ ��������!
		me.hap( 2, 5, 7 );
	}
}
/*
C ���� int �� ���� ��������
hapInt( int, int )			// int �ΰ� �޴� �ָ� ���� ���� �� ��� ��
hapDouble( double, double )

C++ �� �ͼ�
hap( int, int )				// �׳� ������ ȣ���ϸ鼭 int �� �� ������ int �� �� �ް�, double �� �� ������ double �� �� �޴°ž� / �̰� ��ô ���Ѱ���
hap( double, double )
�� ����������.

�����ε��� ������ �����̳�		// 
ȣ�⿡ ������ ����.

cf) Override ���� ������ �ٸ� �����̹Ƿ� ����
*/