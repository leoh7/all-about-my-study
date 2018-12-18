//질문 있음. 컵을 쓰고 설거지를 안하고 돌려주니까 다시 컵을 쓰려면 설거지(초기화)를 해야되는건가?

/*
클래스명		Mp3p
속성			color			색상을 기억
			memory			메모리 용량을 기억
동작			setMemory()		memory 용량을 설정한다.
			setColor()		color 값을 설정한다.
			getMemory()		memory 값을 가져온다.
			getColor()		color 값을 가져온다.

*/


class Mp3p1_1 {	
	private String	color;		// 빨간색 파란생 노란색만 만들 수 있다고 하자 -> 셋터메서드가 막아야 함 / 막고나서 알려주는 것 까지 해줘야 함
	private int		memory;		// 32 64 128 만 만들 수 있다고 하자 -> 역시 셋터메서드가 막아야 함


	public void	setColor( String c ) {
		if( c.equals("빨간색") || c.equals("파란색") || c.equals("노란색")) {
			color = c;
		} else {System.out.println("지원하지 않는 색상입니다.");}
	}	//문자열이 같으냐 라고 비교할 때는 절대로 관계연산자로 비교하면 안된다."hello" == "hello" 이거 안됨 / 이건 주소 비교이지 내용 비교가 아냐 / 문자열 비교할 때는 .equals 라는 메서드로! /  cf) 지금은 String c 가 참조변수일 뿐이지만, 객체가 되면 c.equals 이런씩으로 참조변수를 객체로 쓸 수 있다.
	
	public void	setMemory( int m ) {
		if( m==32 || m==64 || m==128 ) {
			memory = m;
		} else {
			System.out.println("지원하지 않는 용량입니다.");
		}
	}
	
	public String	getColor()		{ return color; }
	public int		getMemory()		{ return memory; }
	




	// 아래부턴 실행문

	public static void main( String[] args ){
	
		Mp3p1_1 m3 = new Mp3p1_1();	

		m3.setColor("빨간색");	//. 이라는 것은 뭐다? "뭐뭐 속에"
		m3.setMemory(32);
		System.out.println( "색상 : " + m3.getColor() );
		System.out.println( "용량 : " + m3.getMemory() );

	System.out.println();

		Mp3p m4 = new Mp3p();

		m4.setColor("보라색");	// 들어오면 안되는 데이터	//메서드가 들어오면 안되는 데이터를 걸러주고 왜 안되는지를 알려주는것. 이것이 캡슐화
		m4.setMemory( 256 );	// 들어오면 안되는 데이터	
		System.out.println( "색상 : " + m4.getColor() );
		System.out.println( "용량 : " + m4.getMemory() );	

	}
}
