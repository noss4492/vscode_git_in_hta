package day03;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Deque;

public class BaseN {		// ���� �� �����ؼ� ǥ���� ������.
	public static void BaseN() {	// trans to n-binary number
			//generic
		//
	}
	
	public static void toBaseN(int decNum, int num) {	// should be Recursive
		// # ������. �� Ŭ������ ��ȯ���� ����� ���� �˰Ե� -> ���� ��������� ����� ������ ������ ����.
		
		ArrayList<Integer> n = new ArrayList<Integer>();
		//ArrayList<Integer> n = new ArrayList<Integer>();
		// int n[] = new int[];		�̰� ��� ��ø� ���ְ� ������ ũ��� ������?
		// # ������. �迭 -> ����Ʈ �ڷ���. ����Ʈ �ڷ������� ���� ũ���� �迭�� ���� �� ����.
		
		// �������� �������ƾ���. ������ ����� ���� ������ ���� ��� �Ǳ� ������ �̸� �̿��ϵ��� ��.
		// # ������. ����Ʈ �ڷ��� -> ���� �ڷ���
		
		
		// �ڹٿ����� ���� �ڷ������ٴ� �ϰ��� ������ ���� �� �ڷ����� ����ϴ� ���� �����ϰ� �ִٰ� ��.
		// # ������. ���� �ڷ��� -> �� �ڷ���
		
		// ArrayDeque<Integer> n =new ArrayDeque<Integer>();
		int i = 0;	// �ؿ� �� ��� ��� ������ �˰� �־�� �ϱ� ������ ���⼭ ������.
		
		if(decNum >= num) {
			n.add(decNum%num);							// ��� �迭 �޿��� �߰��ؾ���.
			System.out.println("n"+"i["+n.size()+"] ="+n.get(i));
			// i++;	i++�� ���������� �����ϰ� ������ ����.
			// #������  ������ ����Ʈ�� �ٲ㼭 �ʿ����.
			toBaseN(decNum/num, num);
		}
		else{
			n.add(decNum%num);
			System.out.println("n"+"i["+i+"] ="+n.get(i));
			for(int j = 0; j < n.size(); j++) {
				System.out.printf("%d", n.get(i));
				System.out.println("\n---|e|n|d|---");	
				System.out.println("[test]"+n.size());
			}
		}
		// decNum�� n���� ������ ������ ������ ������ ������ ������ �ϴ� �����̴ϱ� 
		//
		// 300 -> n�������� ���� ������ �����غ���. 
		// 300 / n -> ������
		// 300 / n*n -> ������
		// 300 / n*n*n -> ������		
	}
	
	public static void main(String[] args) {
		// ArrayList<String> arrN = new ArrayList<String>();	
		// arrN is contained baesN's strings
		
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("��ȯ�� ������ �Է����ּ��� : ");
		int baseNum = stdIn.nextInt();
		
		System.out.println();
		
		System.out.print("��ȯ�� ���� �Է����ּ���    : ");
		int decNum = stdIn.nextInt();
		stdIn.close();

		System.out.println("�Էµ� 10���� :"+decNum+"   ��ȯ�� ���� :"+baseNum);
		toBaseN(decNum, baseNum);
		
		
	}

}
