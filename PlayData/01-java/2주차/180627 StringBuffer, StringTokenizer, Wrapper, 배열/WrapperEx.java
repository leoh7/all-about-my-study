/*	Wrapper Class
	boolean			Boolean
	byte			Byte
	char			Character
	double			Double
	float			Float
	int				Integer
	short			Short
	long			Long
	void			Void
*/

class  WrapperEx {
	public static void main(String[] args) {
		Integer in = new Integer( 20 );
		System.out.println( "BYTES : " + Integer.BYTES );	//�ʵ忩�� Ŭ����.�޼���
		System.out.println( "MAX_VALUE : " + Integer.MAX_VALUE );
		System.out.println( "MIN_VALUE : " + Integer.MIN_VALUE );
		
		// parseInt ���ڿ��� ������ ��ȯ���ش�

	//	int a = Integer.parseInt( "ABC" );		/ ABC �� ������������ �ٲ� ���� ����
		int a = Integer.parseInt( "123" );
	//	Integer b = Integer.parseInt( "ABC" );	/ �̰͵� 
		Integer b = Integer.valueOf( "456" );
		System.out.println( "2���� : " + Integer.toBinaryString( 20 ) );
		System.out.println( "8���� : " + Integer.toOctalString( 20 ) );
		System.out.println( "16���� : " + Integer.toHexString( 20 ) );	// 0000 0000 0000 0000  2����Ʈ�� ���µ� 8�� 8�� �׷��ߵǴµ� �� ����׸��� / �̰͵� 16���� ǥ�� ������ �׷� / 0000 0000 0001 0100 :20 �̰� ����� ���� ���ϰ� �� �� ���ڳ� / �װ� 8���� / �� 2���� ���� 3�ڸ��� ������ 8������ ��. / 000	2���� 3�ڸ��� ǥ���� �� �ִ°� 0~7 / 000 000 000 / 16������ 0000 4�ڸ� ������ ��� / 10=a, 11=b, 12=c, 13=d, 14=e, 15=f, / 07 ���� �տ� 0�� ���̸� 8����, 0x14 ���� �տ� 0x�� ���̸� 16����
	
		System.out.println( 010 );	// 8
		System.out.println( 0x10 );	// 16
		System.out.println( 0xFF );	// 256

		// ����ڽ� / ��ڽ� / 1.5��������
		int c = new Integer( 10 );
		Integer d = 10;				// int c �Ϲ����� �����濡 �������� ������ �ȵ��°� �¾�
									// Integer d ����� �ּҰ��� ���� �濡 ������ ������ �ȵ��°� �¾�
									// �׷��� int�� Integer�� �����ؼ� ���� �߾�
									// ũ�� ������ �� �ٸ��� ������. �����ϴϱ� �ǰ� ����� ������ 1.5 ���� ����
									// int ���� �������� �ְ� �Ȱų�. �װ� �ƴ϶� �˾Ƽ� Integer( 10 ) �� �����ؼ� ���� �ֳ�?
									// Integer d = 10; �̰� new Integer( 10 ) �ؼ� �ִ´�.
									// �׷��� parseInt�� valueOf �� �� ���� ���� ������ ��. (�ڷ���)
									// �ٵ� �ڿ� �� int �� Integer�� �����ؾ� �Ǵ� ���� �ִ��� (ǥ���ϴ� �ڸ�) ���⿣ �ݵ�� Integer��� ǥ���ؾ� ��



	}
}

