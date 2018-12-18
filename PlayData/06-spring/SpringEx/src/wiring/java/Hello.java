package wiring.java;

public class Hello implements Song {
	private String str = "헬로우, 캔유 히ㅇㄹ 미";
	
	@Override
	public void singing() throws PerformanceException {
		System.out.println("...'"+"Hello"+"'...!\n" + str);
	}

}
