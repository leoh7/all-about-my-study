//api를 보면서 random 짜보기
import java.util.Random;
class RandomEx {

	public static void main(String[] args) {
//	Math m = new Math();	//api 뜯어보면 개체생성도 안되고 상속도 안되는걸 볼 수 있다.
		Random r = new Random();
		for( int i =0; i<6; i++){
		//System.out.println( (int)(Math.random()*100) +1 );	//Math.random() -> 클래스.메서드()
		System.out.println(r.nextInt(45)+1);
		}

	}
}
