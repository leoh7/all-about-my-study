/*

		while( true ){		//이거 안 멈추겠다는 으지ㅣ 무한루프
		실제로 while문은 무한루프를 쓸 때 많이 쓴다.
		특정 조건을 만족하면 반복문을 끝내라.(break)

		for와 while을 구분하는 용도
		반복문이 정확하게 몇번 가는지 모를 때, 사용자가 원하는 어떤 값을 조건이 만족할 때/ 이럴 땐 while로 무한루프를 돌리는게
		//이 얘기가 이따 바로 숙제로 나갈것

	continue 반복문의 처음으로 돌아가라

	break 와 continue 는 실행문이다.
	break 와 break 라벨을 쓰는 곳이 딱하나 있어
	반복문을 통째로 빠져나가라-> 이 때 유일하게


*/

// break continue(이건 쓰질 마세요/ 실행순서가 개같이 복잡해짐	질문 : 객체지향언어의 지향점과 대척되나? 아니면 단순히 위치)
class BreakEx {
	public static void main(String[] args) 	{
		int i = 0;
		while( true ){
			if( i > 10 ) break;			
			System.out.println("i : " + i);

			
			i++;		//break를 if문의 위치에 따라 결과값이 달라질 수 있으니 정신 차리고 쓸것



		}	//while
	}	//main
}	//class
