// �ζ� ����(1~45 6�� ����) 10���� ���
// �ߺ��� �����ؾ� �Ѵ�. �迭 / ����for�� ���
// �������� ���� ���
// 10���� ���				// ���� for�� ���
/*

14	15	18	37	38	43
7	.	.	.	.	.
5	.	.	.
10	.	.	.
5	.	.
1	.	.
6	.	.
4	.	.	
2	.	.
5	.

*/


import java.util.Random;
class ArrayStudy_Lotto {
	public static void main(String[] args) 	{
		Random r = new Random();
	
		int m[][] = new int [10][6];
		for(int i=0; i<m.length; i++){
			int a[] = new int[1];
			for(int j=0; j<m[i].length; j++){
				// ���� ����
				m[i][j] = r.nextInt(45)+1;
			}
			for(int j=0; j<m[i].length; j++){
			// ���� ���� �ִ��� üũ	// �ڱ� �ڽ� ���� // 
				//m[i][j]
//				a[] = m[i][j] 
//					for(int k=0; k<m[k].length-1; k++){
					//���� : a[] ���� m[i][j] �� �ٸ���
				/*		if(a[]==m[i][k]){
					m[i][k] = r.nextInt(45)+1
					}else{}
				*/
					}

					// ��� �ٸ��� ����
					// ���� ���� ������ �ش� ��ȣ�� ���� ����
			
				// ����
			}
			
		}

		for(int i=0; i<m.length; i++){
			for(int j=0; j<m[i].length; j++){
			System.out.print(m[i][j] + "\t");
			}
			System.out.println();
		}

	}
}
