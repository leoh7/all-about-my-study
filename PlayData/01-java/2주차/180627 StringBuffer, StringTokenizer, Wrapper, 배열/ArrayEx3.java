/*Varialbe Argument
같은 자료형들만 된다, 왜 그러나면 배열이기 때문
1개를 던지면 하나를 만들고 2개를 던지면 두개를 만들고
static <T> List<T>	asList(T... a)
	
*/

class ArrayEx3 {
	/*
	public void disp(String str) {
		System.out.println(str);
	}
	public void disp(String str1, String str2) {
		System.out.println(str1 + str2);
	}
	*/
	public void disp(String ... str ) {
		for( String s : str){
		System.out.print( s );
		}
		System.out.println();
	}

	/*만약에 굳이 int형을 더 던질래 하면
	public void disp(int a, String ... str ) {
		for( String s : str){
		System.out.print( s );
		}
		System.out.println();
	}
	*/
	
	public static void main(String[] args) {
		ArrayEx3 ae = new ArrayEx3();
		ae.disp( "A" );
		ae.disp( "A","B" );
		ae.disp( "A","B","C" );
		ae.disp( "노","는","게"," ","제","일","좋","아" );

	}
}
