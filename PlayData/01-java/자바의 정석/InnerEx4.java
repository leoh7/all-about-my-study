class Outer{
	class InstanceInner {	// �ν��Ͻ� ���� Ŭ����
		int iv = 100;
	}

	static class StaticInner {	// static ���� Ŭ����
		int iv = 200;
		static int cv = 300;
	}

	void myMethod(){
		class LocalInner{
			int iv = 400;
		}
	}
}	// class Outer ��

class InnerEx4 {
	public static void main (String []args){
		// �ν��Ͻ� Ŭ������ �ν��Ͻ��� �����Ϸ���
		// �ܺ� Ŭ������ �ν��Ͻ��� ���� �����ؾ� �Ѵ�.
		Outer oc = new Outer();
		Outer.InstanceInner ii = oc.new InstanceInner();
		
		System.out.println("ii.iv(�ν��Ͻ� Ŭ����(ii)�� ���� iv) : " + ii.iv);
		// static ���� Ŭ���� ���� ���� �̿���
		System.out.println("Outer.StaticInner.cv(static ���� Ŭ������ static ���� cv) : " + Outer.StaticInner.cv);

		// static ���� Ŭ������ �ν��Ͻ��� �ܺ� Ŭ������ ���� �������� �ʾƵ� �ȴ�.
		Outer.StaticInner si = new Outer.StaticInner();
		System.out.println("si.iv(static ���� Ŭ������ �Ϲ� ���� iv) : "+ si.iv);
	}	//main ��
}	// class InnerEx4 ��