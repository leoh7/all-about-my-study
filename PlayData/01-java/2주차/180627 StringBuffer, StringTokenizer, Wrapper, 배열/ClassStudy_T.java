/*
�� ������ ������ Ǫ����.
���� ���� ��� Ŭ���� ������ �ڼ�� Ǯ��� �մϴ�.
�ҽ� �ִ������� ���̼���
�����ϰ� �ϸ� �ȵǰ� ������ �Է� �𸣴ϱ�
������ �Է¹޾Ҵٰ� �����ϰ� ���� ��

*/

class  ClassStudy_T {
	int kor, eng, mat;

	public ClassStudy_T(){}	//default ������
	public ClassStudy_T( int kor, int eng, int mat){
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

	public int total(){		//�Ű������� ������ ���� �޾ƾߵȴ�. / �ȴ����µ� ������ ������ ����
		return kor + eng + mat;	//tot = kor + eng + mat; �̷������� ���ϵ� �����ϴ�
	}

	public double average(){
		return total() / 3.0;	//�̷������� �޼��带 ���°� �����ϴ�, �޼���� �̷����� ���� ��.
	}
	
	public String pass() {
		return average() >= 70 ? "�հ�" : "���հ�";
	}

	
	public static void main(String[] args) {
		ClassStudy_T cs = new ClassStudy_T( 47, 55, 91);		// �����ڶ�� ��������� �ʱ�ȭ�ϴ� ���� / �ּ��� ������ 3���� �ʿ��ϴٴ� �Ҹ�
		System.out.println( "���� : " + cs.total() );
		System.out.printf( "��� : %.2f\n", cs.average() );
		System.out.println( "��� : " + cs.pass() );	// 70�� �̻��̸� "�հ�"

	}	//main
}	//class


/*
���� : 193
��� : 64.33
��� : ���հ�
*/