package wiring.bean;

public class Flower implements Poem {

	private String str = 
			"여울돌에 낀 이끼를 뜯어 먹더라도\r\n" + 
			"나는 한때 그 강으로 돌아가고 싶었는데\r\n" + 
			"등을 뚫는 아픔 없이 어찌 풍경이 될까\r\n" + 
			"절집 처마 끝에 올라 풍경소리 들려줄 수 있을까";
	
	@Override
	public void recite() throws PerformanceException {
		System.out.println("Picnic : " + str );
	}

}
