package day04;
import java.util.ArrayList;
import java.util.Scanner;

// �̰Ÿ� ���� �� �����ؼ� Ŭ������ ������.

public class VendingMachine {

	static int won = 0;
	static int cnt2 = 0;
	
	// ���ݸ� ��..
	//System.out.printf("1. n: %-8d, m:%-8d, cnt:%-3d w:%-5d\n",n, m, cnt2, cm.get(cnt));
	//System.out.printf("2. n: %-8d, m:%-8d, cnt:%-3d w:%-5d\n",n, m, cnt2, cm.get(cnt));
	//System.out.printf("3. n: %-8d, m:%-8d, cnt:%-3d w:%-5d\n",n, m, cnt2, cm.get(cnt));
	/*
	static void printTest(int n, int m, int cnt, int a[]) {
		System.out.printf("0. n: %-8d, m:%-8d, cnt:%-3d w:%-5d\n",n, m, cnt2, cm.get(cnt));
	}*/
	
	
	static ArrayList<Integer> cm = new ArrayList<Integer>();
	static ArrayList<Integer> changeMoney(int won, int n, int m, int cnt) {
		if(m<=0) {	// �ȿ� ���� Ȯ���غ����� �ּ� ����
			cm.add(won%n);
			//
			return cm;
		}
		if( cnt2 == 0) {		//�̰� �� �ι� ����ɱ�?.... -> 1������ ������Ű�°�.. 
			cm.add(won/50000);
						changeMoney(won, n, m, cnt2++);
		}
		else if( cnt2 % 2 == 1) {
			cm.add(won%n/m);
						changeMoney(won, n/5, m/2, cnt2++);
		}
		else{//if( cnt2 % 2 == 0) {
			cm.add(won%n/m);
						changeMoney(won, n/2, m/5, cnt2++);
		}
		return cm;
	}
	
	public static void main(String[] args) {
		System.out.println("--------- ���� ���Ǳ� ---------");
		System.out.printf("--   %2d. %4s : %5d��     --\n", 1, "�ݶ�", 2500);
		System.out.printf("--   %2d. %4s : %5d��     --\n", 2, "���̴�", 1800);
		System.out.printf("--   %2d. %4s : %5d��     --\n", 3, "ȯŸ", 2200);
		System.out.printf("--   %2d. %4s : %5d��     --\n", 4, "�׷�", 4000);
		System.out.printf("--   %2d. %4s : %5d��     --\n", 5, "����", 3500);
		System.out.println("---------------------------");
		
		System.out.print("���� �������� : ");
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		System.out.print("���� ���� ���ּ��� : ");
		int choice = sc.nextInt();
		
		System.out.print("���� ���� ���ּ���");
		int cnt = sc.nextInt();
		sc.close();
		
		System.out.println(cnt+"���� �����ϼ̽��ϴ�.");
		
		int price = 0;
		
		if(choice == 1) price = 2500;
		else if(choice == 2) price = 1800;
		else if(choice == 3) price = 2200;
		else if(choice == 4) price = 4000;
		else if(choice == 5) price = 3500;
		
		int expPrice = price*cnt;	//��ǰ���� �հ�

		System.out.println("��ǰ ����       : "+price);
		System.out.println("���� ��ǰ ���� : "+expPrice);

		if( money >= expPrice) {
			ArrayList<Integer> n = new ArrayList<Integer>();
			n = changeMoney(money-expPrice, 50000, 10000, 0);
			
			System.out.println(choice + "�� ��ǰ " + cnt+"��");
			System.out.println("�ܾ��� :" + (money-expPrice));
			
			int c1 = 1;
			e:
			for(int i = 10; i >= 1; i--) {	// �� �� �ְ� ǥ�����ֱ� 10 = n.size()-1
				if(i%2==0) {
					if(n.get(i-1)==0) {
						c1 *= 5;
						continue e;
					}
					System.out.print(c1+"�� �ż� : "+n.get(i-1)+"\n");	
					c1 = c1*5;
				}
				else {
					if(n.get(i-1)==0) {
						c1 *= 2;
						continue e;
					}
					System.out.print(c1+"�� �ż� : "+n.get(i-1)+"\n");	
					c1 = c1*2;				
				}
			}
			
		}
		else {
			System.out.println("�ܾ� ����");
			System.out.println("��ȯ��"+money);
		}

		
	}
}

/*		Ŭ������ ���� ���̺� �������� ���� �� �� ���� ����. (���߿� ����)
class menu{
	ArrayList<Integer> menu = new ArrayList<Integer>();
	int num;
	String name;
	int price;
	menu(int num, String name, int price){
		this.num = num;
		this.name = name;
		this.price = price;
	}
}*/