/*
	�⺻ �ڷ����� ���Ǵ� Ŭ������ �ϳ��� �� ������� �ִ�.
	�̰� ���� Ŭ����
	Ŭ������ ù ���ڰ� �빮�ڴϱ� ù���ڸ� �빮�ڷ� �ٲ��ָ� ��
	int�� Integer
	char�� Character �̰� �ΰ��� �ٸ���


	void��� �͵� �ִµ� void �ڷ���
	�ٵ� void �ڷ����̶�� �ϱ⿡�� �� �ָ���
	void��� �ϸ� ������ �ϴµ� ���� ����.
	'����ִ�' �̷� ��. �׷��� void �ڷ����̶�°� �ڷ����� �������� ���� ����, ��� �����ϸ� ��
	C������ void �����Ͷ�°� �־�. ���� ���� ����, �츮�� �� �� ��

	�̷� Ŭ������ �� ��������
	int a; ��� ���� ������ �⺻ �ڷ������� �޸� �Ҵ� ������� �Ҹ��ݾ�?
	�游 ������� �Ҹ� a��
	Ŭ������ Integer b; 
	�̰� b�� ���ٰ� �޼���, �ʵ尪 ���� ���� ��
	�̷� �����͵��� ����� �� �ִ°���

		��¥�� ����Ŭ������ ����ϴ� ������ �ڿ����� �÷����̶��� ���µ�()Ȱ�뿡�� ���� ù��°
		�÷��� �ڸ����� int ��� ���� �������� �ݵ�� Integer ��� ��ߵ�
		ǥ�⸦ �ϴ� �ڸ����� �ݵ�� ����Ŭ������ ��� ��.
		Ŭ�����ϱ� ������� �ְ� ����޼����� ����� �� �ִµ�
		�츮�� ���°� ��� Integer.parseInt() �ۿ� �Ƚ�
		�츮���� �߿��Ѱ� ����Ŭ�����θ� ǥ���ϴ� �ڸ��� �ִ� / ��͸� �������

	�׷��� Integer�� ������
	int�� ���� ������ �װ� ����, Integer�� ���� ������ ��ü��
	�̰� �����ؼ� �� �ʿ䰡 �־�. 

	//	int	intValue() ���� ��ü���� ���� �̾Ƽ� int �� ����Ѵٴ� ��
		������ int�� Integer �� ȣȯ�� �ȵ�. ������ ��ü����

	static int	parseInt(String s)  / +++++Integer �޼��� �߿��� ��� �̰͸� ���ٰ� �����ϸ��.+++++ ���ڿ��� ������ �ٲ��ִ� / ���ڿ� �ڸ��� ���ڷ� �� �͸� ������ߵ�. /
	throws NumberFormatException	/ ���ڷ� �Ȱ͸� ���ܷ� �����ٴ� ��.

	static Integer	valueOf(int i)	/ String�� �ָ� Integer ��ü�� �����ִ°�
	String	toString()				/ ������ ��� �� ����

		static String	toBinaryString(int i)
		static String	toHexString(int i)
		static String	toOctalString(int i)
		(C���)�̷� �͵��� 2������ 8������ 16������ �ٲ㼭 ǥ���ϸ� ���ѵ� / ��� Ȯ���ϰ� ������
			
			�� ���� 8������ 16������ ǥ���ϴ°� ���ұ�?
			�ڷΰ��� �������� �Կ��� �� ���� ���� GUI / �����ֿ� ���ϴ�
			�����ϴ°� TUI / TextUserInterface
			���� ���� ���̺귯���� ����ϸ� ������ ��� �� �ְ� ��ư ���� �� �ְ� �̺�Ʈ ó���� �� �� �־���
			GUI ������ �ϸ� ������ �Կ����ϴµ� ������ 
			1����Ʈ�� 3�ڸ� 0~255 RGB �̰� 3��
			0~255�� 10������ ǥ���ϸ� �ǰ� �����ؼ� 16���� ���ڸ��� ǥ����
			�Ͼ���� ǥ���ϰ� �ʹ� - 255, 255, 255 => 16������ �ϸ� FF FF FF �̷��� ǥ�⸦ �� �� �־�. ��ǻ�� ������ RGB �� �� �̷��� �ۿ� ����
			256�� 3�¸�ŭ. �̰� �ٲ� ���� ����. �� ���谡 �� �ٲ��ߵǼ�
			00 00 00 �̰� ���
			00 FF 00 �̰� �ʷϻ�
			R  G  B

			

*/