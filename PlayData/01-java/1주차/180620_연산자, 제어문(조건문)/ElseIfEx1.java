/*

	���	���ǹ�
			-if( ���� ) ��;
			-if( ���� ) ��;
			else ����;
			-if( ���� ) ��;
			else if( ���� ) ��;
			...
			else ����;
			-switch ~ case

			�ݺ���
			-for
			-while
			-do ~ while

*/

class ElseIfEx1 {

/*
else if�� ���� ����! �� ����?


90�� �̻� A����
80�� �̻� B����
70�� �̻� C����
60�� �̻� D����
50�� �̻� F����
					75���̶�� ����
		if( a >= 90 && a <= 100 ) System.out.println( "A����" );		//����
		if( a >= 80 && a < 90 ) System.out.println( "B����" );		//����
		if( a >= 70 && a < 80 ) System.out.println( "C����" );		//��. ������
		if( a >= 60 && a < 70 ) System.out.println( "D����" );		//�� �� �����
		if( a >= 0 && a < 60 ) System.out.println( "F����" );			//�� ����� ��

		�̷��� else if �� ���� ������ ���� ���ͼ� �������͵� �Ǵ� ��쿡�� ����ؼ� ������ �õ��Ѵ�.
		else if �� ���α׷��� ¥�� �� �ϳ� �ɸ��� �� ���� �� �̻� �������� �ʴ´�.
		�ű⿡ ���� ���ǹ��� ���� ���� ���ε����ε� else if �� ���� ���� ������ Ʋ���� ���� �������⿡
		�ϳ��� ���յȴٴ� ��
		cf) ������ ���������� ����Ѵ� B, C ��ġ�� �ٲٸ� C ������ ���̱⿡ C������ ���͹���


					//�ּ��� ������ ���� �Ȱ��� �� �ƴϴ�. 105���� -50���� �����غ���.
*/

	public static void main(String[] args) {
		
		int a = Integer.parseInt( args[0]);

		if( a >= 90 ) System.out.println( "A����");
		else if( a >= 80 ) System.out.println( "B����");
		else if( a >= 70 ) System.out.println( "C����");
		else if( a >= 60 ) System.out.println( "D����");
		else System.out.println( "F����");					//������ ��� �ǹ�, ���� ������ ���� �����̸� �̰ɷ� �� ��� ��
		//else if( a < 60 ) System.out.println( "F����");		//�̰� ������ �� �ƴϾ� ������ �������

	}
}
