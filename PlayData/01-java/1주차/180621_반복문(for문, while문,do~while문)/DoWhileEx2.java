


/*
	for�� ����

	�Է°�
	for(����){
		�Է°�}

	�̷��� �ߺ��ؼ� ��ߵǴ� ������ �����.
	�̷����� do while�� �ʿ��ϴ� 
	�Ʒ� ������ ���� �����غ���
	�Ʒ� ������ for ������ ����
	2 ~ 9 �̿��� ���� �־��� ��, �ٽ� �Է��ϰ� �ϴ� ����� �� ���� ����
	�����ϴٰ� ��԰� �̰� for������ ¥���� �ϴٰ� ��� ���� ���
	if(���ǹ�){	}
	{
		for( ; ; )
	}
	�������� ����ϰԴ� ���� �� ������ �ٽ� ���°� ������ ���� ������

*/

// 2 ~ 9 ���̷� �Է� ���� ���� ������ ���
// �ƴϸ� ��� �ٽ� �Է�

class DoWhileEx2{
	public static void main(String[] args) throws Exception {

		int dan = 0;
		
		do{
			System.out.print("�� ��? : ");
			
			dan = System.in.read()	-48; //�ƽ�Ű �ڵ尪 ����
			System.in.read();	//���͸� ���� ����
			System.in.read();	//���͸� ���� ����

		}while(dan<2 || dan>9);
		for(int i=1; i<10; i++){
			System.out.println(dan + "*" + i + "=" + dan*i);
		}
		

	}
}
