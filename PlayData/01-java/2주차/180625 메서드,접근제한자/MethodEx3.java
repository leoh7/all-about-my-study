/*
�Ű�����		//���� �����͸� �޾Ƽ� ���ο��� �� �� �ְ� �ϴ� ��	/ ������ �޾ƾߵ�, �� ������ ������ ������ / �����µ� �� ������ ������ / �޼��忡 ���� ������ �ڸ��� �˱׶�� ��ȣ
�μ�, ����, argument, parameter
5�� 2 ���� �� �� �� ���� ���ؼ� ���


*/

class MethodEx3 {
	//int a=5, b=2;	// ��������(��� ����)	/ �̷��� �Ǵµ� ���ڸ� 5�� 2�� �� �� �ƴ��ݾ�. �Ű�����
	
	public void hap(int a, int b) {		//int a , int b �� �Ű�����
	//	int a=5, b=2;	// ��������	/ �� ���������� ��� �ݺ��Ǳ� ������ ��������(��� ����) �� ���� ���� ���ڴ�
		System.out.println("�� : "+ (a+b));
	}
	public void cha(int a, int b) {
	//	int a=5, b=2;	// ��������
		System.out.println("�� : "+ (a-b));
	}
	public void gop(int a, int b) {
	//	int a=5, b=2;	// ��������
		System.out.println("�� : "+ (a*b));
	}
	public void mok(int a, int b) {
	//	int a=5, b=2;	// ��������
		System.out.println("�� : "+ ( double)a/b );
	}

	
	
	public static void main(String[] args){	// ��ȣ �ȿ��� ������ ������ �Ű����� / args �� ����
		//int a=5, b=2;		/ �̷��� �ϸ� ������ 8���� ���� ����
		int a=5, b=2;
		MethodEx3 me = new MethodEx3();
		//me.hap(a, b);		/2�� �����µ� 3��,1�� ������ ������ / 
		me.hap(a, b);		//���⿡ a, b�� �μ�, ����, argument, parameter
		me.cha(a, b);
		me.gop(a, b);
		me.mok(a, b);
	}

/*
�����°� �μ�, �޴°� �Ű�����
*/

}