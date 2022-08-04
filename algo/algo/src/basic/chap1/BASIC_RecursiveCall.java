package basic.chap1;

public class BASIC_RecursiveCall {
	
	public static void main(String[] args) {
//		m1();
//		m2();
//		m2_correct();
//		m2_correct2();
//		m3(5);
		m4(0);
	}
	
	static int m1_cnt = 10;;
	static void m1() {
//		{
//			System.out.println("m1()");
//			m1();
//		}
//		{
//			//local ������ �׻� ���Ӱ� ���������
//			int i = 10;
//			System.out.println("m1 : i " + i++); //++�ǹ̾���
//			m1();
//		}
		{
			//static ������ 
			System.out.println("m1 : m1_cnt " + m1_cnt++); //++�ǹ̾���
			m1();
			
		}
	}
	
//	static int m2_cnt = 5;
//	static void m2() {
//		System.out.println("1��ȣ�� m2_cnt : " + m2_cnt);
//		
//		if (m2_cnt > 0) {
//			m2_cnt--;
//			m2();
//		}
//		System.out.println("2��ȣ�� m2_cnt : " + m2_cnt);
//		
//	}
	
	// ���� log�� �ѹ� �� ����ȴ�
	// 5-4-3-2-1 - 1-2-3-4-5 ����ϰ������ �޺κ��� 0-0-0-0-0 ��µȴ�.
//	static int m2_correct_cnt = 5;
//	static void m2_correct() {
//		//������ ���� �տ� �ִ� �ڵ�� �ѹ��� ����ȴ�
//		System.out.println("1��ȣ�� m2_correct_cnt : " + m2_correct_cnt);
//		
//		if (m2_correct_cnt == 0) { //������ ����
//			return;
//		}
//		
//		m2_correct_cnt--;
//		m2_correct();
//		
//		//������ ���� ���� �ִ� �ڵ�� �ʿ��� ��ŭ ����ȴ�
//		System.out.println("2��ȣ�� m2_correct_cnt : " + m2_correct_cnt);
//		
//	}
	
//	static int m2_correct2_cnt = 5;
//	static void m2_correct2() {
//		// ���������� �� ����
//		if (m2_correct2_cnt == 0) { //������ ���� (��������)
//			return;
//		}
//		
//		//������ ���� �տ� �ִ� �ڵ�� �ѹ��� ����ȴ�
//		System.out.println("1��ȣ�� m2_correct_cnt : " + m2_correct2_cnt);
//		
//		m2_correct2_cnt--;
//		m2_correct2();
//		m2_correct2_cnt++;//ȣ��ٳ����� ����
//		
//		//������ ���� ���� �ִ� �ڵ�� �ʿ��� ��ŭ ����ȴ�
//		System.out.println("2��ȣ�� m2_correct_cnt : " + m2_correct2_cnt);
//		
//	}


	static void m3(int m3_cnt) {
		//�Ķ������ m3_cnt ���� ���ȣ���� �ϸ鼭 ��� �����ؼ� ���޵� ���̴�
		
		// ���������� �� ����
		if (m3_cnt == 0) { //������ ���� (��������)
			return;
		}
		
		//�������ǳ����� �ϰ������ �Ѵ�
		//������ ���� �տ� �ִ� �ڵ�� �ѹ��� ����ȴ�
		System.out.println("1��ȣ�� m3_cnt : " + m3_cnt);

		//1�� ��� - �ߵȴ�.
//		m3_cnt--;
//		m3(m3_cnt); //===============������ ����
//		m3_cnt++;//ȣ��ٳ����� ����
		
		//2�� ���
//		m3(--m3_cnt); //=============������ ����
//		m3_cnt++;
		
		//3�� ���
		m3(m3_cnt - 1); //=============������ ����
		
//		//������ ���� ���� �ִ� �ڵ�� �ʿ��� ��ŭ ����ȴ�
//		System.out.println("2��ȣ�� m3_cnt : " + m3_cnt);
		
	}
	
	static int[] m4_intArray = {1,2,3,4,5,6,7,8,9,10};
	static int m4_even_cnt = 0;
	static int m4_even_sum = 0;
	//�̼� : m4_event_cnt, m4_even_sum ���
	//������ 0���� �Ķ���� ����
	static void m4(int m4_cnt) {
		
		
		//1. �������� (Ż���ϱ� ���� ����)
		if (m4_cnt == m4_intArray.length) { 
			
			//complete code
			System.out.println(m4_even_cnt);
			System.out.println(m4_even_sum);
			return;
		}
		
		//2. �ϰ���� �� : ¦�� cnt, sum ���
		if (m4_intArray[m4_cnt] % 2 == 0) {
			m4_even_cnt++;
			m4_even_sum += m4_intArray[m4_cnt];
		}
		//3. ���ȣ��
		m4(m4_cnt + 1);
	}
}
