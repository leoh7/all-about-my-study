class SwitchEx1 {
	public static void main(String[] args){
	
		int a = Integer.parseInt( args[0] );

		switch( a ){
			case 1 : System.out.println( "one" );		// 1 �� ���
			case 2 : System.out.println( "two" );		// 2 �� ���
			case 3 : System.out.println( "three" );		// 3 �� ���
			default : System.out.println( "number" );		//�⺻���� �̷���

		System.out.println("\n");
/*
����� 


three
number
���� �귯���鼭 ���´� -> ����� break �� ���� �� ����
*/		
		switch( a ){	// ()�ȿ��� ����, ����, ��(������ �������� ��)�� �� �� �ִ�. 
						// JDK 1.7���� ���ڿ��� ����
		case 1 : System.out.println( "one" );	break;	//ù��° break �� ������ ������ ��� �����ϴϱ� ��� {}�� ���� �ʿ䰡 ����
		case 2 : System.out.println( "two" );	break;
		case 3 : System.out.println( "three" );	break;	// :�� �б⸦ �ǹ��Ѵٰ� ���� ��. �б⸦ �ǹ��ϸ� ã�ƺ��� ���ϰ� �ڱ��ڸ����� �ϳ� ������ ���ͼ� ���� (�ڵ��ϼ�) �������
		default : System.out.println( "number" );	//���� ���� ����Ʈ�� �� �ؿ��� ��
			
			}
		}
	}
}
