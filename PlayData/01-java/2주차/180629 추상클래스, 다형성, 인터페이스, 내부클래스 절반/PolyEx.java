//�߻� Ŭ������ �̿��� ������
/*
���� ���� �� ���ε�
������ ���� ���� ����.

*/
abstract class Design{
	int a=5, b=7, c=3;					// �غ�, ���� or ������	c<- ����
	double area;					// ����
	public abstract void calc();	// ���
	public abstract void disp();	// ���
}


class Rect extends Design{		//	�簢�� �غ�*����
//	public void calc(){}	// ��������� �����(�����س���) ������ �ȳ���.
	public void calc(){ area = a*b;	}
	public void disp(){ System.out.println("Rect�� ���̴� : "+ (int)area); }
}
class Tri extends Design{		//	( �ﰢ�� �غ�*���� )/ 2
	public void calc(){ area = (a*b)/2.0; }			// �ڿ� 2.0 ���� ���°� ����
	public void disp(){ System.out.println("Tri�� ���̴� : "+ area); }
}
class Circle extends Design{	//	 ������*������ PI
	
	public void calc(){ area = (a*a)*Math.PI; }
	public void disp(){ System.out.println("Circle�� ���̴� : "+ area); }
}
class Ladder extends Design{	// ��ٸ����� ���� ����+�Ʒ��� *���� /2
	public void calc(){ area = (c+a)*b/2.0; }
	public void disp(){ System.out.println("Ladder�� ���̴� : "+ area); }
}

class  PolyEx {
	public static void main(String[] args) {
		// ladder	��ٸ����� ����

		Design de[] = { new Rect(), new Tri(), new Circle(), new Ladder() };
		for(Design d : de){		// d �ε��� , de �迭�̸�, Design d / Design d �ڷ���
			d.calc();			// �������̵� ���ִ� ���¿����� �ڽ��� ����ȴ�.
			d.disp();
		}
		
		
		/*
		Rect r = new Rect();
		Tri t = new Tri();
		Circle c = new Circle();

		r.calc();
		r.disp();

		t.calc();
		t.disp();

		c.calc();
		c.disp();
		*/
	}
}
