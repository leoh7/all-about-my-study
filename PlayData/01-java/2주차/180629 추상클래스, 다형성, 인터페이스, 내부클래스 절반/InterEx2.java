// ���߻���� �ȴ�.
// Ŭ������ ���°� �ִ� �ֵ�. �� ���� �������� �浹�� ����
// interface��?
// ������ static �̱� ������ �浹 �� �� ����.	/ �޼���� ������ �� �� ����.	/ C������ vituar?? �Լ����ٰ�?	/ 

interface Inter2 {
	int b=20;
	public int getB();
}

//class InterEx2 implements Inter1, Inter2 {	// Inter1 ���� ���µ� �׳� �̷��Ը� �ᵵ / �� �������� ������ ���� �� Inter1�� Ŭ������ �����, �װ� �ٸ������� ���� �ִ°�	// inter1 �� ���������ڰ� default������
class InterEx2 implements Inter1, Inter2 {
	public int getA(){ return a; }
	public int getB(){ return b; }

	public static void main(String[] args)	{
		InterEx2 ie = new InterEx2();
		System.out.println("a : "+ ie.getA());
		System.out.println("b : "+ ie.getB());
	}
}
