

class IfEx2 {

	//입력받은 값이 2의 배수 이면서 3의 배수면 "공배수" 출력
	//아니면 "아니다" 출력

	public static void main(String[] args) {
		
		int a = Integer.parseInt( args[0]);

		
	
		if( a % 2 == 0 && a % 3 == 0) {
			
			System.out.println("공배수");
			
			
		} else {
			System.out.println("아니다");

		}
	
	
	}
}
