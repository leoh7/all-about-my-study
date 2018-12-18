/*
����Ŭ����	Inner Class

	
	Member		���� Ŭ������ ��� ������ ��� �޼����� ����(���� ��ġ��) Ŭ������ ����
				�ܺ� Ŭ������ ����� ������ �� �ִ�.
				static ������ ���� �� ����.						// �˰�� �輼��
				��ü�� �����ϱ� ���ؼ��� �ܺ� Ŭ������ ��ü�� ���� �����ؾ� �Ѵ�.

	Local		Ư���� �޼��� ���� Ŭ������ ���ǵ� ���	// Ȱ�뵵�� ��� ���� �� ��
				������ ����� ���� �ӽ� Ŭ������ ���
				�޼ҵ� ���ο��� ����ǰ� �޼��� �ȿ����� ��üȭ �� �� �ִ�.
				�޼��� �ܺο����� ����� �� �����ϴ�.
				���ټ�����(modifier)�� ����� �� ����.

	static		Ŭ������ static���� ����� ���
				static ������ ������ �ִٸ� Ŭ������ static���� �����ؾ� �Ѵ�.
				�ܺ� Ŭ������ static ����� ������ �� �ִ�.

	Anonymous	������ �� �ִ� �̸��� ���� ���		// �͸� ���� Ŭ����	//	���� �����ϴ� �ڵ忡 ���� ���´� / ������ �� �� �˾ƾ� ��.
				�� ���� ����ϰ� ������ �� ��ü�� ���
*/

/*
	// �ܺ�Ŭ���� outer
	class outer		- int a							
					- disp()		-class InnerLocal	-int c		// ���� ���� Ŭ���� 2��
														-disp()

					- class	InnerMember	-int b		//��� ���� Ŭ���� 1��
										-disp()
					- static class InnerStatic	-int b		// Ŭ������ static�� �����ϴ°� �Ұ���, �׷��� ���� static Ŭ������ ���� ����
												-disp()

// ���δ� Ŭ������ ������ �� �����
// �͸� ����Ŭ������ �ܵ�����
	abstract class InnerAnony	-int e	���� �� �ƴѵ� ����� �� ���� Ŭ������ ��
								-disp() ���ο� �̿ϼ��� �ֵ�(�߻�, �������̽�)�̸� �͸���Ŭ������ ���� �� �ִ�.
		
*/


// class Outer
class Outer {
	private int a = 10;
	public void disp() {
		System.out.println("Outer a :" + a);
//		System.out.println("Outer �������� InnerMember ���� ��� ���� b: " + b);	-> �̰� ������ ����. �ٱ����� �ȿ��� �����Ϸ��� �ϴµ�	/ �ֳĸ� b�� ���������ϱ�
			
			///////////////////// Member Inner Local Class ////////////////////
				/*�޼ҵ� ���ο��� ����ǰ� �޼��� �ȿ����� ��üȭ �� �� �ִ�.
				�޼��� �ܺο����� ����� �� �����ϴ�.
				���ټ�����(modifier)�� ����� �� ����.*/
			
			class InnerLocal {
				private int c=30;
				public void disp() {
					System.out.println("InnerLocal a :"+ a);
					System.out.println("InnerLocal c :" + c);
				}
			}	// InnerLocal ��
			InnerLocal il = new InnerLocal();
			il.disp();	// ���� ���� Ŭ������ �̷��� �޼��� �ȿ����� �� �� �ְ� 1ȸ������ ���� �����ߵ�	/ outer�� disp �� ������ �Ǿ� ������
			///////////////////// Member Inner Local Class ////////////////////
	
			
		


	}	// disp �޼��� ��	
	///////////////////// Member Inner Class ////////////////////
		/*
		Member		���� Ŭ������ ��� ������ ��� �޼����� ����(���� ��ġ��) Ŭ������ ����
		�ܺ� Ŭ������ ����� ������ �� �ִ�.
		*/
		
		class InnerMember{
			private int b= 20;		// ��������
			public void disp() {
				System.out.println("InnerMember b : " + b);
				System.out.println("InnerMember �ȿ����� Outer Ŭ���� a : " + a);	// -> �̰� ������ �ȳ���. �ȿ��� �ٱ��� �����Ϸ��� �ϴµ�	// ������������ ��������
			}
		}	// class InnerMember
		///////////////////// Member Inner class ////////////////////

		///////////////////// Static Inner class ////////////////////
		static class InnerStatic {
			private static int d=40;
			public void disp(){
			//	System.out.println("InnerStatic a : " + a);
				System.out.println("InnerStatic d : " + d);
			}
		}

		///////////////////// static Inner class ////////////////////
}	// class Outer

abstract class InnerAnony{
	// �������� �޼��忡�� �����ؾ� �ϱ� ������ private ����
	int e = 50;
	public abstract void disp();
}	//InnerAnony

class InnerEx {
	public static void main(String[] args) {
		//Member Inner Class
//		InnerMember im = new InnerMember();	// �Ҽ��� ������� �Ѵ�
//		Outer.InnerMember im = new Outer.InnerMember();	// �̷��� �ȵǳ�?
		//�Ҽ�.Ŭ����Ÿ�� �̸� = new ������
//		Outer.InnerMember im = new Outer(). new InnerMember();	// �ȴ�
		Outer out = new Outer();	//����̳�Ŭ������ �ܺ� Ŭ������ü�� �� �־�� �ȴ�	// �ȴ�
		Outer.InnerMember im = out.new InnerMember();			// �ȴ�
		im.disp();												// �ȴ�
	
		// Local Inner Class
		out.disp();

		// Static Inner Class
		Outer.InnerStatic is = new Outer.InnerStatic();
	
		// Anonymouse Inner Class
//		InnerAnony ia = new InnerAnony();	// �߻�Ŭ������ ���ο� �̿ϼ��� �ֵ��� �ֱ� ������ ��üȭ�� �Ұ���
		InnerAnony ia = new InnerAnony() {
			public void disp(){
				System.out.println("InnerAnony e : "+e);
				}
			};	// ��ü������ �ȵǰ� ��ӵ� �� �ް� static �� �ƴϾ� �߻�Ŭ������ �������̽����ٰ�, ��� ������ ������ �ڿ� {} �����θ� ���´�.
		ia.disp();


		new InnerAnony(){
			public void disp(){
				System.out.println("InnerAnony2 e : "+e);
			}
		}.disp();	// �޼��带 �̷��� ����! ��ü(�ν��Ͻ�).�޼���(); / �� new �� �� �̹� �ν��Ͻ�ȭ �� ���̱� ������
		
	}
}
