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

class IfEx3 {

	//�Է¹��� ���� 2~9 ���̸� "����"
	// �ƴϸ� "������"

	public static void main(String[] args) {
		
		int a = Integer.parseInt( args[0]);

		if( a >= 2 && a <= 9 ){
			System.out.println("����");
		}else{
			System.out.println("������");
		}

	}
}
