


class DoWhileEx1{
	public static void main(String[] args) {
		int i = 0;					//초기값
		do {
			System.out.println("i : " + i);
			i++;					//증감값
		} while (i<3);				//조건
	
	
	
	}	//main
}		//class

/* 해설
	while(); <-세미콜론도 붙어있음
													//질문: 반복하는 행위 자체를 (없다가) 추가할 때 유용하지 않을까?
	조건이 밑에있어서 참이면 다시 올라가고 거짓이면 안올라가고		//참이면 한번 더 실행한다
	다른게 돌거냐 말거냐 이면 
	반복문을 한번 더 실행할거냐 말거냐
		int i = 0;					
		do {
			System.out.println("i : " + i);
			i++;					
		} while (i>3);								//만약 이렇게 되면 조건이 밑에 있으니까 일단 실행하고 내려와서 한 번은 돌게 되는 것!				


*/