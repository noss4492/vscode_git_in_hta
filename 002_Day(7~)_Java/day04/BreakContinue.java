package day04;

public class BreakContinue {
	// break 		// ���� ����� �ݺ��� Ż��
	// ���� ����� ���� ����
	// continue 	// �̹��� ����
	// ���� ����� ����� ���������� ����
	
	// break ��		// ���� �پ��ִ� �ݺ������� Ż��
	// ����� ���� ����
	// continue ��	// ���� �پ��ִ� �ݺ������� �̹��� ����
	// ����� ���������� ����

	
	public static void main(String[] args) {
		
		//�� �ֱ�, goto���� ����� ��������...
		outer:
		for(int j=1; j<=4; j++) {
			for(int i=1; i<=4; i++) {
				if(i==j) continue outer;
				//if(i==j) break outer; �̷��� ���� �� �� ����
			System.out.println(" i : "+ i +" j : "+j);
			}
		}
	}
}
