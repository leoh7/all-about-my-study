// 로또 조합(1~45 6개 숫자) 10조합 출력
// 중복을 제거해야 한다. 배열 / 다중for문 사용
// 오름차순 정렬 출력
// 10조합 출력				// 삼중 for문 사용
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
				// 난수 생성
				m[i][j] = r.nextInt(45)+1;
			}
			for(int j=0; j<m[i].length; j++){
			// 같은 수가 있는지 체크	// 자기 자신 제외 // 
				//m[i][j]
//				a[] = m[i][j] 
//					for(int k=0; k<m[k].length-1; k++){
					//가정 : a[] 값은 m[i][j] 와 다르다
				/*		if(a[]==m[i][k]){
					m[i][k] = r.nextInt(45)+1
					}else{}
				*/
					}

					// 모두 다르면 진행
					// 같은 수가 있으면 해당 번호에 난수 생성
			
				// 정렬
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
