/*
2��		//������ �� �� �� ���ϱ�
2 * 1 = 2
2 * 2 = 4
��
��
��
		//����
3��
*/


class MultiForEx2{
	public static void main(String[] args) 	{

		for(int i=2 ; i<10 ; i++ ){		//�� (�̰͵� ó�� ������ ������ �ּ��� �ް� �ϸ� �������ڴ�)
			System.out.println(i + "��");
			
			for( int j=1 ; j<10 ; j++ ){	//�������� �� (�̰͵� ó�� ������ ������ �ּ��� �ް� �ϸ� �������ڴ�)
			System.out.println(i + " * " + j + " = " + (i*j) );
			
			}	//for j		�̰� ����ܰ迡�� �� �ּ�
		System.out.println("\n");
		}	//for i		�̰� ����ܰ迡�� �� �ּ�
		

	
	}	//main
}	//class

