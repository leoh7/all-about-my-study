package wiring.anno;

public class Bounce implements Song {
	private String str = "심장이 빠운ㅅ";
	
	@Override
	public void singing() throws PerformanceException {
		System.out.println("...'"+"..Hello"+"'...!!\n" + str);
	}

}
