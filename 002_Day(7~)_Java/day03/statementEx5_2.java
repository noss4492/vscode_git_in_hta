package day03;
//import java.util.Scanner;
import java.io.IOException;



public class statementEx5_2 {
//	
//	static void stdIn() {
//		//Scanner stdIn = new Scanner(System.in);
//		//String n = stdIn.nextLine; //���� ���� �� ����
//	}

	public static void main(String[] args)throws IOException{
		// ����ڷκ��� ���� �Է¹޾� ���� ���
		System.out.print("�ԏ� ���? :");
		/// ǥ���Է���ġ�� ���� ���� �Է¹޾� ��������
		int dan = System.in.read();
		
		dan -= 48;	//0x30 0x41 0x61
		System.out.println("����ڰ� �Է��� �� "+dan);
		
		for(int i = 1; i<=9; i++) {
			System.out.println(dan+"*"+i+"=\t"+dan*i);
		}
	}
}
