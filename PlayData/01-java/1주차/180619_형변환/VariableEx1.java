	/*
		����		���ϴ� �� / �޸��Ҵ�		�⺻��
		����	boolean		1bit		false
		������	char		2byte		/u0000 <=null
		������	byte		1byte		0 
				short		2byte		0
				int			4byte		0
				long		8byte		0
		�Ǽ���	float		4byte		0.0	�Ҽ��� 7�ڸ�����
				double		8byte		0.0 �Ҽ��� 14�ڸ�����
	*/

class VariableEx1{
	public static void main(String[] args) {
		boolean a = true;
		System.out.println("boolean :" + a);
		
		char b = '��';
		System.out.println("char :" + b);

		//byte c = 128;
		//System.out.println("byte : " + c);
		//���ڰ� �ʹ� ũ�� ������ ����
		//������ 1����Ʈ�� ǥ���� �� �ִ� ������ -128~127 �ϳ��� ��ȣ ��
		byte c = 127;
		System.out.println("byte : " + c);

		/*
		float d = 5.0;
		System.out.println("float : " + d);
		����
		float�� ���� ũ�� ������ ������ �ƴ�. 
		�����ϰ� ���� ����� �� �� �ִ� ���� �溸�� ū ������
		5.0�� �⺻���� double => 8����Ʈ ¥���� 4����Ʈ(float) �濡 ������� �� ��
		*/
		float d = 5.0F;
		System.out.println("float : " + d);
		
		String e = "ABC";
		System.out.println("String : " + e);
		
		//����ȯ
		int num1 = 5;
		double num2 = 5.5;
		

		//int res1 = num2;
		//����
		int res1 = (int)num2;
		System.out.println("res1 :" + res1); //0.5�� �߸��� 5�� ���´�

		double res2 = num1; //�ڵ�����ȯ
		System.out.println("res2 :" + res2);
	
	}
}
