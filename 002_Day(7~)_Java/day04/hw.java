package day04;

import java.util.Scanner;

public class hw {
	public static void Hw1() {	// ������ ���������� �˻�
			Scanner stdIn = new Scanner(System.in);
			System.out.print("�˻��� ���ڸ� �Է����ּ��� : ");
			int num = stdIn.nextInt();
			System.out.print("���� �������? �Է� : ");
			int div = stdIn.nextInt();
					
			for(int i = 1; i < num; i++) {
				if(num % div == 0) {
					System.out.println("["+num+"]�� ["+div+"]�� ����Ӵ�.");
					break;
				}
				else {
					System.out.println("["+num+"]�� ["+div+"]�� ����� �ƴԴ�.");
					break;
				}
			}
		}


		public static void Hw2() {	//2or3��� �ƴ� 100������ �� ��
			int sum = 0;
			for(int i = 1; i <= 100; i++) {
				if((i%2!=0) && (i%3!=0)) {
					sum += i;
				}
					
			}
			System.out.println(sum);
		}


		public static void Hw3() {	//�ֻ��� �ΰ� ������ ���� 4�� �Ǵ� ��� ����� ��
			for(int i = 0; i <= 6; i++) {
				for(int j = 0; j <= 6; j++) {
					if(i+j == 4)
						System.out.println("i :"+i+" j :"+j);
				}
			}
		}

	public static void Hw4() {	//���� 4�⸶��, 100������δ� �ƴ�, 400�� �����δ� ������
			Scanner stdIn = new Scanner(System.in);
			System.out.print("�˻��� ���� �Է� [���� �⵵] :");
			int p = stdIn.nextInt();
			System.out.print("\n�˻��� ���� �Է� [�� �⵵] :");
			int n = stdIn.nextInt();
			int i = 0;
			for(i = p; i <= n; i++) {	//�����ٷ� ' 3'
				if(i%400==0)
					System.out.printf("%-4d�⵵�� ����\n", i);
				else if(i%100==0)
					System.out.printf("%-4d�⵵�� ����ƴ�\n", i);
				else if(i%4==0)
					System.out.printf("%-4d�⵵�� ����\n", i);
				else
					System.out.printf("%-4d�⵵�� ����ƴ�\n", i);
			}
			System.out.println("**************************");
			
			for(i=p; i<=n; i++) {	// ����ü �� ���ٷ�...
				if(((i%4==0)&&(i%100!=0))||(i%400==0)) 
					System.out.printf("%-4d�⵵�� ����\n", i);
				else
					System.out.printf("%-4d�⵵�� ����ƴ�\n", i);
			}
			/* ������ ��.��
			for(int i = p; i <= n; i++) {
				if(i%400==0)
					System.out.println(i+"�⵵�� ������ �̿���");
				else
					if(i%100==0) {
							System.out.println(i+"�⵵�� ������ �ƴϿ���");
							if(i%4==0)
								System.out.println(i+"�⵵�� �����̿���");
							else
								System.out.println(i+"�⵵�� ������ �ƴϿ���");
						System.out.println(i+"�⵵�� ������ �ƴϿ���");
			}
			*/
		}



	public static void main(String[] args) {
		//Hw1();
		//Hw2();
		//Hw3();
		Hw4();
	}
}

