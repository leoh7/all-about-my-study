/* ��ó�⿡ ���� ����, ����� ����
	
	j	0	1	2	3	4
i
0		0	0	0	0	0
1		0	0	0	0	0
2		0	0	0	0	0
3		0	0	0	0	0
4		0	0	0	0	0



5�� 5��¥�� ��

m[i][j] = ++cnt; �߰�
	j	0	1	2	3	4
i
0		1	2	3	4	5
1		6	7	8	9	...
2		0	0	0	0	0
3		0	0	0	0	0
4		0	0	0	0	0

m[j][i] = ++cnt; �߰�
	j	0	1	2	3	4
i
0		1	6	0	0	0
1		2	7	0	0	0
2		3	8	0	0	0
3		4	9	0	0	0
4		5	...	0	0	0


int SIZE = 7	// Ȧ����
int m[][] = new int[SIZE][SIZE];

*/

class ArrayStudy {
	public static void main(String[] args) 	{
		//int m[][] = new int[5][5];
		int SIZE = 5;	// Ȧ����
		int m[][] = new int[SIZE][SIZE];

		int cnt = 0;
		for(int i=0; i<m.length ;i++){
			for(int j=0; j<m[i].length; j++){
			//	if(i==2 || j==2)		// 1��
			//	if(i==j || i==(m.length-m[i].length))		// 2�� �̻��Ѱ�
			//	if(i==j || (i+j == SIZE-1))		// 3�� ->i+j == 4 ���� 5�� ��
			//	if(i==0 || i==SIZE-1 ||j==0 || j==SIZE-1)		// 4��
			//	if(i==(j+SIZE/2) || i==(j-SIZE/2) || (i+j == (SIZE-1)/2) || i+j == (SIZE-1)+(SIZE/2) || i==SIZE/2 || j==SIZE/2)
				if(i<=j+(SIZE/2) && i+(SIZE/2)>=j && (i+j >= (SIZE-1)-(SIZE/2)) && (i+j-(SIZE/2) <= (SIZE-1)) )
					m[i][j] = ++cnt;
				
								
			}
		}

		for(int i=0; i<m.length ;i++){
			for(int j=0; j<m[i].length; j++){
				System.out.print( m[i][j] + "\t");
			}
			System.out.println();
		}
	}
}

/*	1��
	j	0	1	2	3	4
i				
0				1		
1				2		
2		3	4	5	6	7
3				8		
4				9		


	2��
	j	0	1	2	3	4
i
0		1	2	3	4	5
1		0	6	0	0	0
2		0	0	7	0	0
3		0	0	0	8	0
4		0	0	0	0	9

	3��
	j	0	1	2	3	4
i
0		1	0	0	0	2
1		0	3	0	4	0
2		0	0	5	0	0
3		0	6	0	7	0
4		8	0	0	0	9

	4��
	j	0	1	2	3	4
i
0		1	2	3	4	5
1		6	0	0	0	7
2		8	0	0	0	9
3		10	0	0	0	11
4		12	13	14	15	16



���� 
	j	0	1	2	3	4
i
0				0,2		
1			1,1	1,2	1,4	   
2		2,0	2,1	2,2	2,3	2,4
3			3,1	3,2	3,3	
4				4,2		
������ j for��
������ j for�� �ΰ��� �־�� ��

if(i<=j+(SIZE/2) && i+(SIZE/2)>=j && (i+j >= (SIZE-1)-(SIZE/2)) && (i+j-(SIZE/2) <= (SIZE-1)) )

		int SIZE = 5;	// Ȧ����
		int m[][] = new int[SIZE][SIZE];

		int cnt = 0;

for(int i=0; i<m.length; i++){
	if(i % 2 == 0){
			for(int j=0; j<m[i].length ;j++){
				if()
				m[i][j] = ++cnt;
		}
		}else{
			for(int j=0; j<m[i].length ;j++){
				if()
				m[i][j] = ++cnt;
		}
	}
			for(int i=0; i<m.length ;i++){
			for(int j=0; j<m[i].length; j++){
				System.out.print( m[i][j] + "\t");
			}
			System.out.println();
		}
}








*/