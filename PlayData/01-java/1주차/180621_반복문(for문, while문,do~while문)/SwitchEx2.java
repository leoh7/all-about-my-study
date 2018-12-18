//1번
//90점이상 " A학점"		90 ~ 99
//80점이상 " B학점"		80 ~ 89
//70점이상 " C학점"		70 ~ 79
//60점이상 " D학점"		60 ~ 69
//60점미만 " F학점"		0 ~ 59

//2번
//0~100 사이일 때만 학점 출력
//범위 밖이면 "잘못입력" 출력

class SwitchEx2{
	public static void main(String[] args) {
		int a = Integer.parseInt( args[0]);
/*
		int A =	a;				//(a>=90 && a<100);	//일단 이건 결과값이 논리값 튀어나오니깐
		int B = (a>=80 && a<90);
		int C = (a>=70 && a<80);
		int D = (a>=60 && a<70);
		int F = (a>=0 && a<60);

		switch (A = a>=90 && a<100){//, B = (a>=80 && a<90), C = (a>=70 && a<80), D = (a>=60 && a<70), F = (a>=0 && a<60)) {
		
		case A : System.out.println("학점 : " + A);break;
		case B : System.out.println("학점 : " + B);break;
		case C : System.out.println("학점 : " + C);break;
		case D : System.out.println("학점 : " + D);break;
		case F : System.out.println("학점 : " + F);break;
		default : System.out.println("학점 : " + "올바른 값을 입력하세요");		
*/		
		System.out.println("1번 문제");

		
		switch ( a / 10 ){									//10 으로 나눠서 정수로 받으면? 99= 9.9=9 // 87=8.7=8
		case 10 :											//100점일 때는 9랑 같이 하게끔 흘러내리게 냅둠
		case 9 : System.out.println("학점 : + A");break;
		case 8 : System.out.println("학점 : + B");break;
		case 7 : System.out.println("학점 : + C");break;
		case 6 : System.out.println("학점 : + D");break;
		default : System.out.println("학점 : + F");		
		}

System.out.println("\n");

				System.out.println("2번 문제");

		if(a >= 0 && a <= 100 ){
			switch ( a / 10 ){
			case 10 :											//100점일 때는 9랑 같이 하게끔 흘러내리게 냅둠
			case 9 : System.out.println("학점 : + A");break;
			case 8 : System.out.println("학점 : + B");break;
			case 7 : System.out.println("학점 : + C");break;
			case 6 : System.out.println("학점 : + D");break;
			default : System.out.println("학점 : + F");		
			}
		}else {System.out.println("잘못입력");}

	}
}
