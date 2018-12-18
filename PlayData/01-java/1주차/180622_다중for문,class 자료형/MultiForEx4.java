
// * 찍기 후 배열로 바꿔서 저장됨
class MultiForEx4 {
	public static void main(String[] args) {
		for( int i=0; i<5 ; i++ ){			//행(이 바뀔 때 바뀌는 값)
			for( int j=0; j<5 ; j++){		//열(이 바뀔 때 바뀌는 값) 
				System.out.print(i + "," + j + "\t" );
		}
		System.out.println("");
		}
	}		
}
/*
5줄, 6줄의 각각
행, 열(이 바뀔 때 바뀌는 값) 이라고 생각해야지
이걸 가로 세로라고 생각하면 오히려 더 헷갈릴 수 있다.
*/