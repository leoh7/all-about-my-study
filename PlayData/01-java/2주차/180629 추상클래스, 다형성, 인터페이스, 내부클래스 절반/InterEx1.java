/*
Ȯ���� ������ ��ߵǴ� ���ϱ� ������ Ŭ������ ������ �ؾ� �� �ʿ䰡 ����
���࿡ �� ������ �ִ� Ŭ���� 
�������̽��� ������, �޴����̴�.
	�������̽��� ��ȹǥ��
	��ȹ�� §�ٴ� ���� �̻����� ��.
	������ ���ϴ� ���� ����. �����ؼ��� �ϵ�������� ����(�ڹٰ� �ǵ帱 �� ����)�̵�.
	�ϴ� ��ȹ�� �̸� ¥���� �ִٰ� �����ϸ� �ȴ�.

�������̽� interface
interface Ű���带 ����Ѵ�
	����� �߻� �޼ҵ�θ����� �����ȴ�	//	final, abstract
final, abstract Ű���带 ���� ������ �ʴ´�.
interface�� ��ü�� ������ �� ����
��� �� implements(����) Ű���带 ����Ѵ�.
��� �� �߻� �޼ҵ�� '��������' �����ؾ� �Ѵ�.	/ �̰� ������ ��	/ ���� ��� ���� �ϸ�... ��û �����ؾߵ�	/ �ذ��ϴ� ����� �־�	/ adapter Ŭ����
���� ����� �����ϴ�.

*/
interface Inter1 {	
//	int a;	//InterEx1.java:15: error: = expected	/ final(�����Ǿ�����)	�ʱ�ȭ �ؾ��Ѵ�.	/	���ȭ�Ǿ��� ������ �ظ��ϸ� static ���ֶ�����	/	static�� �����Ǿ�����
													// static final �ʱ�ȭ�ؾ��Ѵ�	
	int a = 10;
//	public int getA(){ return a;}	// InterEx1.java:17: error: interface abstract methods cannot have body	/ �������̽� �߻� �޼���� �����θ� ���� �� ����.	 
									//abstract	������ �� ����.
	public int getA();

}	

class InterEx1 implements Inter1 {	// extends Ȯ��	// interface �׳� ��¥ ������
	public int getA(){ return a; }

	public static void main(String[] args) 	{
//		Inter1.a = 20;	//InterEx1.java:21: error: cannot assign a value to final variable a	/ ��	/ final �� ����Ǿ� �ִٴ� �Ҹ�
		System.out.println("static���� �����ϴ� a : "+Inter1.a);	// �̰� �����ȴٴ� ���� static�� ����Ǿ� �ִٴ� �Ҹ�
//		Inter1 in = new Inter1();				// InterEx1.java:27: error: Inter1 is abstract; cannot be instantiated
//		Inter1 in;	// �̰� �˴ϴ�. new�� �ȵǴ� ��	// �͸� ����Ŭ������ ���� new �˴ϴ�.
		InterEx1 ie = new InterEx1();
		System.out.println("implements �� Ŭ������(InterEx1) �����ϰ� �ν��Ͻ�ȭ �� ���� �޼��� getA() : "+ie.getA());

	}
}
