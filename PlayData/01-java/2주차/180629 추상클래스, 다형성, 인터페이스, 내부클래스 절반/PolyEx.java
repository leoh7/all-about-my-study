//추상 클래스를 이용한 다형성
/*
들어가는 데는 한 곳인데
나오는 데가 여러 개다.

*/
abstract class Design{
	int a=5, b=7, c=3;					// 밑변, 높이 or 반지름	c<- 윗변
	double area;					// 넓이
	public abstract void calc();	// 계산
	public abstract void disp();	// 출력
}


class Rect extends Design{		//	사각형 밑변*높이
//	public void calc(){}	// 여기까지만 써놔도(구현해놔도) 에러는 안난다.
	public void calc(){ area = a*b;	}
	public void disp(){ System.out.println("Rect의 넓이는 : "+ (int)area); }
}
class Tri extends Design{		//	( 삼각형 밑변*높이 )/ 2
	public void calc(){ area = (a*b)/2.0; }			// 뒤에 2.0 으로 쓰는것 주의
	public void disp(){ System.out.println("Tri의 넓이는 : "+ area); }
}
class Circle extends Design{	//	 반지름*반지름 PI
	
	public void calc(){ area = (a*a)*Math.PI; }
	public void disp(){ System.out.println("Circle의 넓이는 : "+ area); }
}
class Ladder extends Design{	// 사다리꼴의 넓이 윗변+아랫변 *높이 /2
	public void calc(){ area = (c+a)*b/2.0; }
	public void disp(){ System.out.println("Ladder의 넓이는 : "+ area); }
}

class  PolyEx {
	public static void main(String[] args) {
		// ladder	사다리꼴의 넓이

		Design de[] = { new Rect(), new Tri(), new Circle(), new Ladder() };
		for(Design d : de){		// d 인덱스 , de 배열이름, Design d / Design d 자료형
			d.calc();			// 오버라이드 되있는 상태에서는 자식이 실행된다.
			d.disp();
		}
		
		
		/*
		Rect r = new Rect();
		Tri t = new Tri();
		Circle c = new Circle();

		r.calc();
		r.disp();

		t.calc();
		t.disp();

		c.calc();
		c.disp();
		*/
	}
}
