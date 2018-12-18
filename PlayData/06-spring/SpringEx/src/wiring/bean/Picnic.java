package wiring.bean;

public class Picnic implements Poem {
	
	private String str = 
			"족두리를 닮은 지느러미가 흔들릴 때마다\r\n" + 
			"먼 훗날 만날 각시를 생각하며 흐뭇해하던 아이가 있었다 \r\n" + // \r은 처음으로 돌아가라 \n은 다음줄
			"각시야 각시야 쌀 장만하러 돌아다니다\r\n" + 			// 도스에선 필요하다
			"늙어버린 구두를 용서하렴\r\n" + 
			"결혼기념일도 잊고 생일도 잊고\r\n" + 
			"너를 풀어놓을 우물마저 잊어버렸구나\r\n" + 
			"우물에 대고 부르던 노래도 더는 들려줄 수 없구나";
	
	@Override
	public void recite() throws PerformanceException {
		System.out.println("Picnic : " + str );
	}

}
