//JDK 1.7���ʹ� switch () �ȿ� ���ڿ��� �����մϴ�.

class SwitchEx3 {
	public static void main(String[] args) {	

	switch( args[0]) {
	case "��" : System.out.println("�ϳ�");break;
	case "��" : System.out.println("��");break;
	case "��" : System.out.println("��");break;
	default : System.out.println("��");
	}
	}
}
/*
	parseInt ���� ������ "���ڿ�"
	args[0] �̰� switch~case �� �ٷ� �־���.
	�׷����� ���� ������ ���� ���� �� �Ⱦ�.
	
	cf)case���� �ڷ����� ��������Ѵ�.
*/
