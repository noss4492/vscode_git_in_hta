package day05;

public class Test {

	public class Lotto{
		private int[] wn;

		// �ʵ� ����
		// �ʱ� ������
		// ���� �Է��� �ζ� �Է¹�ȣ�� ���ڰ����� �޴� ������
		public Lotto(int[] usersLotto) {	// 1. �迭 ���� ��ġ(�������� �˻�) or 2. ��͹�����(?)
											// 3. �ϴ� for������
			int[] pn = {0, 0, 0, 0, 0};		// [test] �ϴ��� 0���� �صӽô�.
			int[] wn = {0, 0, 0, 0, 0};		// ��÷ ��ȣ�� ����� �迭
			int cnt = 5;
			
			/*
			int[] lottoGenerator() {		// Lotto�� ��÷��ȣ ���� �޼���
				for(int i = 0; i < 5; i++) {		// �ּ��� �ٸ� Ŭ������ �����ָ� �ȵ��� �ʳ�
					this.wn[i] = randomGenerator();
					//dup:
					for(int j = 0; j < 5; j++) {	//���� �� �˻� ..
						if(this.wn[i] == wn[j]) 
							i=i-1;					//i=i-1; continue��; ���� ���;
					}
				}
			}
			
			
		}
		// �޼���
		
		public int randomGenerator() {
			return ((int)(Math.random()*45)+1);
		}
		
		public void printWin(int[] generatedWinNum) {
			for(int x : generatedWinNum)
				System.out.println(x);
			
		}
		
	}
	*/
	public static void main(String[] args) {
		
		int user;
		Lotto daebaq = new Lotto();
		
		
		
		
		
	}

}
