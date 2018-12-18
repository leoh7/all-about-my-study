/*

이열림씨 자료
굉장히 코드가 단순하다
이렇게 까지 단순하게 짤 수 있을지 상상도 못했음
도와주려고 갔다가 오히려 내가 더 큰 도움을 받은 기분

*/

class WhileStudyOpen{
	public static void main(String[] args) throws Exception{
		
		int rand=(int)(Math.random()*10);
		System.out.println(rand);
		int cnt = 1 ;		//윈래 while문 안에 넣어놨었다.

		
		while(true){
			int putValue =  System.in.read() - 48;//초기값
			System.in.read();
			System.in.read();

			//int cnt = 1; 원래 여기있었다. 그러므로 while이 돌 떄마다 int cnt 를 1이라고 선언했고, 
			//break 로 빠져나가는 순간, 아래에 있는 cnt++ 마저 수행되지 못하면서 실행 종료, 다른건 다 되는데 횟수를 카운트하지 못했었음

			if (putValue==rand) {
				System.out.println(cnt + "번 만에 맞았습니다!" ); break;		//참 실행문
			}else {System.out.println( putValue>rand?"크다":"작다" );}
			cnt++;

	      }//while
	}	//Exception
}	//class	