/*
ĸ��ȭ( Encapsulation )	���������ڿ� ���� ��� ����
���������� / ���������� / ���ټ�����
Ŭ����					default public
������� / ����޼���		private default protected public

C������ ���� �տ��� private�� �־ ������ �Ժη� �������� ���ƶ� �ϴ� �ǹ̷� ����� �ߴµ�
Java������ ĸ��ȭ�� ū �ǹ̰� ���...
*/

class Encap	{			// class �տ��� ���������� �ְ�, ����� �տ��� ���������� �ֳ�?? ��� �ٸ���?		//class �տ� ���������� ��ü�� ������ �� �ְڳ� ���ڳ� ������ ������ ��ģ��.
	private int a=10;
	int b=20;			// default
	protected int c=30;
	public int d=40;

	public int getA()	{ return a; }
}

class EncapEx {
	private int aa=1;
	int bb=2;
	protected int cc=3;
	public int dd=4;

	public static void main(String [] args){
		Encap ec = new Encap();		
	//	System.out.println(" a : " + ec.a);	// private	���� ����� ����
		System.out.println(" b : " + ec.b);	// default	���� ������ ����
		System.out.println(" c : " + ec.c);	// protected ���� �����̰ų�(��Ű���� �켱), ��ӹ޾��� ��
		System.out.println(" d : " + ec.d);	// public	�ƹ��� ���� 

		System.out.println("");
		System.out.println("Encap Ŭ���� ���� private�� a�� �޼ҵ带 ����Ͽ� ������ : " + ec.getA() );
	
		EncapEx ec2 = new EncapEx();
		System.out.println("���� Ŭ���� �ȿ� ������ ������ ���� ������ ���캸��");
		System.out.println("a :" + ec2.aa);
		System.out.println("b :" + ec2.bb);
		System.out.println("c :" + ec2.cc);
		System.out.println("d :" + ec2.dd);
		System.out.println("������ ������!");
	}


}