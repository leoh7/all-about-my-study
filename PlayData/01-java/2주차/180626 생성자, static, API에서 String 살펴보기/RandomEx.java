//api�� ���鼭 random ¥����
import java.util.Random;
class RandomEx {

	public static void main(String[] args) {
//	Math m = new Math();	//api ���� ��ü������ �ȵǰ� ��ӵ� �ȵǴ°� �� �� �ִ�.
		Random r = new Random();
		for( int i =0; i<6; i++){
		//System.out.println( (int)(Math.random()*100) +1 );	//Math.random() -> Ŭ����.�޼���()
		System.out.println(r.nextInt(45)+1);
		}

	}
}
