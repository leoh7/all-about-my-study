
// 1���� 10���� ����ϰ� = ���� ���ϱ�
// 1+2+3+4+5+6+7+8+9+10 = 55
class DoWhileEx3 {
	public static void main(String[] args) {
	
	int i = 0;
	int sum = 0;
		
		do{
		i++;	//do while�� ���� �� �ϳ��� ���������ڸ� �� ���� �ø� �� �ִٴ� ���̴�
		System.out.print(i);	//��ġ �����ϴ°� ����������
		sum += i;

		if(i < 10){System.out.print(" + ");
			}
	}while(i < 10);
	
	System.out.print(" = " + sum);
	}
}

/*	������ �ڵ�
int i = 0, sum = 0;
do {
	i++;		//������������ ��ġ�� �ָ��غ���
	sum += i;
	if(i<10) System.out.print(i + " + ");
	else System.out.print( i + " = " );
} while(i<10);
System.out.println( sum );
*/