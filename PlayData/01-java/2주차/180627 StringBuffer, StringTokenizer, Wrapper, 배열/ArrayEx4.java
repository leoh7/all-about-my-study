class ArrayEx4 {
	public static void main(String[] args) {
		// int m[][] = new int[3][2];
		// int m[][] = new int[][]{ {10,20},{30,40},{50,60} };	//행단위로 묶어줘야함(2차원 배열이기 때문에)
		// 꺼낼 때 m[i][j]
		

		//	2차원 배열은 2중 포인터 무척 어려움, 근데 우리는 쓸 일 없음
		/*	2차원 배열은 1차원 배열 여러개를 겹쳐 놓은 것이다. 라고 생각하면 됨 쉽게
			
		*/

		int m[][] = { {10,20},{30,40},{50,60} };
//		int m[][] = { {10,20},{30,40,70,80},{50,60} };	//가변배열
		
		int a[] = {10, 20};
		int b[] = {30, 40};
		int c[] = {50, 60};
		int w[][] = {a, b, c};


		for(int i=0; i<m.length; i++){				// 행	0 1 2	/2차원배열이름.length
			for(int j=0; j<m[i].length;j++){		// 열	0 1		/m[i].length
				System.out.print(
					"m[" + i+ "][" + j + "] : " +m[i][j] + "\t");	//한 행의 이름은 전체 m이라는 배열의 0행 -> 1행의 이름 = m[0], m[1], m[2]<-이게 배열의 이름이 되는것.
					
				}
				System.out.println();
		}
	}
}
