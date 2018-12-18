//1 ~ 100
/*
안에다 특별한 조건을 주고 100번 실행하기

*/
class  ForEx2 {
	public static void main(String[] args) {
		int cnt = 0, sum = 0, ;					//cnt count

		for( int i = 1; i<101; i++){
			//3의 배수가 아니면서 홀수인 수만 출력해라
			if(i%3 != 0 && i%2 != 0){			//왠만하면 조건 물을 때는 긍정으로 묻는게 좋다 i%2 == 1
			System.out.println("i : " + i);
			

			sum = sum + i;		//합계를 구한다, C는 이렇게 써도 차이가 없는데 JAVA는 sum += i; 로 하면 강제 형변환을 해준다
			cnt = ++cnt;		//3의 배수가 아니면서 홀수인 수의 갯수를 구한다			
			//cnt ++; 이렇게만 해도 됐구나...
			
			/*
			
			-i를 다 더한다? 이건 합
			-for문을 한번 더 쓴다?
				for(j=0; j>i; j++)		//j가 0부터; j가 i보다 작을 때; j에 하나씩 더하면서
				cnt = cnt + j;			//cnt에다가 j의 값을 더한다.
				j는 항상 i보다 작지 않나?
			-삼항연산자?
			-if문?
			-Switch랑 else if는 쓸 필요가 없다
			-cnt ++; 이렇게만 해도 됐구나...

			*/
			
			
			} //여기 괄호들이 용도가 다 다르다 if
		}	//그래서 주석을 달아주는게 좋음! for
		System.out.println("개수 : " + cnt);		//33개
		System.out.println("합계 : " + sum);		//1633
	}	//main
}	//class
