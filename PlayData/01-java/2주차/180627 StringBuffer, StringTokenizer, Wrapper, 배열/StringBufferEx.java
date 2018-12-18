class  StringBufferEx {
	public static void main(String[] args) 	{
		// 생성
		StringBuffer sb = new StringBuffer("Hello Java!!!");	//객체를 생성하면 생성자가 호출된다	 / 문자열은 스트링클래스 객체임 / 
		System.out.println("크기 : " + sb.length() );	//null 뺴고 13칸
		System.out.println("용량 : " + sb.capacity() );	//메모리가 29. 글자를 줘도 여분의 공간을 16칸 더 잡는다는 소리

		// 추가
		System.out.println("추가 : " +sb.append( "!!" ) );
		System.out.println("원본 : " +sb);			//StringBuffer는 원본을 바꿔서 Garbage를 생성하지 않는다.
		//insert
		System.out.println("추가 : " + sb.insert( 6,"JSP &"));
		System.out.println("크기 확인 : " + sb.length() );
		System.out.println("용량 확인 : " + sb.capacity() );
	
		//삭제
		System.out.println("삭제 : "+ sb.delete(6, sb.length() ) );		//항상 시작값 끝값 이런건 구해와야한다.
		System.out.println("크기 확인 : " + sb.length() );
		System.out.println("용량 확인 : " + sb.capacity() );
		
		// trimToSize()
		sb.trimToSize();
		System.out.println("크기 확인 : " + sb.length() );	//6
		System.out.println("용량 확인 : " + sb.capacity() );	//6 / 용량이 딱 맞게 줄여진다!!! 멋져

//	append(char c 등등) / 현재 문자열 뒤에 매개변수로 받은 것을 더해준다

// StringBuffer	delete(int start, int end) / 얘는 삭제하는 것도 가능하다
// int	indexOf(String str)
// StringBuffer	insert(int offset, boolean b) / offset은 몇번째에다 끼워 넣어라, 같은 것
// StringBuffer	delete(int start, int end)
// void	trimToSize() / 앞 뒤로 쓸데없는 여백을 없애는데 크기에 맞춰서

	}
}
