/*

//0~9까지 랜덤수를 하나 발생시킨다.
한자리 값을 입력받아서	-> DoWhileEx2 참조
맞았으면 "몇 번만에 맞췄는지를 알려" 준 후 break 로 유유히 빠져나온다.
틀렸을 경우 "작다"/"크다"를 알려준다.

System.in.read();
while문으로 짤 것 : 몇 번만에 맞출지 모르잖아?
몇번 입력했는지 갯수 세야하고

*/

class WhileStudyPlus {
	public static void main(String[] args) throws Exception {
	
		int rand = (int)(Math.random()*10);
		int putValue = 0;
		int countPut = 0;


			
			//System.out.println("난수값은 :" + rand +"\n");
		
		
		while(true){		//(countPut >= 0) 초기 조건값
			System.out.print("맞춰봐여'ㅁ'7 (0~9) : ");

			putValue = System.in.read() -48;	//입력값을 받는다
			System.in.read();
			System.in.read();

				
					if(rand != putValue){			//필요한가?
					if(rand > putValue){			//생각한 값이 > 입력값보다 큰가요?
					System.out.println("입력값이 난수보다 작습니다!");				//크면
					}else{System.out.println("입력값이 난수보다 큽니다!");}		//작으면
					}	//오답 시 if문

			countPut++;
				
					if(rand == putValue){			//맞췄을 때 메세지를 출력하고 break로 빠져나온다
					System.out.println(countPut + "번 만에 맞추셨습니다!");
						
						
						/* 해보고 싶은 것 1 =>else if로 감탄하기
						1~10번 까지 입력 기회가 있다
						그 이상은 같은 숫자를 또 누른 것
						(0) 1 2 3 4|5| 6 |7| |8| 9
						1번 로또를 사셔야겠는데? ->한번 더 해보쇼?
						2번 운이 좋네
						3~4번이 평범
						if(countPut)
						*/

						/* 해보고 싶은 것 2 => 컴퓨터가 난수를 생성해서 숫자 맞추기(크고 작을 때 그 부분을 고려하게끔!)
						//break 브레이크 이름
						//end of 브레이크 이름
																//난수는 이미 존재한다 int rand = (int)(Math.random()*10);
						
						
						while(맞을 때까지 무한루프) 
							int randPut = (int)(Math.random()*10);	//집어 넣는 난수 발생								

								if(randPut == rand){
									System.out.println("난수 시도 횟수 만에 맞춤")break;
								}else if(randPut < rand){
									System.out.println("randPut이 rand보다 작다");
								}else if(randPut > rand){
									System.out.println("randPut이 rand보다 크다");
								}

									
										
										
										
										randPut부터 9까지 중에는 있는지 확인
											while(2번째 트라이)
											틀리다//

								//입력값이 크다
									넣었던 난수 필요: i

							end of 브레이크이름
						*/
						
						/* 해보고 싶은 것 3 => "해보고 싶은 것 2"를 간단하게 확률로 표현해보기
						*/

					break;
				}	//정답 시 if문
		}	//while

		
	
	}
}


