/*

�̿����� �ڷ�
������ �ڵ尡 �ܼ��ϴ�
�̷��� ���� �ܼ��ϰ� © �� ������ ��� ������
�����ַ��� ���ٰ� ������ ���� �� ū ������ ���� ���

*/

class WhileStudyOpen{
	public static void main(String[] args) throws Exception{
		
		int rand=(int)(Math.random()*10);
		System.out.println(rand);
		int cnt = 1 ;		//���� while�� �ȿ� �־������.

		
		while(true){
			int putValue =  System.in.read() - 48;//�ʱⰪ
			System.in.read();
			System.in.read();

			//int cnt = 1; ���� �����־���. �׷��Ƿ� while�� �� ������ int cnt �� 1�̶�� �����߰�, 
			//break �� ���������� ����, �Ʒ��� �ִ� cnt++ ���� ������� ���ϸ鼭 ���� ����, �ٸ��� �� �Ǵµ� Ƚ���� ī��Ʈ���� ���߾���

			if (putValue==rand) {
				System.out.println(cnt + "�� ���� �¾ҽ��ϴ�!" ); break;		//�� ���๮
			}else {System.out.println( putValue>rand?"ũ��":"�۴�" );}
			cnt++;

	      }//while
	}	//Exception
}	//class	