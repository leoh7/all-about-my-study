/*

//0~9���� �������� �ϳ� �߻���Ų��.
���ڸ� ���� �Է¹޾Ƽ�	-> DoWhileEx2 ����
�¾����� "�� ������ ��������� �˷�" �� �� break �� ������ �������´�.
Ʋ���� ��� "�۴�"/"ũ��"�� �˷��ش�.

System.in.read();
while������ © �� : �� ������ ������ ���ݾ�?
��� �Է��ߴ��� ���� �����ϰ�

*/

class WhileStudyPlus {
	public static void main(String[] args) throws Exception {
	
		int rand = (int)(Math.random()*10);
		int putValue = 0;
		int countPut = 0;


			
			//System.out.println("�������� :" + rand +"\n");
		
		
		while(true){		//(countPut >= 0) �ʱ� ���ǰ�
			System.out.print("�������'��'7 (0~9) : ");

			putValue = System.in.read() -48;	//�Է°��� �޴´�
			System.in.read();
			System.in.read();

				
					if(rand != putValue){			//�ʿ��Ѱ�?
					if(rand > putValue){			//������ ���� > �Է°����� ū����?
					System.out.println("�Է°��� �������� �۽��ϴ�!");				//ũ��
					}else{System.out.println("�Է°��� �������� Ů�ϴ�!");}		//������
					}	//���� �� if��

			countPut++;
				
					if(rand == putValue){			//������ �� �޼����� ����ϰ� break�� �������´�
					System.out.println(countPut + "�� ���� ���߼̽��ϴ�!");
						
						
						/* �غ��� ���� �� 1 =>else if�� ��ź�ϱ�
						1~10�� ���� �Է� ��ȸ�� �ִ�
						�� �̻��� ���� ���ڸ� �� ���� ��
						(0) 1 2 3 4|5| 6 |7| |8| 9
						1�� �ζǸ� ��ž߰ڴµ�? ->�ѹ� �� �غ���?
						2�� ���� ����
						3~4���� ���
						if(countPut)
						*/

						/* �غ��� ���� �� 2 => ��ǻ�Ͱ� ������ �����ؼ� ���� ���߱�(ũ�� ���� �� �� �κ��� ����ϰԲ�!)
						//break �극��ũ �̸�
						//end of �극��ũ �̸�
																//������ �̹� �����Ѵ� int rand = (int)(Math.random()*10);
						
						
						while(���� ������ ���ѷ���) 
							int randPut = (int)(Math.random()*10);	//���� �ִ� ���� �߻�								

								if(randPut == rand){
									System.out.println("���� �õ� Ƚ�� ���� ����")break;
								}else if(randPut < rand){
									System.out.println("randPut�� rand���� �۴�");
								}else if(randPut > rand){
									System.out.println("randPut�� rand���� ũ��");
								}

									
										
										
										
										randPut���� 9���� �߿��� �ִ��� Ȯ��
											while(2��° Ʈ����)
											Ʋ����//

								//�Է°��� ũ��
									�־��� ���� �ʿ�: i

							end of �극��ũ�̸�
						*/
						
						/* �غ��� ���� �� 3 => "�غ��� ���� �� 2"�� �����ϰ� Ȯ���� ǥ���غ���
						*/

					break;
				}	//���� �� if��
		}	//while

		
	
	}
}


