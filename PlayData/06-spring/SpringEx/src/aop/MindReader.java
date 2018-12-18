package aop;

public class MindReader implements Magician {

	@Override
	public void intercept(String thought) throws PerformanceException {
		// TODO Magician - MindReader
		System.out.println("("+"독심술사가 읽어낸 것! : " + thought + ")");
	}
	@Override
	public void answer(String thought) throws PerformanceException {
		System.out.println("독심술사의 대답! : " + thought);
	}

}
