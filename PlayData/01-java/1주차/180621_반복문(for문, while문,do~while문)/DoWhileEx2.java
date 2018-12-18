


/*
	for로 쓰면

	입력값
	for(조건){
		입력값}

	이렇게 중복해서 써야되는 문제가 생긴다.
	이럴때만 do while이 필요하다 
	아래 예제를 예로 생각해보자
	아래 예제를 for 문으로 쓰면
	2 ~ 9 이외의 값을 넣었을 때, 다시 입력하게 하는 기능을 쓸 수가 없다
	복습하다가 까먹고 이걸 for문으로 짜려고 하다가 담배 세대 폈다
	if(조건문){	}
	{
		for( ; ; )
	}
	형식으로 비슷하게는 만들 수 있지만 다시 묻는걸 구현할 수가 없었다

*/

// 2 ~ 9 사이로 입력 됐을 때만 구구단 출력
// 아니면 계속 다시 입력

class DoWhileEx2{
	public static void main(String[] args) throws Exception {

		int dan = 0;
		
		do{
			System.out.print("몇 단? : ");
			
			dan = System.in.read()	-48; //아스키 코드값 빼기
			System.in.read();	//엔터를 위한 범퍼
			System.in.read();	//엔터를 위한 범퍼

		}while(dan<2 || dan>9);
		for(int i=1; i<10; i++){
			System.out.println(dan + "*" + i + "=" + dan*i);
		}
		

	}
}
