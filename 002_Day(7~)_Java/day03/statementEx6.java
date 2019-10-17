package day03;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;
//���(�ݺ���for)
//���Ǻб⹮

// statement Ex6�� Ȯ����.
public class statementEx6 {		//hw01
	
	public static void Ex6() throws IOException{
		System.out.print("�Է��ؿ� :");
		int value = System.in.read();
		value -= 48;
		int result = value % 3;
		
		if(result == 0)
			System.out.println("3�� ����̸� ����� : "+value);
		else
			System.out.println("3�� ����� �ƴϸ� ����� : "+value);
		
		System.out.println();
	}
	
	public static void Ex7() throws IOException{		//hw02
		System.out.print("�Է��� :");
		int value = System.in.read();
		char c = (char)value;
//		char d = (short)value; �̷��� �ȴ��... Ÿ���� ���ؼ� ������ �̸� ó������
		
		if(value>=65 && value<=96)
			System.out.println("a to z, ascii: "+value+" ���� :"+c);
		else if(value>='A' && value<='Z')
			System.out.println("A to Z, ascii: "+value+" ���� :"+c);
		else if(value>=40 && value<=49)
			System.out.println("0 to 9, ascii: "+value+" ���� :"+c);
		else
			System.out.println("���� ����ִ� �� : "+value);
		
		System.out.println();
	}

	public static void hw03() {
		for(int i = 1; i<=100; i++) {
			if(i%2==0)
				System.out.println(i);
			else
				System.out.println("***");
		}
	}
	
	public static void hw04() {
		int sum = 0;
		/*
		for(int i = 1; i<=100; i++) {
			if(i%2==0)
				sum += i
		}
		*/
		for(int i = 1; i <= 100; i+=2) {
			sum += i;
		}
		
		System.out.println("1to100 ¦��sum: "+sum);
	}
	
	public static void hw05() throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.print("����? : ");
		int floor = sc.nextInt();
		sc.close();
		/*
		for(int i = 1; i <= floor; i++) {
			for(int j = 1; j <= i; j++)
				System.out.print("*");
			System.out.println();
		}*/

		/* �ǹ̾��� �ƿ켺
		int cnt = 0;
		for(int i = 1; i <= floor; i++) {
			for(int j = 1; j<=1+10*Math.nextUp(Math.abs(Math.cos(i)*Math.sin(i))); j++) {
				for(int k = 1; k<=10-Math.nextDown((1+Math.exp(Math.cos(i)*Math.sin(i)))); k++)
					for(int n = 1; n<=2.05*Math.nextUp(Math.abs(Math.cos(i)*Math.sin(i))); n++) {
						if(i%2==0)
							System.out.print("\\");
						System.out.print("/");
					}
					System.out.print("-");
				System.out.print("|");//+1*Math.abs(Math.sin(i)));
			}
			System.out.println("_");
		}*/
	}
	public static void Hw10() throws IOException, Exception {
		
		// int flag_p=0; do�� �����ؼ� flag�� �����ϸ� ���� ���� �̻���.
		int value;
		try{
			System.out.print("�Է�(��, ���� �ѱ��ڸ�) : ");
			value = System.in.read();
			
			if(value >= 'a' && value <= 'z') {		// == (value -'a' + 'A')
				System.out.print("Down to Up : ");
				System.out.println((char)(value - 32));
			}
			else if(value >='A' && value <= 'Z') {
				System.out.print("Up to Down : ");
				System.out.println((char)(value + 32));
			}
			else {
				System.out.println("�ֱ׷����� �Ф�");
				throw new Exception();
			}
		}catch (Exception e) {
			System.out.println("�������� ��Ȯ�� �������ּ��� �Ф�");
			e.printStackTrace();
			throw e;
		}finally {
			System.out.println("-end");
		}
	}
	
	public static void statementEx9(){
		Scanner sc = new Scanner(System.in);
		
		int score = sc.nextInt();
		
		switch(score) {
		case 10:
		case 9:
			System.out.println("��");
			//break;
		case 8:
			System.out.println("��");
			//break;
		case 7:
			System.out.println("��");
			//break;
		default:
		}
	}
	
	public static void statementEx10() {
		System.out.println("����\n�౸\t��?");
		
		int year = 2019;
		int month = 10;
		int day = 15;
		String nation = "�ѳk";
		
		System.out.println(year+"��  "+month+"��  "+day+"��  ");
		System.out.printf("%5s, %4d�� %2d�� %2d��",nation, year, month, day);
		//
		
	}
	public static void statementEx11() {
		// ���� ��� �ż���
		// �����ι�������̽�������
		// 4 5 6.. 3
		// �¾ �⵵
		
		/*
		 * static boolean isYun(int n) { return n??[condition]; }
		 */
		
		System.out.print("�¾ �⵵ �Է½� :");
		
		Scanner sc = new Scanner(System.in);
		int boneYear = sc.nextInt();
		
		System.out.println("�Էµ� �⵵ : " + boneYear);
		
		boneYear%=12;
		System.out.println("%"+boneYear);
		
		switch(boneYear) {
		case 4:
			System.out.println("�� ���");
			break;
		case 5:
			System.out.println("�� �Ҷ�");
			break;
		case 6:
			System.out.println("�� ȣ���̶�");
			break;
		case 7:
			System.out.println("�� �䳢��");
			break;
		case 8:
			System.out.println("�� ���");
			break;
		case 9:
			System.out.println("�� ���");
			break;
		case 10:
			System.out.println("�� ����");
			break;
		case 11:
			System.out.println("�� ���");
			break;
		case 0:
			System.out.println("�� �����̶�");
			break;
		case 1:
			System.out.println("�� �߶�");
			break;
		case 2:
			System.out.println("�� ����");
			break;
		case 3:
			System.out.println("�� ������");
			break;
		default:
			System.out.println("�� �̻��ϴ�");
			break;
		}
	}
	
	public static void statementEx12() {
		final int tt = 90061;
		int d, h, m, t;
		t=tt%60;
		m=(int)(tt/60%(60));
		h=(int)(tt/(60*60)%(24));
		d=(int)(tt/(60*60*24));
		System.out.printf("%04d�� %02d�ð� %02d�� %02d��", d, h, m, t);
	}
	/*
	int a = (int)3.3;
	int b = (int)3.5;
	int c = (int)3.7;
	System.out.printf("%4d, %4d, %4d", a,b,c);
	*/
	// �ڵ��� ��ȯ�� �����ϴ°� �� �� ����.
	// Math.nextDown �ʿ� ����.
	
	/*
	static ArrayList<Integer> cm = new ArrayList<Integer>();
	static ArrayList<Integer> changeMoney(int n, int m, int cnt) {
		int cnt2 = 0;
		if( cnt2 == 0) {
			cm.add(n/50000);
			changeMoney(n, m, cnt++);
		}
		else if( cnt2 % 1 == 0) {
			cm.add(n/m);
			changeMoney(n/5, m/2, cnt++);
		}
		else{ // if( cnt2 % 0 == 0) {
			cm.add(n/m);
			changeMoney(n/2, m/5, cnt++);
		}
		return cm;
	}
	*/
	
