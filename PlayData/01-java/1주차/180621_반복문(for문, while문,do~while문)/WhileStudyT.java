class WhileStudyT{
	public static void main(String[] args) {

		int rand = (int)(Math.random()*10);
		int cnt = 0;

//		{
//			int a = 0; //�䷱�͵� Ȱ���Ѵ�. {}�ȿ����� �� ���� ���� ��
//		}

		whlie(true){
			cnt++;		//cnt�� 0���� �����ϰ� �ϰ� �������� ������ �ּ̳�. ����ϴ�
			System.out.print("����(0~9) : ");
			
			int answer = System.in.read() - 48;	//���� �ƽ�Ű�ڵ� 32 ��
			System.in.read();
			System.in.read();

			if( rand == answer ){
				System.out.println(cnt + "������ �����Դϴ�" );
				break;
			}else if( rand > answer ){
				System.out.println("�Է��� ���� �� �۽��ϴ�");
			}else{System.out.println("�Է��� ���� �� Ů�ϴ�");
			}

		
		}	//while
	}	//main
}	//class
