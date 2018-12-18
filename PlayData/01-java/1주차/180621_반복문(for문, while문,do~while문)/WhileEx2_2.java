class WhileEx2_2 {
	public static void main(String[] args){

		int i=0;			// while을 돌리기 위한 i 선언
		int sum_even=0;		// 짝수합
		int sum_odd=0 ;		// 홀수합
		int sum=0;			// 총합
		
		while(i<100){
			i++;
		
			sum += i;				//총합 값
			if(i%2==0){				
			sum_even += i;		//짝수합
			}else{sum_odd += i;}		//홀수합
		
		/*
			처음 짰던 코드다
			이렇게 짤 거면 while을 쓸 필요가 없다. 게다가 while에 while을 중첩해가면서 까지!
			while(i%2==0){
			sum_even += i;}
			while(i%3==0){
			sum_odd += i;}
		*/
		

			//System.out.println(i);
		}
		System.out.println("짝수합 : " + sum_even );		//2550
		System.out.println("홀수합 : " + sum_odd );		//2500
		System.out.println("전체합 : " + sum );		//5050
	}
}
