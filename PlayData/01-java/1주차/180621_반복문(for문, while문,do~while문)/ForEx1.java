/*
	�����ݷ� �� �����ϴ°� for�� �ۿ� ��������
	�� ������ ���� ���๮�̶�� ��.

		int i �� �ȿ� �ִ� ����(��������)			//cf) <-> ��������
		c������ �ۿ��� �ʱ�ȭ�ϰ� �ȿ��ٰ� i = 0 �̶�� �ص� �Ǵµ�(�޸� ������ �����ؼ�)
		�ڹٴ� �޸� ������ �ǵ帮�� �����ϱ� �ȿ��� �� ��

	for���� ���� �� ���� �����̸� �������´�

for( int i = 0; i<3; i++ ) {
 //( �ʱⰪ(ó����); ����; ������)
//	   1�� ���� ; 2�� ��; �� ���� i++4��			//�������� -> ������� ������ ���� ���پ� �����غ���
//				�Ʒ� ���� 3��
System.out.println( "i : " + i );

			//�������� �ϼ�
			int i = 0;								//�ʱ�ȭ
			if(i<3){
				System.out.println( "i : " + i );	//i : 0 ���
				i += 1;}
					
			if(i<3){
				System.out.println( "i : " + i );	//i : 1 ���
				i += 1;}
				
			if(i<3){
				System.out.println( "i : " + i );	//i : 2 ���
				}




*/


class ForEx1 {
	public static void main(String[] args) {


		//for( int i = 0; i<3; i++ ) {
		// �ʱⰪ ; ����; ������
//			System.out.println( "i : " + i );


		//for( int i = 1; i<=10; i++ ){			//������ int i = 0 ���� i<11 ���� ����


		//for( int i = 10; i>0; i-- ){			
		//	for( int i = 0; i<11; i+=2 ){		//2 4 6 8 10
		//	System.out.println( "i : " + i );

			//�������� �ϼ�


			int i = 0;								//�ʱ�ȭ
			if(i<3){
				System.out.println( "i : " + i );	//i : 0 ���
				i += 1;}
					
			if(i<3){
				System.out.println( "i : " + i );	//i : 1 ���
				i += 1;}
				
			if(i<3){
				System.out.println( "i : " + i );	//i : 2 ���
				}
		
	}	//main
}		//class

