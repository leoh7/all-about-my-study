/*Varialbe Argument
���� �ڷ����鸸 �ȴ�, �� �׷����� �迭�̱� ����
1���� ������ �ϳ��� ����� 2���� ������ �ΰ��� �����
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

	/*���࿡ ���� int���� �� ������ �ϸ�
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
		ae.disp( "��","��","��"," ","��","��","��","��" );

	}
}
