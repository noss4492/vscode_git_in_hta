package day05;

import java.util.ArrayList;
//import java.io.*;

public class ArrayEx2 {
	public static void main(String[] args) {
		int[] c;
		c = new int[5];
		// System.out.println("���� : "+c.length);
		
		for(int idx = 0; idx < c.length; idx++) {	//1
			c[idx] = 10*idx;
			System.out.print("1. "+c[idx]+"\t");
		}
		//System.out.println();
		
		for(int tmp : c)							//2
			System.out.print("2. "+tmp+"\t");
		
		System.out.println();
		
		int[] d = {29, 16, 68};						//3
		
		int[] aa = {10, 50, 30, 40, 60};
		int[] bb = {20, 10, 90, 120, 160};
		int[] cc = new int[aa.length];
		
		for(int idx=0; idx<aa.length; idx++)		//
			cc[idx] = aa[idx]+bb[idx];
		for(int idx = 0; idx < cc.length; idx++)
			System.out.println("1. �Ϲ� cc[i] : "+cc[idx]);
		
		for(int tmp : cc)
			System.out.println("2. Ȯ�� for cc[i] : "+ tmp);
		
		int ix=0;
		for(int tmp : aa)		// ���� ������ shit..
			cc[ix]=tmp+bb[ix++];
		for(int tmp : cc)
			System.out.println("3. ���� test Ȯ��for cc[i] : "+ tmp);
		
		char[] charBuf = {'j','v','a','w','o','r','l','d'};
		String[] charBuf2 = {"java world"};
		String[][] charBuf22 = {{"JAVA"},{"WORLD"}};
		// �� String�� Ŭ����������. ���������� char�迭�� �Ǿ� �ְڱ����� �� �� ����.
		
		for(int i = charBuf.length-1 ; i >= 0; i--) {
			System.out.print(charBuf[i]);
		}
		System.out.println();
		
		// java������ ���ڿ��� immutable.
		// ���� �� ������δ� �Ұ����ϰ� ���ο� �迭�� ����ų� �Ͽ� �����Ͽ��� ��.
		
		/* substr �� �ȵ�¡?
		 * ArrayList<String> charBuf3 = new ArrayList<String>();
		for(int i=0; i<charBuf2.length; i++) {
			charBuf3.add(charBuf2.subString(i));
		}
		*/
		//char * char_buf = {"javaworld"};
		//char ** char_buf = {"java", "world"};
		
//		System.out.println("mm[i]  (������ �ִ� ������)   --- "+mm[i]);
//		System.out.println("mm[i][0] (���� �������� �Ҵ�� ��) "+mm[i][0]);
		
		//new int[4][3][2];
		
		

		
	}
}
