class FlowEx33 {
	public static void main(String[] args) {
		//for���� Loop1�̶�� �̸��� �ٿ���.
		Loop1 : for( int i=2 ; i<=9 ; i++ ){		//�������� �ҰŴ�
					for( int j=1; j<=9 ; j++ ){
						if(j==5)
						break Loop1;	//j�� 5�� �� Loop1 �̶� �̸� �ٿ��� �ݺ����� Ż���Ѵ�.
					//	break;			//for j �� Ż��, ��������� 2�ܺ��� 9�ܱ��� 1,2,3,4 ���� ���� ����ȴ�.
					//	continue Loop1;	//�Ʒ� ������䰡 ������ ���� �ʴ´�? / å�� �� �� ����ϱ� ��������
					//	continue;
					System.out.println(i+"*"+j+"="+ i*j);

					}	//end of for i
		System.out.println("�������");
		}	//end of Loop1

	}
}
