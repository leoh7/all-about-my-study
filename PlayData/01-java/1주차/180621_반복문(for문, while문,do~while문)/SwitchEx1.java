class SwitchEx1 {
	public static void main(String[] args){
	
		int a = Integer.parseInt( args[0] );

		switch( a ){
			case 1 : System.out.println( "one" );		// 1 일 경우
			case 2 : System.out.println( "two" );		// 2 일 경우
			case 3 : System.out.println( "three" );		// 3 일 경우
			default : System.out.println( "number" );		//기본값은 이렇게

		System.out.println("\n");
/*
결과는 


three
number
전부 흘러가면서 나온다 -> 예약어 break 로 멈출 수 있음
*/		
		switch( a ){	// ()안에는 정수, 문자, 식(정수로 떨어지는 식)만 올 수 있다. 
						// JDK 1.7부터 문자열도 가능
		case 1 : System.out.println( "one" );	break;	//첫번째 break 를 만나기 전까진 계속 시작하니까 사실 {}로 묶을 필요가 없다
		case 2 : System.out.println( "two" );	break;
		case 3 : System.out.println( "three" );	break;	// :이 분기를 의미한다고 보면 됨. 분기를 의미하면 찾아보기 편하게 자기자리보다 하나 앞으로 나와서 보게 (자동완성) 만들어줌
		default : System.out.println( "number" );	//보통 모양상 디폴트는 맨 밑에다 줌
			
			}
		}
	}
}
