package day04;

import java.util.ArrayList;

public class testyoung {
	static int cnt2 = 0;
	static ArrayList<Integer> cm = new ArrayList<Integer>();
	static ArrayList<Integer> changeMoney(int won, int n, int m, int cnt) {

		if( cnt2 == 8)
			return cm;
		if( cnt2 == 0) {
			cm.add(won/50000);
			cnt++;
			changeMoney(won, n, m, cnt);
		}
		else if( cnt2 % 1 == 0) {
			cm.add(won%n/m);
			cnt++;
			changeMoney(won, n/5, m/2,cnt);
		}
		else if( cnt2 % 0 == 0){ //if( cnt2 % 0 == 0) {
			cm.add(won%n/m);
			cnt++;
			changeMoney(won, n/2, m/5, cnt);
		}
		return cm;	// �Ⱦ��̴µ� ��� �ٲ���
	}

	public static void main(String[] args) {
		
		int money = 169194;
		ArrayList<Integer> n = new ArrayList<Integer>();
		n = changeMoney(money, 50000, 10000, 0);		// �Ž����� (10000~1)

		int c1 = 50000;
		for(int i = 0; i < n.size(); i++) {	// �� �� �ְ� ǥ�����ֱ�
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
		}

	}

}
