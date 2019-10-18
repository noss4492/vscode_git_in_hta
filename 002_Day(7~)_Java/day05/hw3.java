package day05;

import java.util.Scanner;

public class hw3 {
	public static void main(String[] args) {
		int[][] a = {{3,2,3},{4,5,6},{1,4,9}};		//hw3
		int[][] b = {{1,8,7},{6,4,4},{3,2,3}};
		int[][] c = new int[a.length][a[0].length];
		
		for(int i = 0; i <a.length; i++)	//a.length*a[0].length elements
			for(int j = 0; j < a[0].length; j++)
				c[i][j] = a[i][j] + b[i][j];
		
		int n = 1;							//hw4
		int[][] d = new int[5][5];
		for(int i = 0; i < d.length; i++) {
			for(int j = 0; j < d[0].length; j++) {
				d[i][j]=n++;
				System.out.printf(" %2d ",d[i][j]);
			}
			System.out.println();
		}
		
		
		//hw5
		Scanner sc = new Scanner(System.in);	// 45, 40, 100.... input
		
		/*
		int[] f = new int[10];
		int sum = 0;
		System.out.println("�����0~100 ���� 10�� �Է� �����");
		for(int i = 0; i < 10; i++) {
			f[i] = sc.nextInt();
			sum += f[i];
		}
		System.out.println("�հ� : "+sum);
		System.out.println("��� : "+sum/f.length);
		
		n = 1;
		//hw6
		int[] e = new int[100];
		for(int i = 0; i < 100; i++)
			e[i] = n++;
		
		//hw7	Hw06���� 3�� ����� 3333 5�� ����� 5555 3�� 5�� ������� 3535�� ����
		int x = 0;
		for(int i = 0; i < 100; i++) {
			if(e[i]%3==0&&e[i]%5==0)
				e[i]=3535;
			else if(e[i]%3==0)
				e[i]=3333;
			else if(e[i]%5==0)
				e[i]=5555;
		}
		
		int[] g = new int [10];
		//hw8
		for(int i = 0; i < 10; i++) {
			g[i] = sc.nextInt();
			if(g[i]%3==0)
				System.out.println("g["+i+"]"+"3�� ��� : "+g[i]);
		}
		//hw9
		int[] h = {10, 50, 60, 30, 12};
		int idx = 0;
		while(idx<5) {
			if(h[idx] == 50)
				System.out.println(h[idx++]);
		}
		
		//hw10
		int[] bb = new int [10];
		for(int i = 0; i < 10; i++) {
			if(i==7)
				continue;
			bb[i] = twoCip();			
		}
		/*
		//hw11
		// 20 15 30 100 99 21 11
		int[] cc = {20, 15, 30, 100, 99, 21, 11};
		System.out.println("���� ���ϴ� �迭 �ε��� �Է� �Ͻÿ�");
		int hoIdx = sc.nextInt();
		cc[hoIdx] = (int)(Math.random()*1000)+1;
		
		for(int i = 0; i < 7; i++)
			System.out.println(cc[i]);
		*/
		
		
		
		
		//hw12
		//10ĭ¥�� ������ �迭 rnd�� ������ �Ҵ�. �ִ밪 �ּҰ� ���
		
		int[] dd = new int[10];
		int max = 0;
		int min = 0;
		
		System.out.println("�������� 10�� ����(1~100)");
		for(int i = 0; i < 10; i++) {
			dd[i] = (int)(Math.random()*100)+1;
			System.out.println(dd[i]);
		}
		
		int tmp3 = dd[0];
		
		for(int i = 0; i < 10; i ++) {	// ��.�� �ѳ� ��ȿ������ ��.
			for(int j =0; j < i; j++)
			if(dd[i]>dd[j]) {	//dd[i] swap dd[j]
				tmp3 = dd[i];
				dd[i] = dd[j];
				dd[j] = tmp3;
			}
		}
		System.out.println("----------------");
		for(int i = 0; i < 10; i++) {
			System.out.println(dd[i]);
		}
		max = dd[0];
		min = dd[9];
		System.out.println("max :"+max);
		System.out.println("min :"+min);
		
		//hw13
		int[] ee = new int['Z'-'A'+1];
		
		ee[0]=(int)'A';
		System.out.println(ee[0]);
		
		for(int i = 0; i < 'Z'-'A'+1; i++) {
			ee[i]=ee[0]+i;
		}
		
		for(int tmp : ee)
			System.out.print((char)tmp+"");
		System.out.println();
		System.out.println("---------------");
		
		//hw14
		//'A' is lower than 'Z'
		//bubble bubble, �ĵ�Ÿ�� ����
		
		int tmp4 = ee[0];
		for(int i = 25; i>=0; i--) {
			for(int j = 0; j < i; j++) {
				if(ee[i]>ee[j]) {
					tmp4 = ee[i];
					ee[i]=ee[j];
					ee[j]=tmp4;
				}
					
			}
		}
		
		for(int tmp : ee)
			System.out.print((char)tmp+"");
		
		
			// �� ���� ����
			// ��������� �� ���ΰ�? -> ū ���� �տ� ���� �ؾ� ���� ������������ 
			//  24 ���� Ž��(25 �ڽ��� �� ���� �Ǵϱ�)
			//			  - - - - > �ּ� �� �ֿ���
			//     0 25
			//     1 25
			//     2 25
			//     .....
			//  23 ����  Ž��- - - - > �ּҿ��� �ι�° �� �ֿ������� �ι�°��
			//     0 24
			//     1 24
			// .........  ���� �˻��ϴ°� �ᱹ �Ȱ���.. hmm..
			
		
		
		
		
		
		
		
	}
	
	static int twoCip() {
		int aa = 0;
		while(true) {
			aa = (int)(Math.random()*100)%100;
			if(aa<100 && aa>9)
				break;
		}
		return aa;
	}
}
