//1��
//90���̻� " A����"		90 ~ 99
//80���̻� " B����"		80 ~ 89
//70���̻� " C����"		70 ~ 79
//60���̻� " D����"		60 ~ 69
//60���̸� " F����"		0 ~ 59

//2��
//0~100 ������ ���� ���� ���
//���� ���̸� "�߸��Է�" ���

class SwitchEx2{
	public static void main(String[] args) {
		int a = Integer.parseInt( args[0]);
/*
		int A =	a;				//(a>=90 && a<100);	//�ϴ� �̰� ������� ���� Ƣ����ϱ�
		int B = (a>=80 && a<90);
		int C = (a>=70 && a<80);
		int D = (a>=60 && a<70);
		int F = (a>=0 && a<60);

		switch (A = a>=90 && a<100){//, B = (a>=80 && a<90), C = (a>=70 && a<80), D = (a>=60 && a<70), F = (a>=0 && a<60)) {
		
		case A : System.out.println("���� : " + A);break;
		case B : System.out.println("���� : " + B);break;
		case C : System.out.println("���� : " + C);break;
		case D : System.out.println("���� : " + D);break;
		case F : System.out.println("���� : " + F);break;
		default : System.out.println("���� : " + "�ùٸ� ���� �Է��ϼ���");		
*/		
		System.out.println("1�� ����");

		
		switch ( a / 10 ){									//10 ���� ������ ������ ������? 99= 9.9=9 // 87=8.7=8
		case 10 :											//100���� ���� 9�� ���� �ϰԲ� �귯������ ����
		case 9 : System.out.println("���� : + A");break;
		case 8 : System.out.println("���� : + B");break;
		case 7 : System.out.println("���� : + C");break;
		case 6 : System.out.println("���� : + D");break;
		default : System.out.println("���� : + F");		
		}

System.out.println("\n");

				System.out.println("2�� ����");

		if(a >= 0 && a <= 100 ){
			switch ( a / 10 ){
			case 10 :											//100���� ���� 9�� ���� �ϰԲ� �귯������ ����
			case 9 : System.out.println("���� : + A");break;
			case 8 : System.out.println("���� : + B");break;
			case 7 : System.out.println("���� : + C");break;
			case 6 : System.out.println("���� : + D");break;
			default : System.out.println("���� : + F");		
			}
		}else {System.out.println("�߸��Է�");}

	}
}