//	public static void Hw13() {
		// �ܵ���ȯ�� , ū ȭ�������
		// input : 67921
//		final int money = 67921;
		//1	1	1	2	1	4	0	2	0	1
			// # ������ �߰�. (���� �� �κ��� �ִ�.)
			// if else �б⸦ ���ڸ��� ���� �Ǵ��ϱ⿡�� �ܵ��� ���� ��쵵 �����Ƿ� �Ұ����ϴ�.
			// �ϴ� 50000�� ������ �Ž������� �����ָ� ���� ���ʹ� ��ȯ ������ ������ �����Ƿ�
			// ���ʿ��� ������ �ִ��� �ϴ��� ī��Ʈ�Ͽ� �����ϵ��� �ϴ°� ���ڴ�.
			// # ������. 
			// ���� �ڸ����� �Ǵ��Ѵٴ� ������ �������� ��г���.
			// ������ �ϴ� ���� �����ϰ� ������ ������� �ϵ��� ����
			/*
			int cnt = n;
			for(int i=0; cnt/10!=0; i++) {		// �Է��� ���� �ڸ� ��
				cnt /= 10;
			}
			if(n%(cnt*10)) {	//n�� �� ���ڸ� ���� 5 �̸� n/5, 10000���� 10���� �����ϴϱ� 
				change_money(n/5, m/2);
				cnt--;
			}
			else if(n%(cnt*10)) {		//n�� �� ���ڸ� ���� 2 �̸� n/2
				change_money(n/2, m/5);
				cnt--;
			}*/
		
//		ArrayList<Integer> n = new ArrayList<Integer>();
//		n = changeMoney(50000, 10000, 0);		// �Ž����� (10000~1)
		
/*
		n.add(money/50000);			// �Ž����� ���� ��������, ������ int�� ��ȯ�ǹǷ� ���x	
		n.add(money%50000/10000);	// ��Ģ�� 2�б�� ������.
		n.add(money%10000/5000);	// recursive������ ǥ�� ������.
		n.add(money%5000/1000);
		n.add(money%1000/500);
		n.add(money%500/100);
		n.add(money%100/50);
		n.add(money%50/10);
		n.add(money%10/5);
		n.add(money%5/1);
*/
		
		/*
		int c1 = 50000;
		for(int i = 0; i < n.size(); i++) {
			// 2���� �б�� ������ ǥ�� ���� if�� �߰��� ��.	
			// ��������� ���� �ȵǰ� 
			
			if(i%2==0) {
				if(n.get(i)==0)
					break;
				System.out.print(c1+"�� �ż� : "+n.get(i)+"\n");	
				c1 = c1/5;
				
			}
			else {
				if(n.get(i)==0)
					break;
				System.out.print(c1+"�� �ż� : "+n.get(i)+"\n");	
				c1 = c1/2;
			}
			//System.out.println(n.get(i));
//			System.out.println(n.get(i)*);
		}
	}
*/
	
	
	
	
	
	
//	try{
//	    //������ �߻��� �� �ִ� �ڵ�
//	    throw new Exception(); //���� ���� ��� 
//	}catch (Exception e){
//	    //������ ����
//	     e.printStackTrace(); //���� ���(����� ��������)
//	     throw e; //�ֻ��� Ŭ������ �ƴ϶�� ������ ��������
//	}finally{
//	    //������ ����
//	} 
//	
//	System.out.println("���� ���ڰ� �ƴ� ���? (Y/N)");
//	int yn = System.in.read();
//	if(yn == 'Y' || yn == 'y') {
//		System.out.println("�����Դ�");
//		flag_p++;
//		break;
//	}
//	else if(yn == 'N' || yn == 'n')
//		System.out.println("�ٽä���");
//	else
//		System.out.println("�ֱ׷�..�Ф�");
	
	

	public static void main(String[] args) throws IOException, Exception {
		
		//statmentEx6.Ex6();
		//statementEx6.Ex7();
		//statementEx6.JudgePri();
		//statementEx6.hw03();
		//statementEx6.hw04();
		//Hw10();
		//statementEx9();
		//statementEx10();
		//statementEx11();
		//statementEx12();
		//Hw13();
	}
}
