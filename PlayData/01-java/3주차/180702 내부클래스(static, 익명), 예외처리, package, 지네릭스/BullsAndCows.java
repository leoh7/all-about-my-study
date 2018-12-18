/*
	변수 = 3자리 난수 생성
	
*/

import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;
class BullsAndCows {
	public static void main(String[] args) throws Exception {
	char []cValue;
	
	Random r = new Random();
	BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
	
	int inputValue = 0;
	int a[]=new int[3];

		for(int i=0; i<a.length; i++){
			a[i] = r.nextInt(8)+1;

			for(int j=0; j<i ;j++){		
				
				if(a[i]==a[j]){ 
					i--; 
					break; 
					}	
			}	//for j
			
		}	//for i
//	String a[] = (String)a[].toString();



	for(int i=0;i<a.length;i++){System.out.print(a[i]+" ");}	// 난수값 확인
	
	System.out.println();


//	cValue = toCharArray(br.readLine());
	

//	System.out.println(cValue[0]);
	}
}
