class InnerEx1 {
	//��� ����
	class InstanceInner {
		int iv = 100;
		final static int CONST = 100;
	}
	
	static class StaticInner {
		int iv = 200;
		static int cv = 200;
	}
	//������
	
	
	//��� �޼���
	void myMethod() {
		class LocalInner {
			int iv = 300;
			final static int CONST = 300;
		}
	}
	///////////// main ���� //////////////
	public static void main(String[] args) {
		System.out.println("�ν��Ͻ� ���� Ŭ����(��� ���� �ڸ��� ������ class) : "+InstanceInner.CONST);
		System.out.println("static ���� Ŭ����(��� ���� �ڸ��� �����ϰ� static����� ������ �� �ִ� class) : "+StaticInner.cv);


	}
}
