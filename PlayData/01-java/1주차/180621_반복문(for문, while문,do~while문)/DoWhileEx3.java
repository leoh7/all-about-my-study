
// 1부터 10까지 출력하고 = 총합 구하기
// 1+2+3+4+5+6+7+8+9+10 = 55
class DoWhileEx3 {
	public static void main(String[] args) {
	
	int i = 0;
	int sum = 0;
		
		do{
		i++;	//do while의 장점 중 하나는 증감연산자를 맨 위로 올릴 수 있다는 것이다
		System.out.print(i);	//위치 생각하는게 복잡해진다
		sum += i;

		if(i < 10){System.out.print(" + ");
			}
	}while(i < 10);
	
	System.out.print(" = " + sum);
	}
}

/*	선생님 코드
int i = 0, sum = 0;
do {
	i++;		//증감연산자의 위치를 주목해보자
	sum += i;
	if(i<10) System.out.print(i + " + ");
	else System.out.print( i + " = " );
} while(i<10);
System.out.println( sum );
*/