/*
Ŭ���� ����ϴ¹� 5����
�������̽� ����ϴ¹� 5����
1.���� ���� implements �ؼ� ������ ���� ���					//Interface WindowListener �긦 ���� ���� �޼��尡 7�� �̰� �� �����ؾ� �ȴٴ� ���
2.�ƴ��� Ŭ����(��� ������ Ŭ����)�� �����ϴ� ��. ����� �������̽� Ŭ������ ����, ��� ������ ���� Ŭ������ ���� �Ѵ�. window adpater, mouse adapter ���
*/
// Adapter Class
interface Inter3 extends Inter1, Inter2{
	int c = 30;
	public int getC();
}
/*
abstract class InterSuper implements Inter3 {		// InterSuper ��� Ŭ������ �߻�ż��尡 �ƴϴ� / Ȥ�� getA()��� �޼���� InterSuper�� �������̵�(��� �ÿ��� ���� �������̵�) �Ǿ����� �ʴ�. 
//abstract class InterSuper implements Inter3 {		// �ڽĿ��� ���� �ǹ��� ���ѱ� ���	// �ڽ��� �߻�Ŭ������ �ǹ��ȴ�
	public int getA(){ return a; }		// �ݴ�� �θ� ������ �ϰ� �ڽ����� �ǹ��� �������� ���
	public int getB(){ return b; }
	public int getC(){ return c; }											

}
��üȭ�� �ǳ�?
�߻� �޼��嵵 ���µ� �߻�Ŭ������ ����?

�̷��� �ϸ� ������ ���� �ڽ��� �����ǹ��� �����(InterEx3)
������ �������̽��� 10�� �޼��尡 �ִµ� �� �߿� 1���� �������� �;�
���� ���� ���� ���� �޼������ �����ؾ� �ȴٴ� ��. ��������
	�̷��� �߰��� InterSuper�� ����� �� �����س����ϱ�
	�ڽ��� InterEx3(������ ����ϴ� Ŭ����)�� ������ �ǹ��� �������� ��.

������ ������ ����϶�� ������ ���� Ŭ������ ������
�ƴ��Ͷ�� ���ִ� Ŭ���� ���� ��¥ ��� �� ������ �س��� �ȿ� ������ �ƹ��͵� ����
�׷� �ƴ��� Ŭ������ ��ü�� ���� �޼��带 ȣ���غ��� �ǹ̰� ����?
�̷� Ŭ�������� ��ü�� �����ؼ� ����ϸ� �ȵ�. �ǹ̰� ����.
	�׷��� ������
	������ �ǹ̾��� ������ �س��� Ŭ�������� abstract �� �ھƳ� Ŭ������
	�̷��ֵ��� ����ؼ� ������(�������̵�)�� �ؼ� ���� ��� ��.

��¥�� ������� �����س��� Ŭ����(��¥ �����ϰ� �����ֵ�)�� 
abstract�� ����.
*/

abstract class InterSuper implements Inter3 {		
	public int getA(){ return a; }		
	public int getB(){ return b; }
	public int getC(){ return c; }											

}


class InterEx3 extends InterSuper {
	

	public static void main(String[] args) {
		InterEx3 ie = new InterEx3();		

		System.out.println("interface Inter3�� ��ӹ��� Inter1 �� a: "+ ie.getA());
		System.out.println("interface Inter3�� ��ӹ��� Inter2 �� b: "+ ie.getB());
		System.out.println("interface Inter3�� ������(implements) c: "+ ie.getC());
	}
}
