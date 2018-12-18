/*
����Ŭ����		Inner Class
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

	Anonymous		������ �� �ִ� �̸��� ���� ���		// �͸� ���� Ŭ����	//	���� �����ϴ� �ڵ忡 ���� ���´� / ������ �� �� �˾ƾ� ��.
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
	abstract class InnerAnony	-int e	���� �� �ƴѵ� ����� �� ���� Ŭ������ ��
								-disp()
		
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
	

		


	}	
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
}	

class InnerEx {
	public static void main(String[] args) {
		//Member Inner Class
//		InnerMember im = new InnerMember();	// �Ҽ��� ������� �Ѵ�
//		Outer.InnerMember im = new Outer.InnerMember();	// �̷��� �ȵǳ�?

//		Outer.InnerMember im = new Outer(). new InnerMember();	// �ȴ�
		Outer out = new Outer();								// �ȴ�
		Outer.InnerMember im = out.new InnerMember();			// �ȴ�
		im.disp();												// �ȴ�
	
		// Local Inner Class
		out.disp();
	}
}
