class TvTest4 {
	public static void main(String[] args) {
		Tv[] tvArr = new Tv[3];	// 길이가 3인 Tv객체 배열 생성

		// Tv객체를 생성해서 Tv객체 배열의 각 요소에 저장
		for( int i=0 ; i < tvArr.length ; i++ ){
			tvArr[i] = new Tv();
			tvArr[i].channel = i+10;	// tvArr[i]의 channel에 i+10을 저장	
		}
		//tvArr[1].channel = 10
		//tvArr[2].channel = 11
		//tvArr[3].channel = 12	가 저장되었다.

		for(int i=0; i < tvArr.length ; i++){
			tvArr[i].channelUp();	// tvArr[i]의 메서드를 호출. 채널이 1증가
			System.out.printf("tvArr[%d].channel=%d%n",i,
														tvArr[i].channel);

			//tvArr[1].channel = 11
			//tvArr[1].channel = 12
			//tvArr[1].channel = 13	으로 1씩 증가하였다.

		}
	}	//main의 끝
}

class Tv {
	String color;		//색상
	boolean power;		//전원상태(on/off)
	int channel;		// 채널

	void power()	{ power = !power; }
	void channelUp()	{	++channel;	}
	void channelDown()	{	--channel;	}
}