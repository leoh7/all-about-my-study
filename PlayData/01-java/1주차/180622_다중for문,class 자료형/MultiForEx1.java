class MultiForEx1{
	public static void main(String[] args) 	{

		for( int i=0; i<3 ; i+=2 ){			// 0 2		//�������� i+=2 �̷��� �ִ� �͵� �־��ܰ� �������, �̷��� �ָ� ���? �ڵ����� ����ȯ�� �Ͼ��.
			for( int j=0 ; j<3 ; j++ ){		// 0 1 2
				System.out.println("i : " + i + "\t" + "j : " + j );
			}
		}	//for j
	}	//for i
}

/*

i���� �ѹ� �� ��
j���� 3���� ����	for( int j=0 ; j<3 ; j++ )
*/
