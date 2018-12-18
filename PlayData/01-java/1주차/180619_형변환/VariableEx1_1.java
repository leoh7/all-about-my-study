import java.util.*;

public class VariableEx1_1{
	public static void main(String[] args) {
	/*
	입력을 받으면 배열을 추가하거나(사용자용)
	배열 크기를 가변적으로 설정하여 선언과 동시에 배열을 추가하여(관리용)
	연산할 수 있는 기능을 넣고 싶다
	
	*/
	
	int kor = 81;	//국어 점수
	int eng = 75;	//영어 점수
	int mat = 91;	//수학 점수

	int arrayInt = 0; //배열의 갯수

	int sum = 0;	//총합 점수
	double avg = 0;	//평균 점수
	


		
	int [] scoreArray = new int[arrayInt];

	for (int i=0; i < scoreArray.length ; i++){
		sum += scoreArray[i]; // sum = sum + scoreArray[i]; 와 같다. sum에 scoreArray[i] 를 더해서 대입하라는 말
		}

	avg = sum / (double)scoreArray.length;


	System.out.println("국어 : " + kor);
	System.out.println("수어 : " + mat);
	System.out.println("영어 : " + eng);

	System.out.println("총점 : " + sum);
	System.out.println("평균 : " + avg);
	}
}
