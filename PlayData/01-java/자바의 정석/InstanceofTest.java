class Car{}
class FireEngine extends Car {}

class InstanceofTest{
	public static void main (String [] args){
		FireEngine fe = new FireEngine();

		if(fe instanceof FireEngine){
			System.out.println("This is a FireEngine instance.");
		}

		if(fe instanceof Car){
			System.out.println("This is a Car instance.");
		}

		if(fe instanceof Object){
			System.out.println("This is an Object instance.");
		}

		System.out.println("(Object 클래스를 상속했는지 보기위한)getName() 확인: "+fe.getClass().getName() );
		System.out.println("(Object 클래스를 상속했는지 보기위한)getClass() 확인: "+fe.getClass());
	}

}
