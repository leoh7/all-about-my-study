import java.util.*;

public class VariableEx1_1{
	public static void main(String[] args) {
	/*
	�Է��� ������ �迭�� �߰��ϰų�(����ڿ�)
	�迭 ũ�⸦ ���������� �����Ͽ� ����� ���ÿ� �迭�� �߰��Ͽ�(������)
	������ �� �ִ� ����� �ְ� �ʹ�
	
	*/
	
	int kor = 81;	//���� ����
	int eng = 75;	//���� ����
	int mat = 91;	//���� ����

	int arrayInt = 0; //�迭�� ����

	int sum = 0;	//���� ����
	double avg = 0;	//��� ����
	


		
	int [] scoreArray = new int[arrayInt];

	for (int i=0; i < scoreArray.length ; i++){
		sum += scoreArray[i]; // sum = sum + scoreArray[i]; �� ����. sum�� scoreArray[i] �� ���ؼ� �����϶�� ��
		}

	avg = sum / (double)scoreArray.length;


	System.out.println("���� : " + kor);
	System.out.println("���� : " + mat);
	System.out.println("���� : " + eng);

	System.out.println("���� : " + sum);
	System.out.println("��� : " + avg);
	}
}
